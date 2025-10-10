package pe.edu.upc.backend_artea.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import pe.edu.upc.backend_artea.entities.Jugador;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NivelDTO {
    private Long id_nivel;
    private String nombre_niv;
    private List<Jugador> jugadores;
}

