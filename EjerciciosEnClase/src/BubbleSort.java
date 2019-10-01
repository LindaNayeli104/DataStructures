
public class BubbleSort {
	public static void bubbleSort(int[] datos) {        //Requerimos n-1 iteraciones  //En el mejor de los casos n  // Peor de los casos n^2
		boolean desordenados= true;
		for(int i=0; i<datos.length-1 && desordenados;i++) {
			desordenados = false;
			for(int j=0; j<datos.length-1-i;j++) {
				if(datos[j]>datos[j+1]) {
					swap(datos, j, j+1);
					desordenados = true;
				}
			}
		}
	}

//------------------------------------------------------------------------------------------------------------------Auxiliares	

	public static void imprimeArreglo(int[] arreglo) {
		//Imprimir el arreglo separado por comas y sin espacios
		for(int valor:arreglo) {
			System.out.print(valor + ",");
		}
		System.out.println();
	}
	
		
	public static void swap(int[] datos, int i, int j) {
		int aux = datos[i];
		datos[i] = datos[j];
		datos[j] = aux;	
		
	}
	
//------------------------------------------------------------------------------------------------------------------Main
	public static void main(String[] args) {
		int[] numeros = {3, 5, 8, -5, 0, 15};
		bubbleSort(numeros);
		imprimeArreglo(numeros);
	
		 
	}
}
