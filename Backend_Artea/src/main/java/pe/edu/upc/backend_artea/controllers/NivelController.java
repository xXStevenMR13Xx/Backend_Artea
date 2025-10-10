package pe.edu.upc.backend_artea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend_artea.entities.Nivel;
import pe.edu.upc.backend_artea.services.NivelService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/niveles")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @GetMapping
    public List<Nivel> listar() {
        return nivelService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nivel> obtenerPorId(@PathVariable Long id) {
        Optional<Nivel> nivel = nivelService.listById(id);
        return nivel.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Nivel> registrar(@RequestBody Nivel nivel) {
        return ResponseEntity.ok(nivelService.save(nivel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nivel> actualizar(@PathVariable Long id, @RequestBody Nivel nivel) {
        return nivelService.listById(id)
                .map(n -> {
                    nivel.setId_nivel(id);
                    return ResponseEntity.ok(nivelService.save(nivel));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        nivelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
