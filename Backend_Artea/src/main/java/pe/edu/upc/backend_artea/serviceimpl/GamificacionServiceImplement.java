package pe.edu.upc.backend_artea.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend_artea.entities.Gamificacion;
import pe.edu.upc.backend_artea.repositories.GamificacionRepository;
import pe.edu.upc.backend_artea.services.GamificacionService;

import java.util.List;
import java.util.Optional;

@Service
public class GamificacionServiceImplement implements GamificacionService {

    @Autowired
    private GamificacionRepository gamificacionRepository;

    @Override
    public List<Gamificacion> list() {
        return gamificacionRepository.findAll();
    }

    @Override
    public Optional<Gamificacion> listById(Long id) {
        return gamificacionRepository.findById(id);
    }

    @Override
    public Gamificacion save(Gamificacion gamificacion) {
        return gamificacionRepository.save(gamificacion);
    }

    @Override
    public void delete(Long id) {
        gamificacionRepository.deleteById(id);
    }
}
