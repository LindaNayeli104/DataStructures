import java.util.Arrays;

public class OrdenamientosInt {
	
//------------------------------------------------------------------------------------------------------------------BubbleSort
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
	

	
//------------------------------------------------------------------------------------------------------------------MergeSort
	
	public static void mergesort(int[] datos) {     //Funcion de preparacion
		mergesort(datos, 0, datos.length-1);
	}
	
	private static void mergesort(int[] datos, int ini, int fin) {//Funcion recursiva
		if(ini < fin) {
			int mid = (ini + fin)/2;
			mergesort(datos, ini, mid);
			mergesort(datos, mid+1, fin);
			merge(datos, ini, fin);
		}	
	}
	
	private static void merge(int[] datos, int ini, int fin) {
		
		int i, j, k;
		int [] B = new int[datos.length]; //array auxiliar
   
		for (i=ini; i<=fin; i++) {  //copia ambas mitades en el array auxiliar
			B[i]=datos[i];
		}
		
		i=ini; j=((ini + fin)/2)+1; k=ini;
        while (i<=((ini + fin)/2) && j<=fin) { //copia el siguiente elemento más grande
        	if (B[i]<=B[j]) {
            	datos[k++]=B[i++];
            }
        	else {
        		datos[k++]=B[j++];
        	}
        }
   
        while (i<=((ini + fin)/2)) { //copia los elementos que quedan de la
        	datos[k++]=B[i++]; //primera mitad (si los hay
        }       
	}

	
	
	
	
//------------------------------------------------------------------------------------------------------------------QuickSort
	/*public static void quicksort(int[] datos) {
		
	}
	
	private static void quicksort(int[] datos, int left, int right) {
		if(left < right) {
			int p = particionar(datos, left, right);
			quicksort(datos, left, p-1);
			quicksort(datos, p+1, right);
			
		}
		
	}
	
	private static int particionar(int[] datos, int left, int right) {
		//Regresa la posicion donde quedó el pivote
		
		
		
	}
	*/
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
		int vec[]={2,8,5,3,9,4,1,7};
		//mergesort(vec);
		//imprimeArreglo(vec);
		 
	}
}
