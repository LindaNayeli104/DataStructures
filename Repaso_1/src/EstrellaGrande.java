



public class EstrellaGrande{

	public static void puente(int altura){
        if (altura < 1){
            return;
            
        }
            System.out.print("*");
            imprime(altura-1);
            System.out.println();
            puente(altura-1);
            


            //RETURN VALUES
            imprime(altura);
            System.out.println();
    }
	
	public static void imprime(int estrella){
        if (estrella < 1){
            return;
        }
        System.out.print("*");
        imprime(estrella - 1);
    }


    




    public static void main (String args[] ){
       puente(4);
    }
}