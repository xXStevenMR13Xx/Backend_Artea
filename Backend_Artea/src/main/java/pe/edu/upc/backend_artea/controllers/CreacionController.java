package pe.edu.upc.backend_artea.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend_artea.dtos.CreacionCreateUpdateDTO;
import pe.edu.upc.backend_artea.dtos.CreacionDTO;
import pe.edu.upc.backend_artea.services.CreacionService;

import java.util.List;

@RestController
@RequestMapping("/api/creaciones")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CreacionController {

    private final CreacionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreacionDTO create(@RequestBody CreacionCreateUpdateDTO dto){
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public CreacionDTO update(@PathVariable Integer id,
                              @RequestBody CreacionCreateUpdateDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping
    public List<CreacionDTO> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public CreacionDTO getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @GetMapping("/search")
    public List<CreacionDTO> search(@RequestParam(name="q", required=false) String q){
        return service.searchByTitulo(q);
    }

    /* Endpoint opcional para obtener solo la imagen como bytes (útil para <img src>)
       GET /api/creaciones/{id}/imagen -> image/*
    */
    @GetMapping(value="/{id}/imagen", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getImage(@PathVariable Integer id){
        return service.getById(id).getImagenBase64() == null ? new byte[0]
                : java.util.Base64.getDecoder().decode(service.getById(id).getImagenBase64());
    }
}
