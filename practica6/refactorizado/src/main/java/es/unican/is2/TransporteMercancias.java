package es.unican.is2;

/**
 * Metricas
 * WMC 4
 * WMCn 4/3 = 1.33
 * CCog 1
 * CCogn 1/3 = 0.33
 * CBO 2 transporte y excepcion
 * DIT 1
 * NOC 0
 */

public class TransporteMercancias extends Transporte {
	private static final int EXTRA_MERCANCIAS = 2;
	private int ton;

	//CC 1 + if = 2
	//CCog 1 por el if
	public TransporteMercancias(double horas, int ton) throws IllegalArgumentException {
		super(horas);
		if (ton <= 0) {
			throw new IllegalArgumentException();
		}
		this.ton = ton;
	}
	
	//CC 1
	//CCog 0
	public int getTon() {
		return ton;
	}

	//CC 1
	//CCog 0
	@Override
	public double calculaSueldoExtra() {
		double extra = 0;
		extra += (EXTRA_BASICO * getHoras()) + (EXTRA_MERCANCIAS * ton);
		return extra;
	}
	
}
