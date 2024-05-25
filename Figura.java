package v3;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {

	protected Scena scena;
	protected int x;
	protected int y;
	protected Color boja;
	
	public Figura(int a, int b,Color boja, Scena c) {
		x =a;
		y = b;
		scena = c;
		this.boja = boja;
		scena.dodajFiguru(this);
	}
	
	
	public void unisti() {
		scena.ukloniFiguru(this);
	}
	
	abstract public void crtaj(Graphics g);
	abstract public char getOznaka();
	
	public void pomeriFiguru(double brzinaX, double brzinaY) {
		x+=brzinaX;
		y+=brzinaY;
	}
	
	
}
