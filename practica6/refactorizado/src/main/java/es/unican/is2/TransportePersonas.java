package es.unican.is2;	

/**
 * Nuevas metricas
 * WMC 5
 * WMCn 5/3 = 1.66
 * CCog 3
 * CCogn 3/3 = 1
 * CBO 2 transporte y excepcion
 * DIT 1
 * NOC 0
 */

public class TransportePersonas extends Transporte {
	private static final double EXTRA_HORA_NO_COLECTIVO = 0.5;
	private static final int EXTRA_HORA_COLECTIVO = 1;
	private static final int MIN_PERSONAS_COLECTIVO = 10;
	private int personas;
	
	//CC 1 + if = 2
	//CCog 1 por el if
	public TransportePersonas(double horas, int personas) throws IllegalArgumentException {
		super(horas);
		if (personas <= 0) {
			throw new IllegalArgumentException();
		}
		this.personas = personas;
	}
	
	//CC 1
	//CCog 0
	public int getPersonas() {
		return personas;
	}

	//CC 1 +if = 2
	//CCog 1 por el if y +1 por el else
	@Override
	public double calculaSueldoExtra() {
		double extra = 0;
		extra += EXTRA_BASICO * getHoras();
		if (personas < MIN_PERSONAS_COLECTIVO) {
			extra += EXTRA_HORA_NO_COLECTIVO * getHoras();
		} else {
			extra += EXTRA_HORA_COLECTIVO * getHoras();
		}
		return extra;
	}

}
