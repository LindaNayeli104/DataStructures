import java.util.NoSuchElementException;

public class MyStack<E> {           //Hay que tratar de no usar insertAtLast

	private MiListaEnlazada<E> lista;
	
	public MyStack(){
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
	
	
	public void push(E dato) {
		this.lista.insertAtFirst(dato);
	}
	public E pop() {
		try {
			return this.lista.removeFirst();
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer un pop de una pila vacía");
		}
	}
	
	
	public E top() {
		try {
			return this.lista.first();
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("No se puede hacer un top de una pila vacía");
		}
	}
	
	public static void main(String[] args) {
		MyStack<Integer> pila = new MyStack<>();
		
		for(int i=0; i<10; i++) {
			pila.push(i);	
		}
		
		while(!pila.isEmpty()) {
			System.out.print(pila.pop() + ",");
		}
		System.out.println();
		pila.pop();
		System.out.println();
	}
}
