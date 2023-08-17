package model.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import model.entity.Paciente;
import model.service.PacienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/listar")
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.obtenerTodosLosPacientes();
        model.addAttribute("pacientes", pacientes);
        return "listarPacientes";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPacientePorId(@PathVariable int id) {
        Optional<Paciente> paciente = pacienteService.obtenerPacientePorId(id);
        return paciente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente) {
        Paciente nuevoPaciente = pacienteService.guardarPaciente(paciente);
        return ResponseEntity.ok(nuevoPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(
            @PathVariable int id,
            @RequestBody Paciente paciente) {
        if (!pacienteService.obtenerPacientePorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        paciente.setIdPaciente(id);
        Paciente pacienteActualizado = pacienteService.guardarPaciente(paciente);
        return ResponseEntity.ok(pacienteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable int id) {
        if (!pacienteService.obtenerPacientePorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.noContent().build();
    }
}

