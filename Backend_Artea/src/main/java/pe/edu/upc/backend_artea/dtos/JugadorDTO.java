package pe.edu.upc.backend_artea.dtos;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class JugadorDTO {
    private Integer id;
    private Integer edad;
    private String pais;
    private Integer userId;
    private String username;
}
