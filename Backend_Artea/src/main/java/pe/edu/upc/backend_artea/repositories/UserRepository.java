package pe.edu.upc.backend_artea.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend_artea.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Contar cuantos usuarios hay por rol (NATIVO)
    @Query(value =
            "SELECT r.rol AS rol, COUNT(u.id) AS total_usuarios " +
                    "FROM usuario u " +
                    "JOIN rol r ON r.usuario_id = u.id " +   // <- FK correcta
                    "GROUP BY r.rol",
            nativeQuery = true)
    List<Object[]> countUsersByRoleNative();

    // contar cuantos usuarios tiene cada rol (NATIVO)
    //@Query(value = "SELECT r.rol AS Rol, COUNT(*) AS QuantityUsers " +
    //        "FROM rol r INNER JOIN usuario u " +
    //        "ON r.id_usuario = u.id " +
    //        "GROUP BY r.rol", nativeQuery = true)
    //List<String[]> QuantityUsuarioByRol();

}
