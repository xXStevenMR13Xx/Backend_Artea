package pe.edu.upc.backend_artea.services;

import pe.edu.upc.backend_artea.entities.User;

import java.util.List;

public interface UserService {
    public List<User> list();
    public void insert(User user);
    public void update(User user);
    public void delete(Long id);
    public List<String[]> QuantityUserByRol();
    public User findById(int id);
}
