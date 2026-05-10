package es.unican.is2;
import java.util.ArrayList;

/**
 * Nuevas metricas
 * WMC 5+1+1+1+1+1+1+2=13
 * WMCn 13/8= 1.625
 * CCog 3
 * CCogn 3/8 = 0.375
 * CBO 2 transporte y excepcion
 * DIT 0
 * NOC 0
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
	private String direccion;
	private static final int SUELDO_BASE = 700;

	//CC No cambia respecto a su version sin refactorizar = 5
	//CCog = 2 (1 del if y 1 de los OR)
	public Conductor(String dni, String nombre, String apellido1,
			String apellido2, String direccion) {
		if (dni == null || nombre == null || apellido1 == null || direccion == null) {
			throw new IllegalArgumentException();
		}
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
	}

	//CC 1
	//CCog 0
	public String getDni() {
		return dni;
	}

	//CC 1
	//CCog 0
	public String getNombre() {
		return nombre;
	}

	//CC 1
	//CCog 0
	public String getApellido1() {
		return apellido1;
	}

	//CC 1
	//CCog 0
	public String getApellido2() {
		return apellido2;
	}

	//CC 1
	//CCog 0
	public String getDireccion() {
		return direccion;
	}

	//CC 2 (1 de base y 1 por el for)
	//CCog 1
	public double sueldo() {
		double sueldoTransportes = SUELDO_BASE;
		for (Transporte t : transportes) {
			sueldoTransportes += t.calculaSueldoExtra();
		}
		return sueldoTransportes;
	}

	//CC 1
	//CCog 0
	public void anhadeTransporte(Transporte t) {
		transportes.add(t);
	}

}
