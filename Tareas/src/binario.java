
public class binario {
	
	public static int binconv(int num) {
		int n = 0, res = 0;
		
		if(num == 1) {
			return res + 2^n;	
		}
		else if(num%2 == 1) {
			res = res + (2^n);
		}
		n++;
		return binconv(num/10) + res;
	}

	
	
	public static void main(String[] args) {
		System.out.println(binconv(100));
	}
}

