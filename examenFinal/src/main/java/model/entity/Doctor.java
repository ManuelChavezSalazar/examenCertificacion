package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDoctor;
    @Column(name = "Nombre")
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "Especialidad_ID")
    private Especialidad especialidad;
    
    @Column(name = "Experiencia")
    private int experiencia;
    
    public Doctor() {
    }

 

// Constructor, getters y setters
 
 public int getIdDoctor() {
     return idDoctor;
 }

 public void setIdDoctor(int idDoctor) {
     this.idDoctor = idDoctor;
 }

 public String getNombre() {
     return nombre;
 }

 public void setNombre(String nombre) {
     this.nombre = nombre;
 }

 public Especialidad getEspecialidad() {
     return especialidad;
 }

 public void setEspecialidad(Especialidad especialidad) {
     this.especialidad = especialidad;
 }

 public int getExperiencia() {
     return experiencia;
 }

 public void setExperiencia(int experiencia) {
     this.experiencia = experiencia;
 }
}
