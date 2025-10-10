package pe.edu.upc.backend_artea.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioByRolDTO {
    private String nameRol;
    private int quantityUsuario;
}
