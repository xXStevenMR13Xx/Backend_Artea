package pe.edu.upc.backend_artea.services;

import pe.edu.upc.backend_artea.entities.Calificacion;
import java.util.List;
import java.util.Optional;

public interface CalificacionService {
    List<Calificacion> list();
    Optional<Calificacion> listById(Long id);
    Calificacion save(Calificacion calificacion);
    void delete(Long id);
}
