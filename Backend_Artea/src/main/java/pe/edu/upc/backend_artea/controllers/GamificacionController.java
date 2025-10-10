package pe.edu.upc.backend_artea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend_artea.entities.Gamificacion;
import pe.edu.upc.backend_artea.services.GamificacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gamificaciones")
public class GamificacionController {

    @Autowired
    private GamificacionService gamificacionService;

    @GetMapping
    public List<Gamificacion> listar() {
        return gamificacionService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gamificacion> obtenerPorId(@PathVariable Long id) {
        Optional<Gamificacion> g = gamificacionService.listById(id);
        return g.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Gamificacion> registrar(@RequestBody Gamificacion g) {
        return ResponseEntity.ok(gamificacionService.save(g));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gamificacion> actualizar(@PathVariable Long id, @RequestBody Gamificacion g) {
        return gamificacionService.listById(id)
                .map(x -> {
                    g.setId_gamificacion(id);
                    return ResponseEntity.ok(gamificacionService.save(g));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        gamificacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
