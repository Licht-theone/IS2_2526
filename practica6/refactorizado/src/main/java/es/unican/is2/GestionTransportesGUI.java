package es.unican.is2;
import java.util.LinkedList;
import java.util.List;
import fundamentos.*;

/**
 * Nuevas metricas
 * WMC 22
 * WMCn 22/6=3.66
 * CCog 18
 * CCogn 18/6 = 3
 * CBO 6 (conductor, transporte, gestion transporte y las 3 hijas de transporte)
 * DIT 0
 * NOC 0
 */

/**
 * Gestion de una empresa de transportes
 */
public class GestionTransportesGUI {

	//CC 1 + while + 4 case = 6
	//CCog +1 por el while +2 por el switch anidado = 3
	/**
	 * Programa principal basado en menu
	 */
	public static void main(String[] args) {
		// opciones del menu
		final int ANHADE_CONDUCTOR = 0, ANHADE_TRANSPORTE = 1, 
		SUELDO_CONDUCTOR = 2, MEJOR_CONDUCTOR = 3;

		// crea la empresa de transportes
		GestionTransportes gt = new GestionTransportes();
		// crea la ventana de menu
		Menu menu = new Menu("Transportes");
		menu.insertaOpcion("Anhade conductor", ANHADE_CONDUCTOR);
		menu.insertaOpcion("Anhade transporte", ANHADE_TRANSPORTE);
		menu.insertaOpcion("Sueldo conductor", SUELDO_CONDUCTOR);
		menu.insertaOpcion("Mejor conductor", MEJOR_CONDUCTOR);
		
		int opcion;

		// lazo de espera de comandos del usuario
		while(true) {
			opcion = menu.leeOpcion();

			// realiza las acciones dependiendo de la opcion elegida
			switch (opcion) {
			case  ANHADE_CONDUCTOR:
				anhadeConductorExtracted(gt);
				break;

			case ANHADE_TRANSPORTE:
				anhadeTransporteExtracted(gt);
				break;
				
			case SUELDO_CONDUCTOR:
				sueldoConductorExtracted(gt);
 				break;

			case MEJOR_CONDUCTOR:
				mejorConductorExtracted(gt);
				break;
			}
		}
	}

	//CC 1 + for + if + elseif + if + for = 6
	//CCog +1 por el for + 2 por el if anidado + 1 por el elseif +1 por el if fuera del bucle y +1 else y +2 for anidado en else = 8 
	private static void mejorConductorExtracted(GestionTransportes gt) {
		List<Conductor> resultado = new LinkedList<Conductor>();
		double maxSueldo = 0.0;
		for (Conductor conductor : gt.conductores()) {
			if (conductor.sueldo() > maxSueldo) {
				maxSueldo = conductor.sueldo();
				resultado.clear();
				resultado.add(conductor);
			} else if (conductor.sueldo() == maxSueldo) {
				resultado.add(conductor);
			}
		}		
		String msj = "";
		if (resultado.size() == 0) {
			msj = "No hay conductores";
		} else {
			for (Conductor conductor : resultado) {
				msj += conductor.getNombre() + " "+conductor.getNombre()+"\n";
			}
		}
		mensaje("MEJOR CONDUCTOR", msj);
	}

	//CC 1 + if = 2
	//CCog 1 del if y 1 del else = 2
	private static void sueldoConductorExtracted(GestionTransportes gt) {
		String dni;
		Lectura lect;
		Conductor c;
		lect = new Lectura("Transportes Peligrosos");
		lect.creaEntrada("DNI", "");
		lect.esperaYCierra();
		dni = lect.leeString("DNI");
		c = gt.buscaConductor(dni);
		if (c!=null){
			mensaje("Sueldo", "El sueldo del conductor es: "+c.sueldo());
		} else {
			mensaje("ERROR", "No existe un conductor con DNI "+dni);
		}
	}

	//CC 1 + if + 3 case = 5
	//CCog +1 por el if +2 por el switch anidado +1 por el else = 4
	private static void anhadeTransporteExtracted(GestionTransportes gt) {
		String dni;
		Lectura lect;
		Conductor c;
		lect = new Lectura("Nuevo transporte");
		lect.creaEntrada("DNI", "");
		lect.creaEntrada("Tipo Transporte: P | M | MP", "");
		lect.creaEntrada("Horas", 0);
		lect.creaEntrada("Personas", 0);
		lect.creaEntrada("Toneladas", 0);
		lect.esperaYCierra();
		dni = lect.leeString("DNI");
		String tipo = lect.leeString("Tipo Transporte: P | M | MP");
		int horas = lect.leeInt("Horas");
		int personas = lect.leeInt("Personas");
		int toneladas = lect.leeInt("Toneladas");

		Transporte t = null;
		c = gt.buscaConductor(dni);
		if (c!=null) {
			switch (tipo) {
				case "P":
					t = new TransportePersonas(horas,personas);
					c.anhadeTransporte(t);
					break;
				case "M":
					t = new TransporteMercancias(horas, toneladas);
					c.anhadeTransporte(t);
					break;
				case "MP":
					t = new TransportePeligrosas(horas, toneladas);
					c.anhadeTransporte(t);
					break;		
			}
		} else {
			mensaje("ERROR", "No existe un conductor con DNI "+dni);
		}
	}

	//CC 1 + if = 2
	//CCog 1 del if
	private static void anhadeConductorExtracted(GestionTransportes gt) {
		String dni;
		Lectura lect;
		lect = new Lectura("Datos Conductor");
		lect.creaEntrada("DNI", "");
		lect.creaEntrada("Nombre","");
		lect.creaEntrada("Apellido1", "");
		lect.creaEntrada("Apellido2", "");
		lect.creaEntrada("Direccion", "");
		lect.esperaYCierra();
		dni = lect.leeString("DNI");
		String nombre = lect.leeString("Nombre");
		String apellido1 = lect.leeString("Apellido1");
		String apellido2 = lect.leeString("Apellido2");
		String direccion = lect.leeString("Direccion");
		// Anhade el conductor
		if (!gt.anhadeConductor(dni, nombre, apellido1, apellido2, direccion)) 
			mensaje("ERROR", "Ya existe un conductor con DNI "+dni);
	}

	
	//CC 1
	//CCog 0
	/**
	 * Metodo auxiliar que muestra un ventana de mensaje
	 * @param titulo titulo de la ventana
	 * @param txt texto contenido en la ventana
	 */
	private static void mensaje(String titulo, String txt) {
		Mensaje msj = new Mensaje(titulo);
		msj.escribe(txt);

	}

}
