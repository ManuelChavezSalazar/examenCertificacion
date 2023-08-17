package algoritmo;

public class Detalle {

	private Paciente paciente;
    private Medico medico;
    
    public Detalle() {
	}
    
	public Detalle(Paciente paciente, Medico medico) {
		super();
		this.paciente = paciente;
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

    
}
