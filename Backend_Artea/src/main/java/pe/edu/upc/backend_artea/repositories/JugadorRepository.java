package pe.edu.upc.backend_artea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend_artea.entities.Jugador;

import java.util.List;
import java.util.Optional;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    List<Jugador> findByPaisContainingIgnoreCase(String pais);
    Optional<Jugador> findByUsuario_Id(Integer userId);
    boolean existsByUsuario_Id(Integer userId);
}
