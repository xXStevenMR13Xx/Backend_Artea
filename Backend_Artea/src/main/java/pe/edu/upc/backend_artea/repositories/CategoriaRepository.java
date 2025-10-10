package pe.edu.upc.backend_artea.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend_artea.entities.Categoria;
import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Buscar categoría por nombre (usa nombre_categoria)
    List<Categoria> findByNombreCategoriaContainingIgnoreCase(String nombre_categoria);

    // Contar desafíos por categoría (JPQL)
    @Query("SELECT c, COUNT(d) FROM Categoria c LEFT JOIN c.desafios d GROUP BY c ORDER BY COUNT(d) DESC")
    List<Object[]> findCategoriasConConteoDesafios();
}
