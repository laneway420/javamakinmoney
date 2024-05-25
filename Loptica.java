package v3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Loptica extends AktivnaFigura {
	
	protected Color boja = Color.GREEN;
	private int poluprecnik;
	private Random rand = new Random();
	private int brojAzuriranja;
	private double brzinaX;
	private double brzinaY;
	
	private boolean sudarCigla = false;
	private boolean sudarIgrac = false;

	public Loptica(int a, int b, Scena c,int poluprecnik) {
		super(a, b,Color.GREEN, c);
		double randX = -1+rand.nextDouble()*2;
		brzinaX = randX;
		double randY = -1+rand.nextDouble();
		brzinaY=randY;
		this.poluprecnik = poluprecnik;
	}

	public Loptica(int a, int b,Color boja, Scena c,int poluprecnik) {
		super(a, b,boja, c);
		this.poluprecnik = poluprecnik;
		double randX = -1+rand.nextDouble()*2;
		brzinaX = randX;
		double randY = -1+rand.nextDouble();
		brzinaY=randY;
	}


	@Override
	public void crtaj(Graphics g) {
		g.setColor(boja);
		g.fillOval(x-poluprecnik/2, y-poluprecnik/2, poluprecnik, poluprecnik);
	}

	
	@Override
	public char getOznaka() {
		return 'L';
	}
	
	

	@Override
	public void azurirajPoziciju() {
		sudarSaScenom();
		pomeriFiguru(brzinaX,brzinaY);
		++brojAzuriranja;
		/*if(brojAzuriranja%100==0) {
			brzinaX = 1.1*brzinaX;
			brzinaY = 1.1*brzinaY;
		}*/
		if(sudarCigla) sudarSaCiglom();
		if(sudarIgrac) sudarSaIgracem();
		if(y>=scena.getHeight()) unisti();
	}
	
	private void sudarSaScenom() {
		if(x+poluprecnik >= scena.getWidth()||x-poluprecnik <= 0 || y+poluprecnik<=0) {
			brzinaX = -brzinaX;
			brzinaY = -brzinaY;
			System.out.println("sudar");
		}
	}
	
	private void sudarSaCiglom() {
		brzinaX = -brzinaX;
		brzinaY = -brzinaY;
	}

	private void sudarSaIgracem() {
		brzinaX = -brzinaX;
		brzinaY = -brzinaY;
	}
}
