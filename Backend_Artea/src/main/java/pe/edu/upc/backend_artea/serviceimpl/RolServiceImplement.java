package pe.edu.upc.backend_artea.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend_artea.entities.Rol;
import pe.edu.upc.backend_artea.repositories.RolRepository;
import pe.edu.upc.backend_artea.services.RolService;

import java.util.List;

@Service
public class RolServiceImplement implements RolService {
    @Autowired
    private RolRepository rR;

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public List<String[]> quantityUserByRol() {
        return rR.quantityUserByRol();
    }

    @Override
    public Rol findRolById(Long id) {
        return rR.findRolById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

}
