package es.unican.is2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConjuntoOrdenadoTest {
	
	private ConjuntoOrdenado<Integer> conOrdenado;
	
	@BeforeEach
	public void setUp() {
		conOrdenado = new ConjuntoOrdenado<Integer>();
	}
	
	@Test
	public void testAnhade() {
		assertTrue(conOrdenado.add(10));
		assertTrue(conOrdenado.add(20));
		assertTrue(conOrdenado.add(30));
		assertEquals(3, conOrdenado.size());
	}
	
	@Test
	public void testAnhadeNulo() {
		assertThrows(NullPointerException.class, () -> conOrdenado.add(null));
	}
	
	@Test
	public void testAnhadeRepetido() {
		assertTrue(conOrdenado.add(10));
		assertTrue(conOrdenado.add(20));
		assertTrue(conOrdenado.add(30));
		
		assertFalse(conOrdenado.add(10));
	}
	
	@Test
	public void testElimina() {
		conOrdenado.add(10);
		conOrdenado.add(20);
		assertEquals(20, conOrdenado.remove(1));
		assertEquals(1, conOrdenado.size());
		
	}
	
	@Test
	public void testEliminaVacio() {
		assertThrows(IndexOutOfBoundsException.class,() -> conOrdenado.remove(0));
		assertThrows(IndexOutOfBoundsException.class,() -> conOrdenado.remove(-1));
	}
	
	@Test
	public void testGetYOrden() {
		conOrdenado.add(30);
		conOrdenado.add(10);
		conOrdenado.add(20);
		
		assertEquals(30, conOrdenado.get(2));
		assertEquals(10, conOrdenado.get(0));
		assertEquals(20, conOrdenado.get(1));
	}
	
	@Test
	public void testGetVacio() {
		assertThrows(IndexOutOfBoundsException.class,() -> conOrdenado.get(0));
	}
	
	@Test
	public void testGetFueraLimites() {
		conOrdenado.add(10);
		conOrdenado.add(20);
		conOrdenado.add(30);
		
		assertThrows(IndexOutOfBoundsException.class,() -> conOrdenado.get(3));
		assertThrows(IndexOutOfBoundsException.class,() -> conOrdenado.get(-1));
	}
	
	@Test
	public void testTamanho() {
		assertEquals(0, conOrdenado.size());
		
		conOrdenado.add(10);
		conOrdenado.add(20);
		conOrdenado.add(30);
		
		assertEquals(3, conOrdenado.size());
	}
	
	@Test
	public void testClear() {
		conOrdenado.add(10);
		conOrdenado.add(20);
		conOrdenado.add(30);
		assertEquals(3, conOrdenado.size());
		conOrdenado.clear();
		assertEquals(0, conOrdenado.size());
	}
}
