package pe.edu.upc.backend_artea.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.backend_artea.entities.Desafio;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoriaDTO {
    private Long id_categoria;
    private String nombre_categoria;
    private Desafio desafio;
}
