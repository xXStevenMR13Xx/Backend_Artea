package pe.edu.upc.backend_artea.dtos;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class JugadorCreateUpdateDTO {
    private Integer edad;
    private String pais;
    private Integer userId; // usuario dueño del jugador
}
