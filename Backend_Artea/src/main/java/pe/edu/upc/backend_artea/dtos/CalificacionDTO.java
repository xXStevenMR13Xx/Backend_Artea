package pe.edu.upc.backend_artea.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.backend_artea.entities.ProgresoDesafio;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalificacionDTO {
    private Long id_calificacion;
    private String nombre;
    private List<ProgresoDesafio> progresos;
}
