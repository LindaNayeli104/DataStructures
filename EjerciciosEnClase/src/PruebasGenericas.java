



public class PruebasGenericas {
	
	public static <E extends Comparable <E>> void mergesort(E[] datos) {     //Funcion de preparacion
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
		
		int principio, mid, a;
		E[] array_aux = (E[])new Comparable[datos.length];    
	
   
		for (principio=ini; principio<=fin; principio++) {  //copia ambas mitades en el array auxiliar
			array_aux[principio]=datos[principio];
		}
		
		principio=ini; mid=((ini + fin)/2)+1; a=ini;
        while (principio<=((ini + fin)/2) && mid<=fin) { //copia el siguiente elemento más grande
        	if (array_aux[principio].compareTo(array_aux[mid])<=0) {                                                                       //datos[j].compareTo(datos[j+1])>0
            	datos[a++]=array_aux[principio++];
            }
        	else {
        		datos[a++]=array_aux[mid++];
        	}
        }
   
        while (principio<=((ini + fin)/2)) { //copia los elementos que quedan de la primera mitad (si los hay
        	datos[a++]=array_aux[principio++]; 
        }       
	}
	
	
	
 
    
    public static <E extends Comparable <E>> void imprimeArreglo(E[] arreglo) {
		//Imprimir el arreglo separado por comas y sin espacios
		for(E valor:arreglo) {
			System.out.print(valor + ",");
		}
		System.out.println();
	}
    
    
    
  //------------------------------------------------------------------------------------------------------------------QuickSort
	public static <E extends Comparable <E>> void quicksort(E[] datos) {
  		quicksort(datos, 0, datos.length-1);
  	}
  	
  	private static <E extends Comparable <E>> void quicksort(E[] datos, int left, int right) {
  		if(left < right) {
  			int p = particionar(datos, left, right);
  			quicksort(datos, left, p-1);
  			quicksort(datos, p, right);
  		}else {
  			return;
  		}
  		
  	}
  	
  	private static <E extends Comparable <E>> int particionar(E[] datos, int left, int right) {
  		//Regresa la posicion donde quedó el pivote
  		
  		E p = datos[(left +  right) / 2];
  		
  		while(left <= right) {
  			while(datos[left].compareTo(p) < 0) {
  				left++;
  			}
  			
  			while(datos[right].compareTo(p) > 0) {
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
  	
  	
	
//------------------------------------------------------------------------------------------------------------------MAIN      
	public static <E> void swap(E[] datos, int i, int j) {
		E aux = datos[i];
		datos[i] = datos[j];
		datos[j] = aux;	
	}
	
    public static void main(String[] args) {
		Integer[] vec={2,8,5,3,9,4,1,7};
		mergesort(vec);
		imprimeArreglo(vec);
		 
	}
}
