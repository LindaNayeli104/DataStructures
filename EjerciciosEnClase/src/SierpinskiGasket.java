import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SierpinskiGasket extends JFrame{

	private Point a,
				  b,
				  c;
	
	private int nivel;
	
	public SierpinskiGasket() {
		super("Fractal Sierpinski Gasket");
		this.setSize(640,420);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.a =  new Point(320, 50);                                   // this.a =  new Point(420, 50);        Para girar la figura pero no pierde proporcionalidad 
		this.b = new Point(20,380);                                      // this.b = new Point(20,180);
		this.c = new Point(620,380);
		this.nivel =  2;//Integer.parseInt(JOptionPane.showInputDialog("Introduce el nivel de profundidad"));
		this.setVisible(true);
		
	}
	
	public Point puntoMedio(Point a, Point b) {
		int xM = (a.x + b.x) / 2,
			yM = (a.y + b.y) / 2;
		return new Point(xM, yM);

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.pintaTriangulos(g, nivel, a, b, c);
	}

	
	public void pintaLineas(Graphics g, Point a, Point b) {
		g.drawLine(a.x, a.y, b.x, b.y);
	}
	
	public void pintaTriangulos(Graphics g, int nivel, Point a, Point b, Point c) {    //Recursividad basica pero grafica
		if(nivel == 0) {
			pintaLineas(g, a, b);
			pintaLineas(g, b, c);
			pintaLineas(g, c, a);
		}else {
			Point pmAB = this.puntoMedio(a, b),
				  pmBC = this.puntoMedio(b, c),
				  pmCA = this.puntoMedio(c, a);
			this.pintaTriangulos(g, nivel-1, a, pmAB, pmCA);
			this.pintaTriangulos(g, nivel-1, pmAB, b, pmBC);
			this.pintaTriangulos(g, nivel-1,pmCA, pmBC, c);
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		SierpinskiGasket fractal =  new SierpinskiGasket();
	}
	
	
	
}
