package v3;

import java.awt.Color;
import java.awt.Graphics;

abstract public class AktivnaFigura extends Figura {
	
	protected int period;
	protected boolean radi;
	protected Thread nit ;


	public AktivnaFigura(int a, int b,Color boja, Scena c) {
		super(a,b,boja,c);
	}
	
	@Override
	public void unisti() {
		prekini();
		super.unisti();
	}
	
	
	abstract public void azurirajPoziciju();
	
	
	public void pokreni(int p) {
		radi = true;
		period = p;
		nit = new Thread(()->{ 
			try {
				while(!nit.isInterrupted()) {
					Thread.sleep(period);
					azurirajPoziciju();
				}
			}
			catch(InterruptedException e) {}
		});
		nit.start();
	}
	
	
	public void prekini() {
		if(nit == null) return;
		radi = false;
		nit.interrupt();
	}

	

}
