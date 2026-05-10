package es.unican.is2;	

public class TransportePersonas extends Transporte {
	private static final double EXTRA_HORA_NO_COLECTIVO = 0.5;
	private static final int EXTRA_HORA_COLECTIVO = 1;
	private static final int MIN_PERSONAS_COLECTIVO = 10;
	private int personas;
	
	public TransportePersonas(double horas, int personas) throws IllegalArgumentException {
		super(horas);
		if (personas <= 0) {
			throw new IllegalArgumentException();
		}
		this.personas = personas;
	}
	
	public int getPersonas() {
		return personas;
	}

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
