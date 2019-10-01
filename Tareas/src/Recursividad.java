/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: Recursividad.java
 Fecha: 20 de agosto de 2019
 Comentarios: Pensar recursivamente me tomo mucho tiempo y usar muchos casos base
 */


public class Recursividad {

//---------------------------------------------------------------Metodo multiplicacion
	private static long multiplicacion(int num_1, int num_2) {
		int n = num_1;
		long res = 0;
		if(n == 0) {
			return num_1;
		}
		else {
			return res = multiplicacion(n-1, num_2) + num_2;
		}
		
	}
		
	
	public static long prepara(int num_1, int num_2) { //Funcion de preparacion de metodo multiplicacion
		int signo = 0;
		
		if(num_1 < 0) {
			num_1 = - num_1;
			signo  += 1;
		}
		if(num_2 < 0){
			num_2 = - num_2;
			signo  += 1;
		}
		if(signo == 1) {
			return -multiplicacion(num_1, num_2);
		}
		return multiplicacion(num_1, num_2);
	}
		
		
//---------------------------------------------------------------Metodo base10a2	
	public static String base10a2(int num) { 
	
		if(num !=0) {
			return  base10a2(num/2) +  Integer.toString(num%2);
		}
		else {              //A partir de la div de 0/2 todos los residuos son 0, entonces se ignoran porque estan a la izq del resultado
			return "0";  //Modo base del String
		}
	}	
		
//---------------------------------------------------------------Main
	public static void main(String[] args) {
		//System.out.println(prepara(-9,5));
		System.out.println(base10a2(123));
				
	}	
}

