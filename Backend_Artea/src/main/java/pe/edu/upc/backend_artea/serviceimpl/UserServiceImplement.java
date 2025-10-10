package pe.edu.upc.backend_artea.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend_artea.entities.User;
import pe.edu.upc.backend_artea.repositories.UserRepository;
import pe.edu.upc.backend_artea.services.UserService;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository uR;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> list(){
        return uR.findAll();
    }

    @Override
    public void insert(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // ← ESTA LÍNEA ES CLAVE
        uR.save(user);
    }

    @Override
    public void update(User user) {
        uR.save(user);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public List<String[]> QuantityUserByRol() {
        return uR.QuantityUserByRol();
    }

    @Override
    public User findById(int id) {
        return uR.findUserById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
