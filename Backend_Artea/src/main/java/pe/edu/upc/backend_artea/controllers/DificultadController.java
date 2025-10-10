package pe.edu.upc.backend_artea.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend_artea.dtos.DificultadCreateUpdateDTO;
import pe.edu.upc.backend_artea.dtos.DificultadDTO;
import pe.edu.upc.backend_artea.services.DificultadService;

import java.util.List;

@RestController
@RequestMapping("/api/dificultades")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DificultadController {

    private final DificultadService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DificultadDTO create(@RequestBody DificultadCreateUpdateDTO dto){
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public DificultadDTO update(@PathVariable Integer id,
                                @RequestBody DificultadCreateUpdateDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping
    public List<DificultadDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public DificultadDTO getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @GetMapping("/search")
    public List<DificultadDTO> search(@RequestParam(name="q", required=false) String q){
        return service.searchByTipo(q);
    }
}
