package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.entity.Doctor;
import model.repository.IDoctorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final IDoctorRepository doctorRepository;

    @Autowired
    public DoctorService(IDoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> obtenerTodosLosDoctores() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> obtenerDoctorPorId(int id) {
        return doctorRepository.findById(id);
    }

    public Doctor guardarDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void eliminarDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}
