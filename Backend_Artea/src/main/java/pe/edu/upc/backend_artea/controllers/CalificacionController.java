package pe.edu.upc.backend_artea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend_artea.entities.Calificacion;
import pe.edu.upc.backend_artea.services.CalificacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping
    public List<Calificacion> listar() {
        return calificacionService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calificacion> obtenerPorId(@PathVariable Long id) {
        Optional<Calificacion> c = calificacionService.listById(id);
        return c.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Calificacion> registrar(@RequestBody Calificacion c) {
        return ResponseEntity.ok(calificacionService.save(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> actualizar(@PathVariable Long id, @RequestBody Calificacion c) {
        return calificacionService.listById(id)
                .map(x -> {
                    c.setId_calificacion(id);
                    return ResponseEntity.ok(calificacionService.save(c));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        calificacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
