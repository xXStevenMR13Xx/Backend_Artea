package pe.edu.upc.backend_artea.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import pe.edu.upc.backend_artea.entities.ProgresoDesafio;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GamificacionDTO {
    private Long id_gamificacion;
    private Integer racha_dias;
    private String notificacion;
    private List<ProgresoDesafio> progresos;
}
