package pe.edu.upc.backend_artea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend_artea.entities.Rol;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    @Query("SELECT r FROM Rol r WHERE r.id = :id")
    Optional<Rol> findRolById(@Param("id") Long id);

    // Conteo de usuarios por rol (query nativo)
    @Query(value = "SELECT r.rol, COUNT(u.id) AS total_usuarios " +
            "FROM rol r " +
            "JOIN usuario u ON r.usuario_id = u.id " +
            "GROUP BY r.rol",
            nativeQuery = true)
    List<String[]> quantityUserByRol();

    // conteo de usuarios por rol (NATIVO)
    //@Query(value = "SELECT r.rol, COUNT(u.id) AS total_usuarios\n" +
    //        "FROM rol r\n" +
    //        "JOIN usuario u ON r.id_usuario = u.id\n" +
    //        "GROUP BY r.rol;", nativeQuery = true)
    //List<String[]> quantityUserByRol();

}
