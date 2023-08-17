package algoritmo;

import java.util.ArrayList;
import java.util.List;

public class DescuentoMain {

	public static void main(String[] args) {
		System.out.println("-----------------------------------------------");

		Paciente paciente1 = new Paciente(2);
		Paciente paciente2 = new Paciente(34);
		Paciente paciente3 = new Paciente(54);
		Paciente paciente4 = new Paciente(15);
		Paciente paciente5 = new Paciente(65);
		Paciente paciente6 = new Paciente(8);
		Paciente paciente7 = new Paciente(25);
		Paciente paciente8 = new Paciente(15);
		Paciente paciente9 = new Paciente(40);
		Paciente paciente10 = new Paciente(55);

		Medico medico1 = new Medico("Pediatra", 2);
		Medico medico2 = new Medico("Traumatólogo", 10);
		Medico medico3 = new Medico("Nutricionista", 6);
		Medico medico4 = new Medico("Psicólogo", 9);
		Medico medico5 = new Medico("Cardiólogo", 4);
		Medico medico6 = new Medico("Pediatra", 3);
		Medico medico7 = new Medico("Cirujano", 20);
		Medico medico8 = new Medico("Ginecólogo", 10);
		Medico medico9 = new Medico("Ortopedista", 18);
		Medico medico10 = new Medico("Psiquiatra", 6);
		
		List<Detalle> detalles = new ArrayList<>();
		detalles.add(new Detalle(paciente1, medico1));
		detalles.add(new Detalle(paciente2, medico2));
		detalles.add(new Detalle(paciente3, medico3));
		detalles.add(new Detalle(paciente4, medico4));
		detalles.add(new Detalle(paciente5, medico5));
		detalles.add(new Detalle(paciente6, medico6));
		detalles.add(new Detalle(paciente7, medico7));
		detalles.add(new Detalle(paciente8, medico8));
		detalles.add(new Detalle(paciente9, medico9));
		detalles.add(new Detalle(paciente10, medico10));

		ICalculoDescuento calculoEdad = new CalculoEdad();
        double descuentoCalculoEdad = calculoEdad.calcularDescuento(detalles);

        ICalculoDescuento calculoEspecialidadExperiencia = new CalculoEspecialidadExperiencia();
        double descuentoCalculoEspecialidadExperiencia = calculoEspecialidadExperiencia.calcularDescuento(detalles);


        System.out.println("Descuento total basado en la edad de los pacientes: " + (descuentoCalculoEdad * 100) + "%");
        System.out.println("Descuento total basado en la especialidad y experiencia de los médicos: " + (descuentoCalculoEspecialidadExperiencia * 100) + "%");

		System.out.println("-----------------------------------------------");
	}

}
