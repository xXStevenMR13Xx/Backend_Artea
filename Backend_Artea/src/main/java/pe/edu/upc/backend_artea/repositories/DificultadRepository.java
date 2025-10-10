package pe.edu.upc.backend_artea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend_artea.entities.Dificultad;

import java.util.List;
import java.util.Optional;

@Repository
public interface DificultadRepository extends JpaRepository<Dificultad, Integer> {
    List<Dificultad> findByTipoContainingIgnoreCase(String tipo);
    Optional<Dificultad> findByTipoIgnoreCase(String tipo);
}
