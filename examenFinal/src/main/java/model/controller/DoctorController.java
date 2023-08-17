package model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import model.entity.Doctor;
import model.service.DoctorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctores")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> obtenerTodosLosDoctores() {
        List<Doctor> doctores = doctorService.obtenerTodosLosDoctores();
        return ResponseEntity.ok(doctores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> obtenerDoctorPorId(@PathVariable int id) {
        Optional<Doctor> doctor = doctorService.obtenerDoctorPorId(id);
        return doctor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Doctor> crearDoctor(@RequestBody Doctor doctor) {
        Doctor nuevoDoctor = doctorService.guardarDoctor(doctor);
        return ResponseEntity.ok(nuevoDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> actualizarDoctor(
            @PathVariable int id,
            @RequestBody Doctor doctor) {
        if (!doctorService.obtenerDoctorPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        doctor.setIdDoctor(id);
        Doctor doctorActualizado = doctorService.guardarDoctor(doctor);
        return ResponseEntity.ok(doctorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDoctor(@PathVariable int id) {
        if (!doctorService.obtenerDoctorPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        doctorService.eliminarDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
