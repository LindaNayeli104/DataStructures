
public class Factorial{
	
	static long factorial(int n) {
		if(n <= 1) {
			return 1;
		}
		else {
			long resultado = n * factorial(n-1);
			return resultado;
			
		}
		
		
	}





public static void main(String[] args) {
	
	int n = 5;
	System.out.println(factorial(n));
	
 }
}


/*
 base10a2********************************************************************
public static String base10a2(int numero){
	if (numero <= 1){
		return Integer.toString(numero%2);
	}else {
		return base10a2(numero/2) + Integer.toString(numero%2);
	}

}

*/
