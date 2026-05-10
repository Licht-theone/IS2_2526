package es.unican.is2;
import java.util.ArrayList;
import java.util.List;

/**
 * metricas sin cambios con respecto a la clase original
 *  WMC=6
 * WMCn=6/3=2
 * CCog=4
 * CCogn=4/3=1.33
 * CBO=1 solo usa la clase conductor
 * DIT=0 no hay herencia
 * NOC=0 no herendan de ella
 */

public class GestionTransportes {

	private ArrayList<Conductor> cs = new ArrayList<Conductor>();
	
	public Conductor buscaConductor(String dni) {		
		for(Conductor c: cs) 
			if (c.getDni().equals(dni))
				return c;
		
		return null;
	}
	
	public boolean anhadeConductor(String dni, String nombre, String apellido1, String apellido2, String direccion) {
		if (buscaConductor(dni) != null)
			return false;
		cs.add(new Conductor(dni, nombre, apellido1, apellido2,direccion));
		return true;
	}

	public List<Conductor> conductores() {
		return cs;
	}
	
}
