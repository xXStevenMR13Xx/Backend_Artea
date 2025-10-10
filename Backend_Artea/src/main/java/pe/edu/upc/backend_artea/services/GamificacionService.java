package pe.edu.upc.backend_artea.services;

import pe.edu.upc.backend_artea.entities.Gamificacion;
import java.util.List;
import java.util.Optional;

public interface GamificacionService {
    List<Gamificacion> list();
    Optional<Gamificacion> listById(Long id);
    Gamificacion save(Gamificacion gamificacion);
    void delete(Long id);
}
