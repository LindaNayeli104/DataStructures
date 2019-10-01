
public class BubbleSort2{

	public static void bubblesort(int[] numeros) {
		
		boolean desordenados = true;
		for(int i=0; i<numeros.length-1 && desordenados; i++){
			desordenados =  false;
			for(int j=0; j<numeros.length-1-i; j++) {
				if(numeros[j] > numeros[j+1]) {
					swap(numeros,j, j+1);
					desordenados = true;
				}	
			}
		}		
	}//bubble sort
	
	public static void swap(int[] numeros, int num1, int num2) {
		int aux = numeros[num1];
		numeros[num1] = numeros[num2];
		numeros[num2] = aux;
	}
	
	public static void imprimeArreglo(int[] arreglo) {
		for(int valor:arreglo) {                  //for(int i=0; i<arreglo.length-1;i++) {
			System.out.print(valor+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arreglo = {8,-5,5,0,-3};
		bubblesort(arreglo);
		imprimeArreglo(arreglo);
	}
	
}
