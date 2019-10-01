/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: YaMeHiceBolas.java
 Fecha: 25 de agosto de 2019
 Comentarios: Pensar recursivamente me tomo mucho tiempo y usar muchos casos base
 */

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class YaMeHiceBolas extends JFrame{

	private int x1,
				y1,
				largo,
				nivel,
				nivel_actual;
	
	
	public YaMeHiceBolas() {
		super("Fractal YaMeHiceBolas");
		this.setSize(720,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.x1 =  50;                                   
		this.y1 = 350;                                     
		this.largo = 600;
		this.nivel = Integer.parseInt(JOptionPane.showInputDialog("Introduce el nivel de profundidad"));
		this.setVisible(true);	
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		this.pinta_3circulos(g,nivel, x1, y1, largo);   
	}
	

	public void pinta_1circulo(Graphics g, int nivel, int x1, int y1, int largo) {
		g.drawOval(x1, y1-largo/2, largo, largo);
	}
	
	
	public void pinta_3circulos(Graphics g, int nivel, int x1, int y1, int largo) {   
		
		if(nivel == 0) {
			g.drawOval(x1, y1-largo/2, largo, largo);
		}else {
			this.pinta_1circulo(g, nivel-1, x1, y1, largo);
			this.pinta_3circulos(g, nivel-1, x1, y1,largo/2 );  
			this.pinta_3circulos(g, nivel-1, x1+largo/2, y1, largo/2);
		}
	}
	
	
	public static void main(String[] args) {
		YaMeHiceBolas fractal =  new YaMeHiceBolas();
	}
}
