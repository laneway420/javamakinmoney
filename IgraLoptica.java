package v3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IgraLoptica extends Frame {
	private Scena scena = new Scena();
	private Igrac igrac = new Igrac(scena,30,15);
	
	public IgraLoptica() {
		this.setTitle("Igra Loptica");
		int sirinaCigle = scena.getWidth()/5;
		//for(int i = 0; i<5;i++) {
			//scena.dodajFiguru(new Cigla(sirinaCigle/2+i*sirinaCigle+2,15/2+1,scena,sirinaCigle-3,15));
		//}
		//scena.dodajFiguru(igrac);
		//Cigla c = new Cigla(sirinaCigle/2+2,15*3/2+3,scena,sirinaCigle-3,15);
		//Cigla c1 = new Cigla(sirinaCigle*3/2+2,15*3/2+3,scena,sirinaCigle-3,15);
		//Cigla c2 = new Cigla(sirinaCigle*5/2+2,15*3/2+3,scena,sirinaCigle-3,15);
		//Cigla c3 = new Cigla(sirinaCigle*7/2+2,15*3/2+3,scena,sirinaCigle-3,15);
		//c.pogodi();
		//c1.pogodi();
		//c2.pogodi();
		//igrac.ispaliLopticu(Color.GREEN);
		Loptica loptica = new Loptica(scena.getWidth()/2,scena.getHeight(),scena,20);
		scena.dodajFiguru( loptica);
		loptica.pokreni(10);

		this.add(scena,BorderLayout.CENTER);
		
		
		this.setSize(500,500);
		scena.nastavi();
		dodajOsluskivace();
		revalidate();
		pack();
		setResizable(false);
		setVisible(true);
	}
	
	private void dodajOsluskivace() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				scena.prekiniScenu();
				dispose();
			}
		});
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
					igrac.ispaliLopticu(Color.GREEN);
					revalidate();
					repaint();
				}
			}
		});
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_D) {
					igrac.pomeriFiguru(10,0);
					scena.repaint();
					revalidate();
					System.out.println("crtanje zbog pomeranje");
				}
				if(e.getKeyCode()==KeyEvent.VK_A) {
	
					igrac.pomeriFiguru(-10,0);
					revalidate();
					scena.repaint();
					System.out.println("crtanje zbog pomeranje");
				}
			}
		});
	}

	public static void main(String[] args) {
		new IgraLoptica();
	}

}
