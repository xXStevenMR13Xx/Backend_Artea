package pe.edu.upc.backend_artea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend_artea.entities.Calificacion;

import java.util.List;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {

    // MÉTODO: Buscar calificaciones por nombre exacto
    List<Calificacion> findByNombre(String nombre);

    // JPQL: Buscar calificaciones cuyo nombre contenga un texto
    @Query("SELECT c FROM Calificacion c WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Calificacion> buscarPorNombreJPQL(@Param("nombre") String nombre);
}
