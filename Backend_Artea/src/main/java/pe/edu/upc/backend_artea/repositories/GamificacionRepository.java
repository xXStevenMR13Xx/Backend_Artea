package pe.edu.upc.backend_artea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend_artea.entities.Gamificacion;

import java.util.List;

@Repository
public interface GamificacionRepository extends JpaRepository<Gamificacion, Long> {

    // MÉTODO: Buscar por tipo de gamificación
    List<Gamificacion> findByTipo(String tipo);

    // NATIVA: Obtener las 3 gamificaciones con mayor puntaje
    @Query(value = "SELECT * FROM gamificacion ORDER BY puntaje DESC LIMIT 3", nativeQuery = true)
    List<Gamificacion> top3Gamificaciones();
}

