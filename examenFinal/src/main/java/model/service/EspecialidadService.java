package model.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.entity.Especialidad;
import model.repository.IEspecialidadRepository;


@Service
public class EspecialidadService {

    @Autowired
    private IEspecialidadRepository especialidadRepository;

    public List<Especialidad> listarEspecialidades() {
        return especialidadRepository.findAll();
    }

    public Especialidad obtenerEspecialidadPorId(int idEspecialidad) {
        return especialidadRepository.findById(idEspecialidad).orElse(null);
    }

    public void guardarEspecialidad(Especialidad especialidad) {
        especialidadRepository.save(especialidad);
    }

    public void eliminarEspecialidad(int idEspecialidad) {
        especialidadRepository.deleteById(idEspecialidad);
    }
}