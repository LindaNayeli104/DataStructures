

public class EstrellaChico {
	
	public static void puente(int ini, int fin)
	{   	
		imorime(ini);
		if(ini <= fin)
		{
			puente(ini+1,fin);
		   	imorime(ini);
		}
		
	}

	public static void imorime(int ini)
	{
		if(ini == 1) System.out.println("*");
		else
		{
			System.out.print("*");
			imorime(ini-1);
		}
	}
	public static void main(String[] arg) {
		puente(1, 5);
	}
}

