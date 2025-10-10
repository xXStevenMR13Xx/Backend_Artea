package pe.edu.upc.backend_artea.dtos;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class CreacionCreateUpdateDTO {
    private String titulo;
    private String imagenBase64; // puede ser null
    private String formato;      // ej. "image/png", "image/jpeg", etc.
}
