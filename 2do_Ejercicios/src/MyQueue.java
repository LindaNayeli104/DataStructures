import java.util.NoSuchElementException;

public class MyQueue<E> { ///Se parametriza ponienod <E>
	
	private MiListaEnlazada<E> lista;
	
	
	public MyQueue() {
		this.lista = new MiListaEnlazada<>();
	}
	
	public int size() { //si ponemis static implica que todas las colas tienne e ismo tamaño 
		return this.lista.size();
	}
	
	public boolean isEmpty() {
		return this.lista.isEmpty();
	}
	
	
	public void flush() { //Va a vaciar la cola
		// this.lista = null                           No es bueno dejarla en null porque tenemos que dejarla bien para cunado queremos insertar un dato
		
		this.lista = new MiListaEnlazada<>();
		System.gc();  //Para correr el garbage collector
	}
	
	public void enqueue(E dato) {
		this.lista.insertAtLast(dato);
	}
	
	public E dequeue() {     // Removiendo el último
		try {
			return this.lista.removeFirst();
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer un dequeue de una cola vacía");
		}
		
	}
	
	public E next(){                           //Regresar el siguiente elemento que va a salir, peor no lo elimina
		try {
			return this.lista.first();
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer un next de una cola vacía");
		}
	}
	
	
	
	
	public static void main(String[] args) {
		MyQueue<String> cola = new MyQueue<>();
		cola.enqueue("J");
		cola.enqueue("C");
		cola.enqueue("O");
		cola.enqueue("L");
		cola.enqueue("A");
		cola.enqueue("R");
		cola.enqueue("S");
		
		
		
		while(!cola.isEmpty()) {
			System.out.print(cola.dequeue() + ",");
		}
		System.out.println();
		
		for(int i=0; i<cola.size();i++) {                 //Imprimir la mitad nada mas
			System.out.print(cola.dequeue()+",");
		}
		System.out.println();
	
		
		
	}
	
	
}
