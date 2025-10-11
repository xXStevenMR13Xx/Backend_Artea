package pe.edu.upc.backend_artea.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend_artea.dtos.QuantityUserByRolDTO;
import pe.edu.upc.backend_artea.dtos.RolDTO;
import pe.edu.upc.backend_artea.entities.Rol;
import pe.edu.upc.backend_artea.services.RolService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolService rS;

    @GetMapping("/listar")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<RolDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void insertar(@RequestBody RolDTO dto){
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        rS.insert(r);
    }

    @PutMapping("/modificar")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody RolDTO dto){
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto,Rol.class);
        rS.update(r);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Long id){
        rS.delete(id);
    }

    @GetMapping("/totalDeUsuariosPorRol")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<QuantityUserByRolDTO> totalDeUsuariosPorRol() {
        List<String[]> filaLista = rS.quantityUserByRol();
        List<QuantityUserByRolDTO> dtoLista = new ArrayList<>();

        for (String[] columna : filaLista) {
            QuantityUserByRolDTO dto = new QuantityUserByRolDTO();
            dto.setRol(columna[0]);
            dto.setTotal_usuarios(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/listar/{id}")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public ResponseEntity<RolDTO> obtenerPorId(@PathVariable("id") Long id) {
        Rol rol = rS.findRolById(id);
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rol, RolDTO.class);
        return ResponseEntity.ok(dto);
    }
}
