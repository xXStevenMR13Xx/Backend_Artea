package pe.edu.upc.backend_artea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend_artea.entities.Nivel;

import java.util.List;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Long> {

    // MÉTODO: Buscar por dificultad exacta
    List<Nivel> findByDificultad(String dificultad);

    // NATIVA: Contar niveles por dificultad
    @Query(value = "SELECT COUNT(*) FROM nivel WHERE dificultad = :dificultad", nativeQuery = true)
    int contarPorDificultad(@Param("dificultad") String dificultad);
}