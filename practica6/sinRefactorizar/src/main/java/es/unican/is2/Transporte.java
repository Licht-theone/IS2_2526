package es.unican.is2;

/**
 * WMC=9
 * WMCn=9/5=1.8
 * CCog=3
 * CBO=2 usa categoriatransporte e illegalargumentexception
 * DIT=0 no hay herencia
 * NOC=0 no herendan de ella
 */

/* Clase que representa un transporte realizado por un conductor */
public class Transporte {
	
	private double horas;
	private int ton;
	private int personas;
	private CategoriaTransporte cat;
	
	//CC=1+if+or+or+if=5
	//ccog=+1(if)+1(ORs)+1(if)=3
	/**
	 * Constructor de la clase Transporte
	 * @param horas Horas que ha durado el transporte
	 * @param cat Categoria del transporte
	 * @param valor En caso de ser un transporte de tipo Personas, 
	 * representa el numero de personas, en caso de ser de tipo Mercancias 
	 * representa las toneladas
	 */ 
	public Transporte(double horas, CategoriaTransporte cat, int valor) throws IllegalArgumentException {
		if (horas <= 0 || valor <= 0 || cat == null) {
			throw new IllegalArgumentException();
		}
		this.horas = horas;
		this.cat = cat;
		if (cat.equals(CategoriaTransporte.Personas)) {
			this.personas = valor;
		} else  {
			this.ton = valor;
		}
	}
	
	//CC=1
	//ccog=0
	public double horas() {
		return horas;
	}

	//CC=1
	//ccog=0
	public CategoriaTransporte categoria() {
		return cat;
	}

	//CC=1
	//ccog=0
	public int ton() {
		return ton;
	}

	//CC=1
	//ccog=0
	public int getPersonas() {
		return personas;
	}
	
}
