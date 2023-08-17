package model.entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorialMedico;
    
    @ManyToOne
    @JoinColumn(name = "Paciente_ID")
    private Paciente paciente;
    
    @ManyToOne
    @JoinColumn(name = "Doctor_ID")
    private Doctor doctor;
    @Column(name = "Fecha_Cita")
	private LocalDate fechaCita;
	@Column(name = "Sintomas")
	private String sintomas;
	@Column(name = "Diagnostico")
	private String diagnostico;
	@Column(name = "Tratamiento")
	private String tratamiento;
    
    public HistoriaClinica() {
    	
    }
    
	
public HistoriaClinica(int iD, Paciente paciente, Doctor doctor, LocalDate fechaCita, String sintomas,
			String diagnostico, String tratamiento) {
		
		this.paciente = paciente;
		this.doctor = doctor;
		this.fechaCita = fechaCita;
	    this.sintomas = sintomas;
	    this.diagnostico = diagnostico;
	    this.tratamiento = tratamiento;
	}
// Constructor, getters y setters
    
public int getIdHistorialMedico() {
    return idHistorialMedico;
}

public void setIdHistorialMedico(int idHistorialMedico) {
    this.idHistorialMedico = idHistorialMedico;
}

public Paciente getPaciente() {
    return paciente;
}

public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
}

public LocalDate getFechaCita() {
    return fechaCita;
}

public void setFechaCita(LocalDate fechaCita) {
    this.fechaCita = fechaCita;
}

public String getSintomas() {
    return sintomas;
}

public void setSintomas(String sintomas) {
    this.sintomas = sintomas;
}

public String getDiagnostico() {
    return diagnostico;
}

public void setDiagnostico(String diagnostico) {
    this.diagnostico = diagnostico;
}

public String getTratamiento() {
    return tratamiento;
}

public void setTratamiento(String tratamiento) {
    this.tratamiento = tratamiento;
}

    
    
}
