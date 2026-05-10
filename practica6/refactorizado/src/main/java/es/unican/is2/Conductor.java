package es.unican.is2;
import java.util.ArrayList;

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

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public String getDireccion() {
		return direccion;
	}

	public double sueldo() {
		double sueldoTransportes = SUELDO_BASE;
		for (Transporte t : transportes) {
			sueldoTransportes += t.calculaSueldoExtra();
		}
		return sueldoTransportes;
	}

	public void anhadeTransporte(Transporte t) {
		transportes.add(t);
	}

}
