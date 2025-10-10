package pe.edu.upc.backend_artea.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.backend_artea.dtos.JugadorCreateUpdateDTO;
import pe.edu.upc.backend_artea.dtos.JugadorDTO;
import pe.edu.upc.backend_artea.entities.Jugador;
import pe.edu.upc.backend_artea.entities.User;
import pe.edu.upc.backend_artea.repositories.JugadorRepository;
import pe.edu.upc.backend_artea.repositories.UserRepository;
import pe.edu.upc.backend_artea.services.JugadorService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class JugadorServiceImplement implements JugadorService {

    private final JugadorRepository repo;
    private final UserRepository userRepo;

    private JugadorDTO toDTO(Jugador j){
        return JugadorDTO.builder()
                .id(j.getId())
                .edad(j.getEdad())
                .pais(j.getPais())
                .userId(j.getUsuario()!=null ? j.getUsuario().getId().intValue() : null)
                .username(j.getUsuario()!=null ? j.getUsuario().getUsername() : null)
                .build();
    }

    private User getUsuarioOr404(Integer userId){
        return userRepo.findById(userId.longValue()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
    }
    @Override
    public JugadorDTO create(JugadorCreateUpdateDTO dto) {
        if (dto.getEdad()==null || dto.getEdad() < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Edad inválida.");
        if (dto.getPais()==null || dto.getPais().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El país es obligatorio.");
        if (dto.getUserId()==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "userId es obligatorio.");

        // Un jugador por usuario (regla de negocio común)
        if (repo.existsByUsuario_Id(dto.getUserId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El usuario ya tiene un jugador.");

        User u = getUsuarioOr404(dto.getUserId());

        Jugador j = Jugador.builder()
                .edad(dto.getEdad())
                .pais(dto.getPais().trim())
                .usuario(u)
                .build();

        return toDTO(repo.save(j));
    }

    @Override
    public JugadorDTO update(Integer id, JugadorCreateUpdateDTO dto) {
        Jugador j = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado"));

        if (dto.getEdad()!=null) {
            if (dto.getEdad()<0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Edad inválida.");
            j.setEdad(dto.getEdad());
        }
        if (dto.getPais()!=null && !dto.getPais().isBlank()) {
            j.setPais(dto.getPais().trim());
        }
        if (dto.getUserId()!=null) {
            // Si permites cambiar de usuario, valida que el nuevo no tenga jugador
            if (repo.existsByUsuario_Id(dto.getUserId()) &&
                    !j.getUsuario().getId().equals(dto.getUserId().longValue())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "El nuevo usuario ya tiene un jugador.");
            }
            j.setUsuario(getUsuarioOr404(dto.getUserId()));
        }
        return toDTO(repo.save(j));
    }

    @Override
    public void delete(Integer id) {
        if (!repo.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado");
        // (Opcional) validar referencias en Logro/ProgresoDesafio antes de borrar
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public JugadorDTO getById(Integer id) {
        return repo.findById(id).map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado"));
    }

    @Override
    @Transactional(readOnly = true)
    public JugadorDTO getByUserId(Integer userId) {
        return repo.findByUsuario_Id(userId).map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado para ese usuario"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<JugadorDTO> listAll() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<JugadorDTO> searchByPais(String q) {
        return repo.findByPaisContainingIgnoreCase(q==null? "": q).stream()
                .map(this::toDTO).toList();
    }
}
