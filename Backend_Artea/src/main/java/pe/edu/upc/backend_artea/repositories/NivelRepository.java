package pe.edu.upc.backend_artea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend_artea.entities.Nivel;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Long> {
}