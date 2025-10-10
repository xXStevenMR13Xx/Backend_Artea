package pe.edu.upc.backend_artea.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgresoDesafioDTO {
    private Long id_progresoDesafio;
    private String tipo_progreso;
    private LocalDate fecha_progreso;
    private String estado;
    private String puntuacion;
    private int feedback;
}
