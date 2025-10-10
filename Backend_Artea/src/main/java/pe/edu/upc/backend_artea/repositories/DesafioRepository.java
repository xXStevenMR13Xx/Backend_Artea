package pe.edu.upc.backend_artea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend_artea.entities.Desafio;

import java.util.List;

@Repository
public interface DesafioRepository extends JpaRepository<Desafio, Long> {
    long countByDificultad_Id(Integer dificultadId);

    // Buscar desafíos de una categoría (Method query)
    List<Desafio> findByCategoria_IdCategoria(Long idCategoria);

    // Buscar desafíos por nombre de categoría (JPQL)
    @Query("SELECT d FROM Desafio d WHERE LOWER(d.categoria.nombre_categoria) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Desafio> findByCategoriaNombreLike(@Param("nombre") String nombre);
}
