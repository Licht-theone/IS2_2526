package es.unican.is2;

import java.util.ArrayList;


/**
 *  El wmc de esta clase se calcula con la formula de la suma de las complejidades ciclomaticas de sus metodos
 *  tal y como se indica en las transparencias de clase
 *  La complejidad ciclomatica de cada metodo es 1 + el numero de nodos de condicion (if, for, while, case, catch)
 *  +1 por cada operador && o ||
 *  WMC=5+1+1+1+1+1+1+6+1=18
 *  WMCn=18/9=2
 *  CCog de la clase = 9
 *  CCogn=9/9=1
 *  CBO= usa la clase transporte,categoriatransporte e illegalargumentexception=3
 *  DIT=0 no hereda ninguna clase
 *  NOC=0 no hay clase que herede de esta
 */



/**
 * Clase que representa a un conductor, con sus datos personales
 * y los transportes que ha realizado. 
 */
public class Conductor {

	private ArrayList<Transporte> transportes = new ArrayList<Transporte>();
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dire;

	//cc=1+if+or+or+or=5
	//ccog=+1 por el if +1 por los or=2
	public Conductor(String dni, String nombre, String apellido1,
			String apellido2, String direccion) {
		if (dni == null || nombre == null || apellido1 == null || direccion == null) {
			throw new IllegalArgumentException();
		}
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dire = direccion;
	}

	//cc=1
	//ccog=0
	public String dni() {
		return dni;
	}
	
	//cc=1
	//ccog=0
	public String getDni() {
		return dni;
	}

	//cc=1
	//ccog=0
	public String getNombre() {
		return nombre;
	}

	//cc=1
	//ccog=0
	public String getApellido1() {
		return apellido1;
	}

	//cc=1
	//ccog=0
	public String apellido2() {
		return apellido2;
	}

	//cc=1
	//ccog=0
	public String getDire() {
		return dire;
	}
	
	//CC= 1+for+case+case+case+if=6
	//ccog=+1(for)+2(switch anidado en el for)+3(if anidado en switch anidado en for)+1(else)=7
	public double sueldo() {
		double sueldoTransportes = 0;
		for (Transporte t : transportes) {
			double sueldoExtraTransporte = 0.0;
			switch (t.categoria()) {
				case Mercancias:
					sueldoExtraTransporte = t.ton() * 2;
					break;
				case MercanciasPeligrosas:
					sueldoExtraTransporte = t.ton() * 2 + 50;
					break;
				case Personas:
					if (t.getPersonas() < 10)
						sueldoExtraTransporte = t.horas() * 0.5;
					else
						sueldoExtraTransporte = t.horas();
					break;
			}
			sueldoTransportes += t.horas() * 5 + sueldoExtraTransporte;
		}
		return 700 + sueldoTransportes;
	}

	//cc=1
	//ccog=0
	public void anhadeTransporte(Transporte t) {
		transportes.add(t);
	}

}
