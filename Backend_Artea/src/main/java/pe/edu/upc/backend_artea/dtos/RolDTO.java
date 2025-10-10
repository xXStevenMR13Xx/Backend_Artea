package pe.edu.upc.backend_artea.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.backend_artea.entities.User;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RolDTO {
    private Long id;
    private String rol;
    private User user;
}
