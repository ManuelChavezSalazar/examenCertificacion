package model.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.entity.Especialidad;
import model.repository.IEspecialidadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {

    private final IEspecialidadRepository especialidadRepository;

    @Autowired
    public EspecialidadService(IEspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public List<Especialidad> obtenerTodasLasEspecialidades() {
        return especialidadRepository.findAll();
    }

    public Optional<Especialidad> obtenerEspecialidadPorId(int id) {
        return especialidadRepository.findById(id);
    }

    public Especialidad guardarEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public void eliminarEspecialidad(int id) {
        especialidadRepository.deleteById(id);
    }
}