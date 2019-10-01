/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: YaMeHiceBolas.java
 Fecha: 25 de agosto de 2019
 Comentarios: Pensar recursivamente me tomo mucho tiempo
 */

public class BinarySearch {

	public static <E extends Comparable <E>> int binarySearchRec(E valor, E[] valores) {  //Funcion de preparacion
		int min=0,
			max=valores.length-1;
		return binarySearchRec(valor, valores, min, max);
	}
	
	
	private static <E extends Comparable <E>> int binarySearchRec(E valor, E[] valores, int min, int max) {  //Funcion recursiva
		int avg= (min + max) / 2;;
		if(min <= max) {
			avg = (min + max) / 2;
			if(valor.equals(valores[avg])) {
				return avg;
			}else if(valor.compareTo(valores[avg])<0) {
				max = avg-1;
				return binarySearchRec(valor, valores, min, max);
			}else{
				min = avg+1;
				return binarySearchRec(valor, valores, min, max);                      
			}
			
		}else {
			return -1;
			}
	}
	
	
	public static void main(String[] args) {
		Integer[] numeros = {7,10,12,22,40,50,65,90};
		System.out.println(binarySearchRec(12, numeros));	
	}	
}

