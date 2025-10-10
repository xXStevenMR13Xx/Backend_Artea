package pe.edu.upc.backend_artea.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.backend_artea.dtos.DificultadCreateUpdateDTO;
import pe.edu.upc.backend_artea.dtos.DificultadDTO;
import pe.edu.upc.backend_artea.entities.Dificultad;
import pe.edu.upc.backend_artea.repositories.DificultadRepository;
import pe.edu.upc.backend_artea.repositories.DesafioRepository; // <- opcional si validas uso
import pe.edu.upc.backend_artea.services.DificultadService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DificultadServiceImplement implements DificultadService {

    private final DificultadRepository repo;
    private final DesafioRepository desafioRepo; // si no la usarás, elimínala

    private DificultadDTO toDTO(Dificultad d) {
        return DificultadDTO.builder()
                .id(d.getId())
                .tipo(d.getTipo())
                .build();
    }

    @Override
    public DificultadDTO create(DificultadCreateUpdateDTO dto) {
        if (dto.getTipo()==null || dto.getTipo().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El tipo es obligatorio.");

        repo.findByTipoIgnoreCase(dto.getTipo().trim())
                .ifPresent(x -> { throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe esa dificultad."); });

        Dificultad d = Dificultad.builder()
                .tipo(dto.getTipo().trim())
                .build();

        return toDTO(repo.save(d));
    }

    @Override
    public DificultadDTO update(Integer id, DificultadCreateUpdateDTO dto) {
        Dificultad d = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Dificultad no encontrada"));

        if (dto.getTipo()!=null && !dto.getTipo().isBlank()) {
            String nuevo = dto.getTipo().trim();
            repo.findByTipoIgnoreCase(nuevo).ifPresent(existente -> {
                if (!existente.getId().equals(id))
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe esa dificultad.");
            });
            d.setTipo(nuevo);
        }
        return toDTO(repo.save(d));
    }

    @Override
    public void delete(Integer id) {
        Dificultad d = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Dificultad no encontrada"));

        // Validación opcional: no borrar si está en uso por Desafio
        long usados = desafioRepo.countByDificultad_Id(id);
        if (usados > 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "No se puede eliminar: hay " + usados + " desafíos usando esta dificultad.");
        }
        repo.delete(d);
    }

    @Override
    @Transactional(readOnly = true)
    public DificultadDTO getById(Integer id) {
        return repo.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dificultad no encontrada"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DificultadDTO> listAll() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DificultadDTO> searchByTipo(String q) {
        return repo.findByTipoContainingIgnoreCase(q==null? "": q)
                .stream().map(this::toDTO).toList();
    }
}
