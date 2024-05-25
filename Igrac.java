package v3;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura {
	protected Color boja = Color.BLUE;
	private int sirina,visina;
	
	public int getSirina() {
		return sirina;
	}
	
	public int getVisina() {
		return visina;
	}

	public Igrac( Scena c,int s,int v) {
		super(c.getWidth()/2, c.getHeight()-20,Color.BLUE, c);
		sirina = s;
		visina = v;
	}
	
	public void ispaliLopticu(Color c) {
		Loptica loptica = new Loptica(x,y-visina,c,scena,visina);       
		scena.dodajFiguru(loptica);
		System.out.println("loptica dodata");
		//loptica.pokreni(10); 
		
	}

	@Override
	public void crtaj(Graphics g) {
		g.setColor(boja);
		g.fillRect(x-sirina/2,y-visina/2, sirina, visina);
	}
	@Override
	public void pomeriFiguru(double brzinaX, double brzinaY) {
		if(x+sirina/2>=scena.getWidth()&&brzinaX>0) {
			x = scena.getWidth()-sirina/2;
		}
		else if(x-sirina/2<=0&&brzinaX<0) {
			x = sirina/2;
		}
		else {
			super.pomeriFiguru(brzinaX, brzinaY);
		}
	}

	@Override
	public char getOznaka() {
		return 'I';
	}

}
