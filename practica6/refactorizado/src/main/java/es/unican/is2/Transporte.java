package es.unican.is2;
/* Clase que representa un transporte realizado por un conductor */
public abstract class Transporte {
	private double horas;
	protected static final int EXTRA_BASICO = 5;
	
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
	
	public double getHoras() {
		return horas;
	}
	
	public abstract double calculaSueldoExtra();
}
