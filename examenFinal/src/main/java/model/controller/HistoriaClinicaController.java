package model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import model.entity.HistoriaClinica;
import model.service.HistoriaClinicaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historias-clinicas")
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;

    @Autowired
    public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService) {
        this.historiaClinicaService = historiaClinicaService;
    }

    @GetMapping
    public ResponseEntity<List<HistoriaClinica>> obtenerTodasLasHistoriasClinicas() {
        List<HistoriaClinica> historiasClinicas = historiaClinicaService.obtenerTodasLasHistoriasClinicas();
        return ResponseEntity.ok(historiasClinicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> obtenerHistoriaClinicaPorId(@PathVariable int id) {
        Optional<HistoriaClinica> historiaClinica = historiaClinicaService.obtenerHistoriaClinicaPorId(id);
        return historiaClinica.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistoriaClinica> crearHistoriaClinica(@RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica nuevaHistoriaClinica = historiaClinicaService.guardarHistoriaClinica(historiaClinica);
        return ResponseEntity.ok(nuevaHistoriaClinica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriaClinica> actualizarHistoriaClinica(
            @PathVariable int id,
            @RequestBody HistoriaClinica historiaClinica) {
        if (!historiaClinicaService.obtenerHistoriaClinicaPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        historiaClinica.setIdHistorialMedico(id);
        HistoriaClinica historiaClinicaActualizada = historiaClinicaService.guardarHistoriaClinica(historiaClinica);
        return ResponseEntity.ok(historiaClinicaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHistoriaClinica(@PathVariable int id) {
        if (!historiaClinicaService.obtenerHistoriaClinicaPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        historiaClinicaService.eliminarHistoriaClinica(id);
        return ResponseEntity.noContent().build();
    }
}
