import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.ClientesDAO;
import es.unican.is2.GestionSeguros;
import es.unican.is2.IClientesDAO;
import es.unican.is2.ISegurosDAO;
import es.unican.is2.SegurosDAO;
import es.unican.is2.VistaAgente;
public class TestITVistaAgente {
	
	private FrameFixture ventana;
	private VistaAgente vista;
	
	@BeforeEach
	public void setUp() {
		IClientesDAO clientesDAO = new ClientesDAO();
		ISegurosDAO segurosDAO = new SegurosDAO();
		
		GestionSeguros gestion = new GestionSeguros(clientesDAO, segurosDAO);
		vista = new VistaAgente(gestion, gestion, gestion);
		ventana = new FrameFixture(vista);
		ventana.show();
	}
	
	@AfterEach
	public void cleanUp() {
		ventana.cleanUp();
	}
	
	@Test
	public void testBuscarClienteNoValido() {
		//Para probar el caso de uso consulta cliente se prueba con uno que exista y otro que no
	}
	
	@Test
	public void testBuscarClienteValido() {
		
	}
}
