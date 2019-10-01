import java.util.Arrays;

public class Pruebas{
	
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
		
		int principio, mid, a;
		int [] array_aux = new int[datos.length]; 
   
		for (principio=ini; principio<=fin; principio++) {  //copia ambas mitades en el array auxiliar
			array_aux[principio]=datos[principio];
		}
		
		principio=ini;
		mid=((ini + fin)/2)+1; 
		a=ini;
		
        while (principio<=((ini + fin)/2) && mid<=fin) { //copia el siguiente elemento más grande
        	if (array_aux[principio]<=array_aux[mid]) {
            	datos[a++]=array_aux[principio++];
            }
        	else {
        		datos[a++]=array_aux[mid++];
        	}
        }
   
        while (principio<=((ini + fin)/2)) { //copia los elementos que quedan de la
        	datos[a++]=array_aux[principio++]; //primera mitad (si los hay
        }       
	}
   
 
    
    public static void imprimeArreglo(int[] arreglo) {
		//Imprimir el arreglo separado por comas y sin espacios
		for(int valor:arreglo) {
			System.out.print(valor + ",");
		}
		System.out.println();
	}
    
//------------------------------------------------------------------------------------------------------------------QuickSort
  	public static void quicksort(int[] datos) {
  		quicksort(datos, 0, datos.length-1);
  	}
  	
  	private static void quicksort(int[] datos, int left, int right) {
  		if(left < right) {
  			int p = particionar(datos, left, right);
  			quicksort(datos, left, p-1);
  			quicksort(datos, p, right);
  		}else {
  			return;
  		}
  		
  	}
  	
  	private static int particionar(int[] datos, int left, int right) {
  		//Regresa la posicion donde quedó el pivote
  		
  		int p = datos[(left +  right) / 2];
  		
  		while(left <= right) {
  			while(datos[left] < p) {
  				left++;
  			}
  			
  			while(datos[right] > p) {
  				right--;
  			}
  			
  			if(left <= right) {
  				swap(datos, left, right);
  				left++;
  				right--;
  			}
  		}
  		return left;
  	}
  	
  	
	public static void swap(int[] datos, int i, int j) {
		int aux = datos[i];
		datos[i] = datos[j];
		datos[j] = aux;	
	}
//------------------------------------------------------------------------------------------------------------------MAIN   
    public static void main(String[] args) {
		int vec[]={2,8,5,3,9,4,1,7};
		//mergesort(vec);
		quicksort(vec);
		imprimeArreglo(vec);
		 
	}
        
}