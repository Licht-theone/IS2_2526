package es.unican.is2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransporteTest {
	private TransportePersonas trpPers;
	private TransporteMercancias trpMerc;
	private TransportePeligrosas trpPelig;
	
	
	@BeforeEach
	public void setUp() {
		trpPers = null;
		trpPelig = null;
		trpMerc = null;
	}

    @Test
    public void testConstructor() {

        // Casos validos
        trpPers = new TransportePersonas(2, 5);
        trpMerc = new TransporteMercancias(2, 5);
        trpPelig = new TransportePeligrosas(2, 5);
        assertEquals(2, trpPers.getHoras());
        assertEquals(5, trpPers.getPersonas());
        assertEquals(2, trpMerc.getHoras());
        assertEquals(5, trpMerc.getTon());
        assertEquals(2, trpPelig.getHoras());
        assertEquals(5, trpPelig.getTon());

        // Casos no validos
        assertThrows(IllegalArgumentException.class, () -> new TransportePersonas(0, 1));
        assertThrows(IllegalArgumentException.class, () -> new TransportePersonas(1, 0));
        assertThrows(IllegalArgumentException.class, () -> new TransporteMercancias(10, 0));
        assertThrows(IllegalArgumentException.class, () -> new TransporteMercancias(0, 1));
        assertThrows(IllegalArgumentException.class, () -> new TransportePeligrosas(0, 10));
        assertThrows(IllegalArgumentException.class, () -> new TransportePeligrosas(1, 0));
    }
    
    @Test
    public void testSueldoExtra() {
    	trpPers = new TransportePersonas(2, 5);
        trpMerc = new TransporteMercancias(2, 5);
        trpPelig = new TransportePeligrosas(2, 5);
        TransportePersonas trpPersMasDeDiez = new TransportePersonas(2, 10);
        
        assertEquals(11, trpPers.calculaSueldoExtra());
        assertEquals(20, trpMerc.calculaSueldoExtra());
        assertEquals(70, trpPelig.calculaSueldoExtra());
        assertEquals(12, trpPersMasDeDiez.calculaSueldoExtra());
    }

}
