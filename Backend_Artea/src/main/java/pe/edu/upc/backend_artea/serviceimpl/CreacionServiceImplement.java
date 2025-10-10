package pe.edu.upc.backend_artea.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import pe.edu.upc.backend_artea.dtos.CreacionCreateUpdateDTO;
import pe.edu.upc.backend_artea.dtos.CreacionDTO;
import pe.edu.upc.backend_artea.entities.Creacion;
import pe.edu.upc.backend_artea.repositories.CreacionRepository;
import pe.edu.upc.backend_artea.services.CreacionService;

import java.util.Base64;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CreacionServiceImplement implements CreacionService {

    private final CreacionRepository repo;

    private CreacionDTO toDTO(Creacion c, boolean includeImage) {
        return CreacionDTO.builder()
                .id(c.getId())
                .titulo(c.getTitulo())
                .formato(c.getFormato())
                .imagenBase64(includeImage && c.getImagen()!=null
                        ? Base64.getEncoder().encodeToString(c.getImagen())
                        : null)
                .build();
    }

    private byte[] decode(String base64) {
        if (base64 == null || base64.isBlank()) return null;
        return Base64.getDecoder().decode(base64);
    }

    @Override
    public CreacionDTO create(CreacionCreateUpdateDTO dto) {
        if (dto.getTitulo()==null || dto.getTitulo().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El título es obligatorio.");

        Creacion c = Creacion.builder()
                .titulo(dto.getTitulo().trim())
                .formato(dto.getFormato())
                .imagen(decode(dto.getImagenBase64()))
                .build();

        repo.save(c);
        return toDTO(c, false);
    }

    @Override
    public CreacionDTO update(Integer id, CreacionCreateUpdateDTO dto) {
        Creacion c = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Creación no encontrada"));

        if (dto.getTitulo()!=null)  c.setTitulo(dto.getTitulo().trim());
        if (dto.getFormato()!=null) c.setFormato(dto.getFormato());
        if (dto.getImagenBase64()!=null) c.setImagen(decode(dto.getImagenBase64()));

        return toDTO(repo.save(c), false);
    }

    @Override
    public void delete(Integer id) {
        if (!repo.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Creación no encontrada");
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CreacionDTO getById(Integer id) {
        Creacion c = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Creación no encontrada"));
        return toDTO(c, true); // si se consulta por id, devolvemos imagen
    }

    @Override
    @Transactional(readOnly = true)
    public List<CreacionDTO> listAll() {
        // en listado no enviamos la imagen para no cargar demasiado
        return repo.findAll().stream().map(c -> toDTO(c, false)).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CreacionDTO> searchByTitulo(String q) {
        return repo.findByTituloContainingIgnoreCase(q==null?"":q)
                .stream().map(c -> toDTO(c, false)).toList();
    }
}
