package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.time.LocalDate;


@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaciente;
    @Column(name = "Nombre")
	private String nombrePaciente;
    @Column(name = "Fecha_Nacimiento")
	private LocalDate fechaNacimiento;
    
    // Constructor, getters y setters
    
    public Paciente() {

	}

	public Paciente(String nombrePaciente, LocalDate fechaNacimiento) {
        this.nombrePaciente = nombrePaciente;
        this.fechaNacimiento = fechaNacimiento;
    }

	public int getIdPaciente() {
		return idPaciente;
	}

    public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

    public String getNombrePaciente() {
		return nombrePaciente;
	}

    public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

    public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
