
public class Fibonacci {

	public static long fibonacci(int n) {
		if( n <= 1) {
			return 1;
		}else {
			return fibonacci(n-1) + fibonacci(n-2);
		}	
	}
	
//----------------------------------------------------------------------------------------------------------FORMA OPTIMIZADA
	public static long fibonacciOpt(int n) {  //FUNCION DE PREPARACION
		long[] calculados = new long[n+1];
		calculados[0] = calculados[1] = 1;
		return fibonacciOpt(n, calculados);	
	}
	
	
	private static long fibonacciOpt(int n, long[] calculados) {     //FUNCION RECURSIVA = Privada porque solo la usara la funcion de preparacion
		if(calculados[n] > 0) {
			return calculados[n];
		}else {
			return calculados[n] = fibonacciOpt(n-1, calculados) + fibonacciOpt(n-2, calculados);	
		}
	}

//-----------------------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) {
		/*long ini = System.nanoTime();
		System.out.println(fibonacci(20));
		long fin = System.nanoTime();
		long duracion =  fin - ini;
		System.out.println("Tardo:" + duracion / 1000000000.0 + " seg");
		System.out.println("Tardo:" + (duracion / 1000000000.0)/60 + " seg");
		*/
		
		System.out.println(fibonacciOpt(5));
		//System.out.println(fibonacci(5));
	}
}



//Funcion de preparacion =  Interface publica con la que le usuario va a interactuar
//-Inicializa los parametros y manda a llamar a nuestra funcion recursiva 