import java.util.NoSuchElementException;

//**************************************************************************************************************************CLASS= LinkedLists
public class LinkedLists<E> {   
	
//-----------------------------------------------------------------------Atributos
	private NodoLE<E> first,  
					  last;
	
	private int size;

	
//-----------------------------------------------------------------------Constructor default
	public LinkedLists() {
		this.first = this.last = null;
		this.size = 0;
		
	}

	
//-----------------------------------------------------------------------Constructor con array como parametro
	public LinkedLists(E[] valores) {                                
		this.first = new NodoLE<>(valores[0]);
		
		System.out.println(this.first.dato);
		for(int i=1; i<valores.length; i++) {
			insertAtLast(valores[i]);
			
		}
		size++;
	}
		
		
	public E first() throws NoSuchElementException {              
		try {
			return this.first.getDato();     
		}catch(NullPointerException ex) {
			throw new NoSuchElementException("No se puede obtener el primer dato de una lista vacía");
		}
		
	}
	
	public E last() throws NoSuchElementException {
		try {
			return this.last.getDato();    
		}catch(NullPointerException ex) {
			throw new NoSuchElementException("No se puede obtener el ultimo dato de una lista vacía");
		}          
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {  
		return this.size == 0; 
	}
	
	
	public void insertAtFirst(E dato) {
		this.first = new NodoLE<>(dato, this.first);   //Cuando la lista esta vacia hay una inconsistencia
		
		if(this.size==0) {
			this.last = this.first;
		}
		this.size++;
	}
	
	
	public void insertAtLast(E dato) {
		NodoLE<E> nvo  = new NodoLE<>(dato, null);    
		if(this.size==0) {
			this.first = this.last = nvo;
		}else {
			this.last.next = nvo;
			this.last = nvo;
		}
		this.size++;

	}
	
//---------------------------------------------------------------------------------------------------------	COMPLETAR
	public void insertAt(E dato, int pos) {                                 
		
	}
	
	public E removeFirst() {
		try {
			E dato = this.first();
			this.first = this.first.next;
			this.size--;
			
			if(this.size == 0) {
				this.last = null;
			}
			return dato;
			
		}catch(NullPointerException ex) {
			throw new NoSuchElementException("No se puede eliminar el primer elemento de una lista vacía");
		}
	}
	
	public E removeLast() {
		
		if(this.size <= 1) {
			return removeFirst();
		}else {
			NodoLE <E> current = this.first;
			E dato = this.last();
			
			for(int i=0; i < this.size-2; i++) {
				current = current.getNext();
			}
			current.next = null;
			this.last = current;
			this.size--;
			return dato;
		}
	}
	
	public E removeAt(int pos) throws NoSuchElementException {
		if(this.size <= 1) {
			return removeFirst();
		}
		else if(pos == this.size-1) {
			return removeLast();
		}else {
		NodoLE <E> current = this.first;
		
		for(int i=0; i < pos-1; i++) {
			current = current.next;
		}
		E dato = current.next.dato;
		current.next = current.next.next;
		this.size--;
		return dato;
		}
	}
	
	
	public void setAt(E dato, int pos) {
		
		if(pos<0 || pos >= this.size) {
			throw new IndexOutOfBoundsException("No se puede colocar un valor en la posicion " + pos + "en una lista de tamaño " + this.size);
		}else {
			NodoLE <E> current = this.first;
			
			for(int i=0; i<pos; i++) {
				current = current.next;
			}
			current.dato = dato;
		}
	}
	
	
	public String toString() {
		String res = "";
		NodoLE <E> current = this.first;
		for(int i=0; i<this.size;i++) {
			res += current.dato + ",";
			current = current.next;
		}
		return res;
	}
	
}
	
	
	
//--------------------------------------------------------------------------------------------------------

//**************************************************************************************************************************CLASS= NodoLE

class NodoLE <E>{   
//-----------------------------------------------------------------------Atributos
	E dato;
	NodoLE<E> next;   
	
//-----------------------------------------------------------------------Constructor default	
	public NodoLE(E dato, NodoLE<E> next) {
		this.dato = dato;
		this.next = next;
	}

	
//-----------------------------------------------------------------------Constructor con parametro dato
	public NodoLE(E dato) {
		this(dato, null);	
	}

//-------------------------------------------------------------------------------------------SETTERS Y GETTERS	
	public E getDato() {
		return dato;
	}

	
	public void setDato(E dato) {
		this.dato = dato;
	}

	
	public NodoLE<E> getNext() {
		return next;
	}

	
	public void setNext(NodoLE<E> next) {
		this.next = next;
	}
}