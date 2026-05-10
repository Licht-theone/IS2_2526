package es.unican.is2;

import java.util.ArrayList;
import java.util.List;

/**
 * WMC=6
 * WMCn=6/3=2
 * CCog=4
 * CCogn=4/3=1.33
 * CBO=1 solo usa la clase conductor
 * DIT=0 no hay herencia
 * NOC=0 no herendan de ella
 */
public class gestionTransportes {

	private ArrayList<Conductor> cs = new ArrayList<Conductor>();
	
	//CC=+1+for+if=3
	//ccog=+1(for)+2(if anidado)=3
	public Conductor buscaConductor(String DNI) {		
		for(Conductor c: cs) 
			if (c.dni().equals(DNI))
				return c;
		
		return null;
	}
	
	//CC=+1+if=2
	//ccog=1 por el if
	public boolean anhadeConductor(String dni, String nombre, String apellido1, String apellido2, String direccion) {
		if (buscaConductor(dni) != null)
			return false;
		cs.add(new Conductor(dni, nombre, apellido1, apellido2,direccion));
		return true;
	}

	//CC=1
	//ccog=0
	public List<Conductor> conductores() {
		return cs;
	}
	
}
