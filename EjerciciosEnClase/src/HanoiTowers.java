
public class HanoiTowers {

	static void move(int n, char from,char to, char inter) {    //Mover n discos de A a C, pasando por B
		
	
		if(n == 1) {
			System.out.println("Moving disc " +  n + " from " + from + " to " + to);
			
		}
		else {
			move(n-1, from, inter, to);
			System.out.println("Moving disc " +  n + " from " + from + " to " + to);
			move(n-1, inter, to, from);
		}
		
		
		
		
	}
	
public static void main(String[] args) {
	
	HanoiTowers toh = new HanoiTowers();
	toh.move(3, 'A', 'C', 'B');

	}
	
}
