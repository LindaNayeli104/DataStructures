
public class NReinas {
	private int[] reinas;
	
	public NReinas(int n) {               //No es necesario pero lo pongo para no tener ambiguedad de 0 reinas o posicion 0 de una reina
		this.reinas = new int[n];
		for(int i=0; i<this.reinas.length;i++) {
			this.reinas[i] = -1;
		}
		
	}
	
	public boolean valida(int fila, int columna) { //Que no haya otra reina en la misma columna que quiero poner
		for(int i=0; i<fila; i++) {
			if(this.reinas[i] == columna) {
				return false;
			}
			if(Math.abs(columna-this.reinas[i])== Math.abs(fila-i)) {
				return false;
			}
		} 
		return true;
	}
	
	
	public void imprimeSolucion() {
		for(int i = 0; i<this.reinas.length;i++) {
			System.out.print(this.reinas[i] + ",");
		}
		System.out.println();	
	}
	
	
	private void busca(int fila) {                //Correr paso a paso para ver el backtracking 
		for(int i=0; i<this.reinas.length; i++) {   //Itera de 0 a n-1
			if(valida(fila,i)) {
				this.reinas[fila] = i;
				if(fila < this.reinas.length-1) {   // -1 poruqe si no va a tratar de poner
					busca(fila+1);
				}else {
					this.imprimeSolucion();
				}
				
			}
		}
	}
	
	public void busca() {    //FUNCION DE PREPARACION         //Debe saber que va a empezar en la 0
		busca(0);
	}
	
	
	public static void main(String[] args) {
		NReinas tablero = new NReinas(4);
		tablero.busca();
	}
	
	
}
