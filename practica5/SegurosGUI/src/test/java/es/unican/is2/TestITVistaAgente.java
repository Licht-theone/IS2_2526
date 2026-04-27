package es.unican.is2;
import java.awt.Dimension;

import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.Cliente;
import es.unican.is2.ClientesDAO;
import es.unican.is2.DataAccessException;
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
		ventana.show(new Dimension(450, 341));
	}
	
	@AfterEach
	public void tearDonw() {
		if (ventana != null) {
			ventana.cleanUp();
		}	
	}
	
	@Test
	public void testBuscarClienteNoValido() {
		//Para probar el caso de uso consulta cliente se prueba con uno que exista y otro que no
		ventana.textBox("txtDNICliente").enterText("99999999Z");
		ventana.button("btnBuscar").click();
		ventana.textBox("txtNombreCliente").requireText("Error en BBDD");
		ventana.list().requireItemCount(0);
		ventana.textBox("txtTotalCliente").requireEmpty();
	}
	
	@Test
	public void testBuscarClienteValido() {
		//busca el cliente valido
		ventana.textBox("txtDNICliente").enterText("11111111A");
		ventana.button("btnBuscar").click();
		ventana.textBox("txtNombreCliente").requireText("Juan");
		ventana.list().requireItemCount(3);
		ventana.textBox("txtTotalCliente").requireText("1820.0");
	}
	
	@Test
	public void testFalloBBDD() {
		ventana.cleanUp();
		ventana = null;
		IClientesDAO clientesDAO = new ClientesDAO();
		ISegurosDAO segurosDAO = new SegurosDAO();
		//stub que siempre lanza la excepcion
		GestionSeguros infoRota = new GestionSeguros(clientesDAO, segurosDAO) {
			@Override
			public Cliente cliente(String dni) throws DataAccessException {
				// fuerza la excepción directamente
				throw new DataAccessException();
			}
		};
		VistaAgente vistaRota = new VistaAgente(infoRota, infoRota, infoRota);
		FrameFixture ventanaRota = new FrameFixture(vistaRota);
		ventanaRota.show(new Dimension(450, 341));
		ventanaRota.textBox("txtDNICliente").enterText("11111111A");
		ventanaRota.button("btnBuscar").click();
		ventanaRota.textBox("txtNombreCliente").requireText("Error en BBDD");
		ventanaRota.list().requireItemCount(0);
		ventanaRota.textBox("txtTotalCliente").requireEmpty();
		ventanaRota.cleanUp();
	}
}
