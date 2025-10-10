package pe.edu.upc.backend_artea.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.backend_artea.entities.Rol;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListarUsuarioDTO {
    private Long id;
    private String username;
    private Boolean enabled;
    private List<Rol> roles;
}
