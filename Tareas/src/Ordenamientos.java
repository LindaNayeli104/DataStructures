/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: Ordenamientos.java
 Fecha: 01 de septiembre de 2019
 Comentarios: Se me dificultó el crear un array con genéricos
 */


public class Ordenamientos {

//------------------------------------------------------------------------------------------------------------------BubbleSort	
	public static <E extends Comparable <E>> void bubbleSort(E[] datos) {        
		boolean desordenados= true;
		for(int i=0; i<datos.length-1 && desordenados;i++) {
			desordenados = false;
			for(int j=0; j<datos.length-1-i;j++) {
				if(datos[j].compareTo(datos[j+1])>0) {        
					swap(datos, j, j+1);
					desordenados = true;
				}
			}
		}
	}
	
	
//------------------------------------------------------------------------------------------------------------------MergeSort
	public static <E extends Comparable <E>> void PreparaMergesort(E[] datos) {     //Funcion de preparacion
		mergesort(datos, 0, datos.length-1);
	}
	
	private static <E extends Comparable <E>> void mergesort(E[] datos, int ini, int fin) {//Funcion recursiva
		if(ini < fin) {
			int mid = (ini + fin)/2;
			mergesort(datos, ini, mid);
			mergesort(datos, mid+1, fin);
			merge(datos, ini, fin);
		}
	}
	
	private static <E extends Comparable <E>> void merge(E[] datos, int ini, int fin) {
		
		int principio, 
			mid, 
			a;
		E[] array_aux = (E[]) new Comparable[datos.length];    
	
   
		for (principio=ini; principio<=fin; principio++) {  
			array_aux[principio]=datos[principio];
		}
		
		principio=ini;
		mid=((ini + fin)/2)+1; 
		a=ini;
        while (principio <= ( (ini + fin) /2 ) && mid<=fin) {
        	if (array_aux[principio].compareTo(array_aux[mid])<=0) {
            	datos[a++]=array_aux[principio++];
            }
        	else {
        		datos[a++]=array_aux[mid++];
        	}
        }
   
        while (principio<=((ini + fin)/2)) { 
        	datos[a++]=array_aux[principio++]; 
        }       
	}
	
	
//------------------------------------------------------------------------------------------------------------------QuickSort
	
	public static <E extends Comparable <E>> void quicksort(E[] datos) {
  		quicksort(datos, 0, datos.length-1);
  	}
  	
  	private static <E extends Comparable <E>> void quicksort(E[] datos, int left, int right) {
  		if(left < right) {
  			int pivote = particionar(datos, left, right);
  			quicksort(datos, left, pivote-1);
  			quicksort(datos, pivote, right);
  		}else {
  			return;
  		}
  		
  	}
  	
  	private static <E extends Comparable <E>> int particionar(E[] datos, int left, int right) {
  		//Regresa la posicion donde quedó el pivote
  		
  		E pivote = datos[(left +  right) / 2];
  		
  		while(left <= right) {
  			while(datos[left].compareTo(pivote) < 0) {
  				left++;
  			}
  			
  			while(datos[right].compareTo(pivote) > 0) {
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
	
	
	
	
//------------------------------------------------------------------------------------------------------------------Auxiliares
	public static  <E extends Comparable <E>>  void imprimeArreglo(E[] arreglo) {
		//Imprimir el arreglo separado por comas y sin espacios
		for(E valor:arreglo) {
			System.out.print(valor + ",");
		}
		System.out.println();
	}
	
	
	public static <E> void swap(E[] datos, int i, int j) {
		E aux = datos[i];
		datos[i] = datos[j];
		datos[j] = aux;	
	}
	
	
//------------------------------------------------------------------------------------------------------------------MAIN	
	public static void main(String[] args) {
		//Integer[] numeros = {3, 5, 8, -5, 0, 15};
		//String[] nombres = {"LINDA", "ZAPATA","OSCAR", "MONSE","A", "RAUL"};
		//bubbleSort(numeros);
		//imprimeArreglo(numeros);
		//bubbleSort(nombres);
		//imprimeArreglo(nombres);
		
		Integer[] vec={2,8,5,3,9,4,1,7};
		//PreparaMergesort(vec);
		//imprimeArreglo(vec);
		quicksort(vec);
		imprimeArreglo(vec);
		 
	}
}
	
	