
public class ParaOrdenar<E> {

	
//---------------------------------------------------------------------BubleSort
	public static <E extends Comparable <E>> void bubbleSort(E[] datos) {
		boolean desordenados = true;
		for(int i=0; i<datos.length -1 && desordenados; i++) {
			desordenados = false;
			for(int j=0; j<datos.length -1-i; j++) {
				if(datos[j].compareTo(datos[j+1])>0) {
					swap(datos, j, j+1);
					desordenados=true;
				}
			}
		}
	}
	
//---------------------------------------------------------------MergeSort
	
	public static <E extends Comparable <E>> void preparaMergeSort( E[] datos, int ini, int fin) {
		mergesort(datos, 0, datos.length-1);
	}
	
	
	public static <E extends Comparable <E>> void mergesort(E[] datos, int ini, int fin) {
		if(ini<fin) {
			int mid = (ini+fin)/2;
			mergesort(datos, ini, mid);
			mergesort(datos, mid+1, fin);
			
			merge(datos, ini, fin);
		}
	}
	
	public static <E extends Comparable <E>> void merge(E[] datos, int ini, int fin) {
		
		int principio,
			mid,
			a;
		
		E[] array_aux = (E[]) new Comparable[datos.length];
		
		for(principio = ini; principio <= fin; principio++) {
			array_aux[principio] = datos[principio];
		}
		
		principio = ini;
		mid = ((ini + fin)  /2 ) +1;
		a = ini;
		
		while(principio <= ( (ini + fin) /2)  && mid <= fin) {
			if(array_aux[principio].compareTo(array_aux[mid]) <= 0) {
				datos[a++] = array_aux[principio++];
			}else {
				datos[a++] = array_aux[mid++];
			}
		}
		
		while(principio <= ( (ini+fin) /2) ) {
			datos[a++] = array_aux[principio];
			
			
		}
		
		
	}
	
		public static <E extends Comparable <E>> void PreparaQuick(E[] datos, int left, int rigth) {
			quicksort(datos, left, rigth);	
		}
		
		public static <E extends Comparable<E>> void quicksort(E[] datos, int left, int rigth) {
			if(left<rigth) {
				int pivote = particionar(datos, left, rigth);
				quicksort(datos, left,	pivote-1);
				quicksort(datos, pivote, rigth);
	
			}else {
				return;
			}
		}
		
		
		public static <E extends Comparable<E>> int particionar(E[] datos, int left, int rigth) {
			
			E pivote = datos[(left + rigth) /2];
			
			
			while(left <= rigth) {
				
				while(datos[left].compareTo(pivote) <0) {
					left++;
				}
				
				while(datos[rigth].compareTo(pivote) >0){
					rigth--;
				}			
				
				if(left < rigth) {
					swap(datos, left, rigth);
					left++;
					rigth--;
				}
				
			}
			return left;
			
		}
		
}
