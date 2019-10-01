
public class MaximoRecursivo {

	public static int MaxRec(int[] lista, int pos) {
		if(pos == lista.length-1) {
			return lista[pos];
		}else {
			int max = MaxRec(lista, pos+1);

			if(lista[pos] > max) {
					return  lista[pos];
			}else{
				return max;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] lista = {4,5,0,3,1};
		System.out.println(MaxRec(lista, 0));
	}
}
