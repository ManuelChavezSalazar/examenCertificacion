package algoritmo;

import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.Test;


class DescuentoTest {

	
	
	@Test
	
    public void testDescuentoEdad() {
        Paciente paciente = new Paciente(10);
        Medico medico = new Medico("Pediatra", 5);
        Detalle detalle = new Detalle(paciente, medico);

        ICalculoDescuento calculoEdad = new CalculoEdad();
        double descuento = calculoEdad.calcularDescuento(List.of(detalle));

        assertEquals(0.03, descuento); // Verifica que el descuento sea el esperado
    }

    
	@Test
    public void testDescuentoEspecialidadExperiencia() {
        Paciente paciente = new Paciente(30);
        Medico medico = new Medico("Cardiólogo", 15);
        Detalle detalle = new Detalle(paciente, medico);

        ICalculoDescuento calculoEspecialidadExperiencia = new CalculoEspecialidadExperiencia();
        double descuento = calculoEspecialidadExperiencia.calcularDescuento(List.of(detalle));

        assertEquals(0.05, descuento); // Verifica que el descuento sea el esperado
    }


}
