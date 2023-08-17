package algoritmo;

import java.util.List;

public class CalculoEspecialidadExperiencia implements ICalculoDescuento {

	@Override
	public double calcularDescuento(List<Detalle> detalles) {
		double porcentajeDescuento = 0.0;

        for (Detalle detalle : detalles) {
            Medico medico = detalle.getMedico();
            String especialidad = medico.getEspecialidad();
            int añosExperiencia = medico.getAñosExperiencia();

            if (añosExperiencia < 10) {
                porcentajeDescuento += 0.15; // 15% de descuento
            } else if ((especialidad.equals("Cardiólogo") || especialidad.equals("Neurólogo")) && añosExperiencia > 10 && añosExperiencia < 20) {
                porcentajeDescuento += 0.05; // 5% de descuento
            } else if ((especialidad.equals("Endocrinólogo") || especialidad.equals("Oncólogo")) && añosExperiencia > 5) {
                porcentajeDescuento += 0.10; // 10% de descuento
            } else if (especialidad.equals("Dermatólogo")) {
                // No aplicamos descuento para Dermatólogo
            } else if (añosExperiencia > 20) {
                porcentajeDescuento += 0.05; // 5% de descuento
            }
        }

        return porcentajeDescuento;
    
	}

}
