package es.unican.is2;

/**
 * Nuevas metricas
 * WMC 4
 * WMCn 4/3 = 1.33
 * CCog 1
 * CCogn 1/3 = 0.33
 * CBO 1 (excepcion)
 * DIT 0
 * NOC 3 clases hijas
 */

/* Clase que representa un transporte realizado por un conductor */
public abstract class Transporte {
	private double horas;
	protected static final int EXTRA_BASICO = 5;
	
	
	//CC 1 + 1 del if=2
	//CCog 1 por el if
	/**
	 * Constructor de la clase Transporte
	 * @param horas Horas que ha durado el transporte
	 * @param cat Categoria del transporte
	 * @param valor En caso de ser un transporte de tipo Personas, 
	 * representa el numero de personas, en caso de ser de tipo Mercancias 
	 * representa las toneladas
	 */ 
	public Transporte(double horas) throws IllegalArgumentException {
		if (horas <= 0) {
			throw new IllegalArgumentException();
		}
		this.horas = horas;
	}
	
	//CC 1
	//CCog 0
	public double getHoras() {
		return horas;
	}
	//CC 1 porque cuenta como metodo
	//CCog 0
	public abstract double calculaSueldoExtra();
}
