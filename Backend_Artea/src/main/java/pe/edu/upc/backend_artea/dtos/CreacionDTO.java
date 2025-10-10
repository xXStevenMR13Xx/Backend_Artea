package pe.edu.upc.backend_artea.dtos;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class CreacionDTO {
    private Integer id;
    private String titulo;
    private String imagenBase64; // opcional en respuestas/listados
    private String formato;
}
