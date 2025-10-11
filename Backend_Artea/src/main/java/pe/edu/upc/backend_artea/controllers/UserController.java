package pe.edu.upc.backend_artea.controllers;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend_artea.dtos.ListarUsuarioDTO;
import pe.edu.upc.backend_artea.dtos.UserDTO;
import pe.edu.upc.backend_artea.dtos.UsuarioByRolDTO;
import pe.edu.upc.backend_artea.entities.Rol;
import pe.edu.upc.backend_artea.entities.User;
import pe.edu.upc.backend_artea.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
@Slf4j
public class UserController {
    @Autowired
    private UserService uS;

    @GetMapping("/listar")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<ListarUsuarioDTO> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ListarUsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody UserDTO dto){
        ModelMapper m = new ModelMapper();
        User u = m.map(dto, User.class);
        if (u.getRoles() != null) {
            for (Rol r : u.getRoles()) {
                r.setUser(u);
                r.setId(null);
            }
        }
        uS.insert(u);
    }


    @PutMapping("/modificar")
    // @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'TURISTA', 'CONDUCTOR')")
    public void modificar(@RequestBody UserDTO dto){
        ModelMapper m = new ModelMapper();
        User u = m.map(dto,User.class);
        uS.update(u);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'TURISTA', 'CONDUCTOR')")
    public void eliminar(@PathVariable("id") Long id){
        uS.delete(id);
    }

    @GetMapping("/usuarioRol")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<UsuarioByRolDTO> query1() {
        List<String[]> filaLista = uS.QuantityUserByRol();
        List<UsuarioByRolDTO> dtoLista = new ArrayList<>();

        for (String[] columna : filaLista) {
            UsuarioByRolDTO dto = new UsuarioByRolDTO();
            dto.setNameRol(columna[0]);
            dto.setQuantityUsuario(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/listar/{id}")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ResponseEntity<ListarUsuarioDTO> obtenerPorId(@PathVariable("id") int id) {
        User user = uS.findById(id);
        ModelMapper m = new ModelMapper();
        ListarUsuarioDTO dto = m.map(user, ListarUsuarioDTO.class);
        return ResponseEntity.ok(dto);
    }
}
