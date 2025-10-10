package pe.edu.upc.backend_artea.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend_artea.entities.Calificacion;
import pe.edu.upc.backend_artea.repositories.CalificacionRepository;
import pe.edu.upc.backend_artea.services.CalificacionService;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServiceImplement implements CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public List<Calificacion> list() {
        return calificacionRepository.findAll();
    }

    @Override
    public Optional<Calificacion> listById(Long id) {
        return calificacionRepository.findById(id);
    }

    @Override
    public Calificacion save(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public void delete(Long id) {
        calificacionRepository.deleteById(id);
    }
}
