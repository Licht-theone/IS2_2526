package es.unican.is2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;


public class SeguroTest {

	@Test
	public void testPrecioValidoTodoRiesgoOferta() {
		// CE1 (TODO_RIESGO), CE4 (Potencia 100), CE6 (Menos de 1 año)
		Seguro s = new Seguro();
		s.setCobertura(Cobertura.TODO_RIESGO); //precio base 1000
		s.setPotencia(100); //5% extra por la potencia
		s.setFechaInicio(LocalDate.now().minusMonths(6)); //descuento de un 20% por menos de un año
		//espera (1000*1.05)*0.8=840
		assertEquals(840.0, s.precio(), 0.01);
	}
	
	@Test
	public void testPrecioValidoTerceroNoOferta() {
		// CE3 (TERCEROS), CE5 (Potencia 150), CE7 (Más de 1 año)
		Seguro s = new Seguro();
		s.setCobertura(Cobertura.TERCEROS); //precio base 400
		s.setPotencia(150); //20% extra por la potencia
		s.setFechaInicio(LocalDate.now().minusYears(2)); //sin descuento por antigüedad
		//espera 400*1.2=480
		assertEquals(480.0, s.precio(), 0.01);
	}
	
	@Test
	public void testPrecioValidoTercerosLunasPotenciaLimite() {
		// CE2 (TERCEROS_LUNAS), AVL de CE4 (Potencia 110), CE7 (Exactamente 1 año y 1 día)
		Seguro s = new Seguro();
		s.setCobertura(Cobertura.TERCEROS_LUNAS); //precio base 600
		s.setPotencia(110); //un 5% por la potencia
		s.setFechaInicio(LocalDate.now().minusYears(1).minusDays(1)); //sin descuento por antigüedad 
		//esperado 600*1.05=630
		assertEquals(630.0, s.precio(), 0.01);
	}
	
	@Test
	public void testPrecioSeguroNoEnVigor() {
		// CE10: Seguro que aún no ha entrado en vigor (Fecha en el futuro)
		Seguro s = new Seguro();
		s.setCobertura(Cobertura.TODO_RIESGO);
		s.setPotencia(100);
		s.setFechaInicio(LocalDate.now().plusMonths(2));
		//debe devolver 0
		assertEquals(0.0, s.precio(), 0.01);
	}
	
	@Test
	public void testPrecioSeguroEnVigor() {
		//Validacion extra para confirmar que un seguro en vigor no da 0
		Seguro s = new Seguro();
		s.setCobertura(Cobertura.TODO_RIESGO);
		s.setPotencia(100);
		s.setFechaInicio(LocalDate.now().minusDays(5));
		//debe devolver 840
		assertEquals(840.0, s.precio(), 0.01);
	}
	
	@Test
	public void testPrecioMenos90CVConOferta() {
		Seguro s = new Seguro();
		s.setCobertura(Cobertura.TERCEROS);
		s.setPotencia(89);
		s.setFechaInicio(LocalDate.now().minusMonths(2));
		//tiene que dar 400*0.8
		assertEquals(400*0.8, s.precio(), 0.01);
	}
	
	@Test
	public void testPrecioSinCobertura() {
		//test adicional para un 100% de cobertura
		Seguro s = new Seguro();
		s.setFechaInicio(LocalDate.now().minusMonths(1));
		assertEquals(0, s.precio(), 0.01);
	}
	
	@Test
	public void testPrecioPotenciaMenorA90() {
		// CE9: Coche con menos de 90 CV
		Seguro s = new Seguro();
		s.setCobertura(Cobertura.TERCEROS);
		s.setPotencia(89);
		s.setFechaInicio(LocalDate.now().minusYears(2)); //sin descuento por antigüedad
		//debe devolver 400, sin incremento por potencia ni descuento por antigüedad
		assertEquals(400.0, s.precio(), 0.01);
	}
}
