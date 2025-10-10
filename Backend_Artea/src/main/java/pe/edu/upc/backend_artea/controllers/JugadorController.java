package pe.edu.upc.backend_artea.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend_artea.dtos.JugadorCreateUpdateDTO;
import pe.edu.upc.backend_artea.dtos.JugadorDTO;
import pe.edu.upc.backend_artea.services.JugadorService;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class JugadorController {

    private final JugadorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JugadorDTO create(@RequestBody JugadorCreateUpdateDTO dto){
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public JugadorDTO update(@PathVariable Integer id,
                             @RequestBody JugadorCreateUpdateDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping
    public List<JugadorDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public JugadorDTO getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @GetMapping("/by-usuario/{userId}")
    public JugadorDTO getByUser(@PathVariable Integer userId){
        return service.getByUserId(userId);
    }

    @GetMapping("/search")
    public List<JugadorDTO> search(@RequestParam(name="pais", required=false) String pais){
        return service.searchByPais(pais);
    }
}
