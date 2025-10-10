package pe.edu.upc.backend_artea.services;

import pe.edu.upc.backend_artea.entities.Nivel;
import java.util.List;
import java.util.Optional;

public interface NivelService {
    List<Nivel> list();
    Optional<Nivel> listById(Long id);
    Nivel save(Nivel nivel);
    void delete(Long id);
}

