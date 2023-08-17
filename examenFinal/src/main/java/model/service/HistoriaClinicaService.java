package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.entity.HistoriaClinica;
import model.repository.IHistoriaClinicaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaClinicaService {

    private final IHistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    public HistoriaClinicaService(IHistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    public List<HistoriaClinica> obtenerTodasLasHistoriasClinicas() {
        return historiaClinicaRepository.findAll();
    }

    public Optional<HistoriaClinica> obtenerHistoriaClinicaPorId(int id) {
        return historiaClinicaRepository.findById(id);
    }

    public HistoriaClinica guardarHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    public void eliminarHistoriaClinica(int id) {
        historiaClinicaRepository.deleteById(id);
    }
}
