/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: MiListaEnlazada.java
 Fecha: 04 de septiembre de 2019
 Comentarios: La funci� que m�s me cost� trabajo fue InsertAt
 */


import java.util.NoSuchElementException;


public class MiListaEnlazada<E> {   //La E porque quiero que sea 
	private NodoLE<E> first,  //El unico requisito es este, first        Se agrega el size de la lista para bajar la complejidad de n a constante
					  last;
	
	private int size;
	
	public MiListaEnlazada() {
		this.first = this.last = null;
		this.size = 0;
		// O poner  solamente             super();
	}
	
	public MiListaEnlazada(E[] valores) {                                 //Crea una nueva lista con los valores que tiene el arreglo que le pase
		this.first = new NodoLE<>(valores[0]);
		
		System.out.println(this.first.dato);
		for(int i=1; i<valores.length; i++) {
			insertAtLast(valores[i]);
			System.out.println(this.last.dato);  //Para probar
		}
		size++;
	}
		
		
	public E first() throws NoSuchElementException {                //Si no se puede arrojar� esta excepcion 9+6
		try {
			return this.first.getDato();     //Mas enfocada a POO
		}catch(NullPointerException ex) {
			throw new NoSuchElementException("No se puede obtener el primer dato de una lista vac�a");
		}
		//return this.first.dato;                Cualquiera de las dos       //Mas enfoocada a ED
	}
	
	public E last() throws NoSuchElementException {
		try {
			return this.last.getDato();    
		}catch(NullPointerException ex) {
			throw new NoSuchElementException("No se puede obtener el ultimo dato de una lista vac�a");
		}
		//return this.last.dato;                
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {  
		//return this.first == null;     //Otra opcion 
		return this.size == 0; 
	}
	
	
	public void insertAtFirst(E dato) {
		/*NodoLE<E> nvo = new NodoLE<>(dato, this.first);   //Cuando la lista esta vacia hay una inconsistencia
		this.first = nvo;
		this.size++;*/
		
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
		//System.out.println(this.last.dato);
	}
	
//---------------------------------------------------------------------------------------------------------	
	public void insertAt(E dato, int pos) {                                 
		NodoLE<E> nodo  = new NodoLE<>(dato); 
	    nodo.dato = dato;
	    nodo.next = null;
	    
	    try {
	    if (this.first == null) {
	      
	      if (pos != 0) {
	       return;
	      } else { 
	       this.first = nodo;
	      }
	    }
	    
	    NodoLE<E> actual = this.first;
	    NodoLE<E> previo  = null;

	    int i = 0;

	    while (i < pos) {
	      previo = actual;
	      actual = actual.next;
	      
	      if (actual == null) {
	        break;
	      }
	       i++;
	      }
	      nodo.next = actual;
	      previo.next = nodo;
	      size ++;
	    }catch(NullPointerException e) {
			throw new IndexOutOfBoundsException("Operaci�n no v�lida");
		}
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
		}catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede borrar el inicio de una lista vac�a");
		}
	}
	
	public E removeLast() { // Apuntaria a null si es que esta vacia la lista
		
		if(this.size<=1) {
			return removeFirst();
		}else {
			NodoLE<E> current = this.first;
			E dato = this.last();
			for(int i=0;i <= this.size-2; i++) {
				current =  current.getNext();
			}	
			current.next = null;
			this.last = current;
			this.size--;
			return dato;
		}
			
	}
	
	public E removeAt(int pos) throws NoSuchElementException{
			if(this.size <= 1) {
				return this.removeFirst();  //Aqui hacemos el try catch
			}else if (pos == this.size-1){
				return this.removeLast();    //Aqui hacemos el try catch
			} else{
				NodoLE<E> current = this.first;
				E dato;
				for(int i=0;i < pos-1; i++) {
					current =  current.getNext();
				}	
			    dato =  current.getNext().getDato();
			    current.setNext(current.getNext().getNext());
				this.size--;
				return dato;
			}	
	}
	
	public void setAt(E dato, int pos) throws IndexOutOfBoundsException {  //Lo quito y pongo a otro, no cambia el size de la linkedlist
		
		if(pos<0 || pos>= this.size) {
			throw new IndexOutOfBoundsException("No se puede colocar un valor en la posicion" + pos + "en una lista de tamana�o" + this.size);	
		}else {
			NodoLE<E> current = this.first;
			for(int i=0;i <= pos; i++) {
				current =  current.getNext();
			}
			current.setDato(dato);
		}		
	}
	
	public String toString() {
		String res = "";
		NodoLE<E> current = this.first;
		for(int i=0; i<this.size;i++) {
			res += current.getDato() + ",";
			current = current.getNext();
 		}
		return res;
		
	}
		
//------------------------------------------------------------------------------------------------------------------------------MAIN
	public static void main(String[] args) {       
		Integer[] array = {3,6,5};
		MiListaEnlazada le = new MiListaEnlazada(array);
		System.out.println(le.size());;
		//le.insertAtLast(15);
		//System.out.println(le.last.dato);
		
		//System.out.println(le.size());;
		//le.insertAt(5, 2);
		//System.out.println(le.size());;	
		}
}



class NodoLE <E>{   //LE Lista enlazada    //Los manejamos como default 
	E dato;
	NodoLE<E> next;   //<E> para que guarde lo que le mande "generico"
	
	
	public NodoLE(E dato, NodoLE<E> next) {
		this.dato = dato;
		this.next = next;
	}

	
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
