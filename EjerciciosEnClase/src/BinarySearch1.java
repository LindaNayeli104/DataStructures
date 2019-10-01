
public class BinarySearch1 {
	/*
	public static int binarySearch(int valor, int[] valores) {
		int min,
			max,
			avg;
		min = valores[0];
		max = valores[valores.length-1];
		avg = valores[valores.length/2];
		while(min <= max) {
			//Si el valor buscado esta en avg regresar la posicion
			//Sino regresar si es mayor o menor el valor buscado y
			//actualizar los indices
			
			if(valor == avg) {
				return avg;
			}else {
				if(valor > avg) {
					min = avg + 1;
					avg = (max - min)/2 + min;
				}else {
					max = avg;
				}
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] valor = {1, 15, 45, 58, 78};
		System.out.println(binarySearch(15, valor));
	}	
	*/
	
	public static int binarySearch(int valor, int[] valores) {
		int min,
			max,
			avg;
		min = 0;
		max = valores.length-1;
		
		while(min <= max) {
			
			//Si el valor buscado esta en avg regresar la posicion
			//Sino regresar si es mayor o menor el valor buscado y
			//actualizar los indices
			
			avg = (min + max) / 2;
			
			if(valor == valores[avg]) {
				return avg;
			}else if(valor < valores[avg]) {
				max =  avg-1;
				
			}else{
				min = avg +1;                          //+1 porque es necesario descartar avg porque ya vi que no es igual
			}
		}
		return -1;
	}
	/*
	public static int binarySearchString(String valor, String[] valores) {
		int min,
			max,
			avg;
		min = 0;
		max = valores.length-1;
		
		while(min <= max) {
			
			//Si el valor buscado esta en avg regresar la posicion
			//Sino regresar si es mayor o menor el valor buscado y
			//actualizar los indices
			
			avg = (min + max) / 2;
			
			if(valor == valores[avg]) {   
				return avg;
			}else if(valor.compareTo(valores[avg])<0) {
				max =  avg-1;
				
			}else{
				min = avg +1;                          //+1 porque es necesario descartar avg porque ya vi que no es igual
			}
		}
		return -1;
	}
	
	
	public static <E extends Comparable <E>> int binarySearch(E valor, E[] valores) {
		int min=0,
			max=valores.length-1,
			avg;
		
		while(min <= max) {
			
			//Si el valor buscado esta en avg regresar la posicion
			//Sino regresar si es mayor o menor el valor buscado y
			//actualizar los indices
			
			avg = (min + max) / 2;
			
			if(valor.equals(valores[avg])) {
				return avg;
			}else if(valor.compareTo(valores[avg])<0) {
				max =  avg-1;
				
			}else{
				min = avg +1;                          //+1 porque es necesario descartar avg porque ya vi que no es igual
			}
		}
		return -1;
	}
	/*
	public static int binarySearchString(String valor, String[] valores) {
		int min,
			max,
			avg;
		min = 0;
		max = valores.length-1;
		
		while(min <= max) {
			
			//Si el valor buscado esta en avg regresar la posicion
			//Sino regresar si es mayor o menor el valor buscado y
			//actualizar los indices
			
			avg = (min + max) / 2;
			
			if(valor == valores[avg]) {   
				return avg;
			}else if(valor.compareTo(valores[avg])<0) {
				max =  avg-1;
				
			}else{
				min = avg +1;                          //+1 porque es necesario descartar avg porque ya vi que no es igual
			}
		}
		return -1;
	}
	*/
	public static void main(String[] args) {
		int[] numeros = {7,10,12,22,40,50,65,90};
		System.out.println(binarySearch(90, numeros));
		//String[] palabras = {"ardilla", "gato", "lince"};    //Los datos tienne que estar ordenados
		
		//System.out.println(binarySearchString("gato", palabras));
	}	
}