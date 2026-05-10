package es.unican.is2;

public class TransportePeligrosas extends Transporte {
	private static final int EXTRA_MERCANCIAS = 2;
	private static final int EXTRA_PELIGROSAS = 50;
	private int ton;
	
	public TransportePeligrosas(double horas, int ton) throws IllegalArgumentException {
		super(horas);
		if (ton <= 0) {
			throw new IllegalArgumentException();
		}
		this.ton = ton;
	}
	
	public int getTon() {
		return ton;
	}

	@Override
	public double calculaSueldoExtra() {
		double extra = 0;
		extra += (EXTRA_BASICO * getHoras()) + (EXTRA_MERCANCIAS * ton) + EXTRA_PELIGROSAS;
		return extra;
	}
	
}
