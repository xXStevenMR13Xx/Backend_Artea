package pe.edu.upc.backend_artea.services;
import pe.edu.upc.backend_artea.entities.Rol;
import java.util.List;

public interface RolService {
    public List<Rol> list();
    public void insert(Rol rol);
    public void update(Rol rol);
    public void delete(int id);
    List<String[]> quantityUserByRol();
    public Rol findRolById(Long id);
}
