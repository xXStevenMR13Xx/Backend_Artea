package pe.edu.upc.backend_artea.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityUserByRolDTO {
    private String rol;
    private int total_usuarios;
}
