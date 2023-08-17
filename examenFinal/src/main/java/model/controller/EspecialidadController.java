package model.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import model.entity.Especialidad;
import model.service.EspecialidadService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    private final EspecialidadService especialidadService;

    @Autowired
    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping
    public ResponseEntity<List<Especialidad>> obtenerTodasLasEspecialidades() {
        List<Especialidad> especialidades = especialidadService.obtenerTodasLasEspecialidades();
        return ResponseEntity.ok(especialidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> obtenerEspecialidadPorId(@PathVariable int id) {
        Optional<Especialidad> especialidad = especialidadService.obtenerEspecialidadPorId(id);
        return especialidad.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Especialidad> crearEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad nuevaEspecialidad = especialidadService.guardarEspecialidad(especialidad);
        return ResponseEntity.ok(nuevaEspecialidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> actualizarEspecialidad(
            @PathVariable int id,
            @RequestBody Especialidad especialidad) {
        if (!especialidadService.obtenerEspecialidadPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        especialidad.setIdEspecialidad(id);
        Especialidad especialidadActualizada = especialidadService.guardarEspecialidad(especialidad);
        return ResponseEntity.ok(especialidadActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEspecialidad(@PathVariable int id) {
        if (!especialidadService.obtenerEspecialidadPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        especialidadService.eliminarEspecialidad(id);
        return ResponseEntity.noContent().build();
    }
}
