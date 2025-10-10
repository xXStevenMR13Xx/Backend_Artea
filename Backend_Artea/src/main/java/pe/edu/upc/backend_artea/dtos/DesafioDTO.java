package pe.edu.upc.backend_artea.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.backend_artea.entities.Categoria;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DesafioDTO {
    private Long id_desafio;
    private String nombre_desafio;
    private String tipo_desafio;
    private String instruccion;
    private Integer max_intentos;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private List<Categoria> categorias;
}
