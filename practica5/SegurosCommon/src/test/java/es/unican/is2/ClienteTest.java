package es.unican.is2;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {
	private List<Seguro> seguros = new LinkedList<Seguro>();
	private Cliente c;
	@BeforeEach
	public void setUp() {
		//prepara tres seguros para las pruebas
		Seguro s1 = new Seguro();
		Seguro s2 = new Seguro();
		Seguro s3 = new Seguro();
		s1.setCobertura(Cobertura.TERCEROS);
		s2.setCobertura(Cobertura.TERCEROS_LUNAS);
		s3.setCobertura(Cobertura.TODO_RIESGO);
		s1.setPotencia(80);
		s2.setPotencia(100);
		s3.setPotencia(140);
		s1.setFechaInicio(LocalDate.now().minusYears(2));
		s2.setFechaInicio(LocalDate.now().minusYears(2));
		s3.setFechaInicio(LocalDate.now().minusYears(2));
		seguros.add(s1);
		seguros.add(s2);
		seguros.add(s3);
		c = new Cliente();
		c.setSeguros(seguros);
	}
	
	@Test
	public void testTotalSinMinusValía() {
		//sin minusvalia
		c.setMinusvalia(false);
		//el precio debe ser 400 + 600*1.05 + 1000*1.2=2230
		assertEquals(2230.0, c.totalSeguros(), 0.01);
	}
	
	@Test
	public void testTotalConMinusvalía() {
		//con minusvalía
		c.setMinusvalia(true);
		//el precio va a ser 400*0.75 + (600*1.05)*0.75 + (1000*1.2)*0.75=1672,5
		assertEquals(1672.5, c.totalSeguros(), 0.01);
	}
	
	@Test
	public void testTotalSinSeguros() {
		// sin seguros
		c.setSeguros(null);
		assertEquals(0.0, c.totalSeguros(), 0.01);
	}
	
}
