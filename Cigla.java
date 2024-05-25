package v3;

import java.awt.Color;
import java.awt.Graphics;

public class Cigla extends AktivnaFigura {
	
	protected Color boja = Color.RED;
	private int sirina,visina;
	private boolean pogodjena = false;
	
	public int getSirina() {
		return sirina;
	}
	
	public int getVisina() {
		return visina;
	} 
	
	public boolean getPogodjena() {
		return pogodjena;
	}
	
	public void pogodi() {
		boja = Color.GRAY;
		pogodjena = true;
	}

	public Cigla(int a, int b, Scena c, int s, int v) {
		super(a, b,Color.RED, c);
		sirina =s;
		visina = v;
	}
	
	public Cigla(int a, int b,Color boja,Scena c, int s, int v) {
		super(a, b,boja, c);
		sirina =s;
		visina = v;
		this.boja = boja;
	}

	
	@Override
	public synchronized void azurirajPoziciju() {
		if(!pogodjena) return;
		pomeriFiguru(0,5);
		if(y>=scena.getHeight()) this.unisti();
		
	}

	@Override
	public void crtaj(Graphics g) {
		g.setColor(boja);
		g.fillRect(x-sirina/2, y-visina/2, sirina, visina);
	}

	@Override
	public char getOznaka() {
		return 'C';
	}

}
