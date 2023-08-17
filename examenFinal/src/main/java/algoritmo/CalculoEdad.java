package algoritmo;

import java.util.List;

public class CalculoEdad implements ICalculoDescuento{

	@Override
	public double calcularDescuento(List<Detalle> detalles) {
		double porcentajeDescuento = 0.0;

        for (Detalle detalle : detalles) {
            Paciente paciente = detalle.getPaciente();
            int edad = paciente.getEdad();

            if (edad <= 5) {
                porcentajeDescuento += 0.05; // 5% de descuento
            } else if (edad > 5 && edad < 13) {
                porcentajeDescuento += 0.03; // 3% de descuento
            } else if (edad >= 35 && edad < 60) {
                porcentajeDescuento += 0.10; // 10% de descuento
            } else if (edad >= 60) {
                porcentajeDescuento += 0.30; // 30% de descuento
            }
            // No aplicamos descuento para edades entre 13 y 35
        }

        return porcentajeDescuento;
    }

}
