package model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.entity.HistoriaClinica;

public interface IHistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Integer> {
    // Puedes agregar métodos personalizados de consulta aquí si es necesario
}

