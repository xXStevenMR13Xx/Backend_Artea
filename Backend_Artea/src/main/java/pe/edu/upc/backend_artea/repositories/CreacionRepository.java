package pe.edu.upc.backend_artea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend_artea.entities.Creacion;

import java.util.List;

@Repository
public interface CreacionRepository extends JpaRepository<Creacion, Integer> {
    List<Creacion> findByTituloContainingIgnoreCase(String titulo);
}
