package algoritmo;

public class Medico {
	private String especialidad;
    private int añosExperiencia;
    
    public Medico() {
	}
    
	public Medico(String especialidad, int añosExperiencia) {
		super();
		this.especialidad = especialidad;
		this.añosExperiencia = añosExperiencia;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public int getAñosExperiencia() {
		return añosExperiencia;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public void setAñosExperiencia(int añosExperiencia) {
		this.añosExperiencia = añosExperiencia;
	}

}
