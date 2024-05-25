package v3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Scena extends Canvas implements Runnable{
	
	private ArrayList<Figura> lista  = new ArrayList<>();
	Igrac igrac = new Igrac(this,30,10);
	Thread nitScene = new Thread(this);
	boolean radi = false;
	
	public Scena() {
		this.dodajFiguru(igrac);
		this.setSize(400,400);
		nitScene.start();
	}
	
	
	public synchronized void dodajFiguru(Figura f) {
		lista.add(f);
		System.out.println("crtanje zbog dodavanja");
		revalidate();
		repaint();
	}
	public Figura dohvatiFiguru(int indeks) {
		if(indeks<0||indeks>=lista.size()) return null;
		return lista.get(indeks);
	}
	public void ukloniFiguru(Figura f) {
		lista.remove(f);
		revalidate();
		repaint();
	}
	
	@Override
	public void run() {
		try {
			while(!nitScene.isInterrupted()) {
				for(Figura f:lista) {
					if(f instanceof AktivnaFigura) {
						((AktivnaFigura) f).pokreni(20);
					}
				}
				Thread.sleep(10);
				repaint();
			}
		}
		catch(InterruptedException e) {}
		
	}
	
	public synchronized void nastavi() {
		radi = true;
		notifyAll();
	}
	
	
	public synchronized void prekiniScenu() {
		for(Figura f:lista) {
			if(f instanceof AktivnaFigura) {
				((AktivnaFigura) f).prekini();
			}
		}
		nitScene.interrupt();
	}
	
	@Override
	public void paint(Graphics g) {
		for(Figura f:lista) {
			f.crtaj(g);
			System.out.println("Crtanje " + f.getOznaka());
		}
	}
}
