package pe.edu.upc.backend_artea.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend_artea.entities.Nivel;
import pe.edu.upc.backend_artea.repositories.NivelRepository;
import pe.edu.upc.backend_artea.services.NivelService;

import java.util.List;
import java.util.Optional;

@Service
public class NivelServiceImplement implements NivelService {

    @Autowired
    private NivelRepository nivelRepository;

    @Override
    public List<Nivel> list() {
        return nivelRepository.findAll();
    }

    @Override
    public Optional<Nivel> listById(Long id) {
        return nivelRepository.findById(id);
    }

    @Override
    public Nivel save(Nivel nivel) {
        return nivelRepository.save(nivel);
    }

    @Override
    public void delete(Long id) {
        nivelRepository.deleteById(id);
    }
}
