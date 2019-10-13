/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: MyABB.java
 Fecha: 10 de octubre de 2019
 Comentarios:Se me dificultó mucho hacer la eliminacion del nodo con dos hijos.
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MyABB <E extends Comparable<E>>{   //Se parametriza con         <E> extends Comparable
	private NodoABB<E> root;
	private int size;
	
	public MyABB() {
		super();
	}
	
	public E search(E value) {
		NodoABB<E> current =  this.root;
		
		while(current != null) {
			
			if(current.value.equals(value)) {
				return current.value;
				
			}else if(value.compareTo(current.value)<0) {
				current = current.left;
				
			}else {
				current = current.right;
			}
		}
		throw new NoSuchElementException("No se encontró el valor  " + value + " en el árbol");
	}
	
	
	public void insert(E value) {                                 
		
		NodoABB<E> current =  this.root;
		NodoABB<E> current_prev = null;
		NodoABB<E> nodo_new =  new NodoABB(value);
		
		if(current == null) {
			this.root = nodo_new;              
			
		}else {
		
			while(current != null) {
				
				if(value.compareTo(current.value)<0) {
					current_prev = current;
					current = current.left;
					
				}else if(value.compareTo(current.value)>0) {
					current_prev = current;
					current = current.right;
				}else if(value.equals(current.value)) {
					throw new NoSuchElementException("El valor  " + value + " ya se encontraba en el árbol");
				}
			}
			if(value.compareTo(current_prev.value)<0) {
				
				current_prev.setLeft(nodo_new);
				size++;
			}else {
				current_prev.setRight(nodo_new);
				size++;
			}
		}
	}// insert end
	
	
	public void preorden() {   //Funcion de preparacion
		preorden(this.root);
	}

	public void preorden(NodoABB<E> current) {   //Funcion recorsiva   -> Recibir como parametro un nodo
		if(current != null) {
			System.out.println(current.value + ", ");
			preorden(current.left);
			preorden(current.right);
		}
	}
	
	public void inorden() {
		inorden(this.root);
	}
	
	public void inorden(NodoABB<E> current) { 
		if(current != null) {
			inorden(current.left);
			System.out.println(current.value + ", ");
			inorden(current.right);
		}
	}

	public void postorden() {
		postorden(this.root);
	}
	
	public void postorden(NodoABB<E> current) { 
		if(current != null) {
			postorden(current.left);
			postorden(current.right);
			System.out.println(current.value + ", ");
		}
	}
	
	
	
//-----------------------------------------------------------------------------------------------------------------------------------------------NIVEL
	public void nivel() {
		Queue<NodoABB> cola=new LinkedList();
		nivel(this.root, cola);
	}
	
	public void nivel(NodoABB<E> current, Queue<NodoABB> cola) {    //Usar cola de java     Imprime separados por ","
		if(current != null) {
			System.out.println(current.value + ", ");
			try {
				if(!current.left.equals(null)) {
					cola.add(current.left);
				}
			}catch(NullPointerException ex) {
				
			}
			try {
				if(!current.right.equals(null)) {
					cola.add(current.right);
				}
			}catch(NullPointerException ex) {
				
			}
			try {
				if (!cola.peek().equals(null)) {
					nivel(cola.poll(), cola);
				}
			}catch(NullPointerException ex) {
			
			}
		}
	}
//-----------------------------------------------------------------------------------------------------------------------------------------------REMOVE
	public E remove(E value) {                        //3 casos con casoso especiales              cuidar size
		NodoABB<E> current =  this.root,
				   parent = null;
		try {
			while(!current.value.equals(value)) {
				parent = current;
				current =  value.compareTo(current.value)<0? current.left : current.right;	
			}
			//Current está en ele valor a borrar y parent en el padre del nodo a borrar
			
		//----------------------------------------------------------------Borrar una hoja
			if(current.left == null && current.right == null) {
				if(parent.left == current) {
					parent.left = null;
				}else {
					parent.right = null;
				}
				this.size--;
				return current.value;
			}
	   //----------------------------------------------------------------Borrar una un nodo con 1 hijo
			else if((current.left != null && current.right == null) || (current.left == null && current.right != null)) {
				
				System.out.println("parent: " + parent.value);
				System.out.println("current: " + current.value);
				
				if(parent.left == current && current.left == null) {
					parent.left = current.right;
					//System.out.println("-----" + parent.right.value);
				}
				else if(parent.left == current && current.right == null) {
					parent.left = current.left;
					
				}
				else if(parent.right == current && current.left == null) {   //***
					parent.right = current.right;
					System.out.println("parent.left: " + parent.left.value);

				}
				else if(parent.right == current && current.right == null) {
					parent.right = current.left;
					
				}
				this.size--;
				return current.value;
			}
			
	   //----------------------------------------------------------------Borrar un nodo con 2 hijos
			else if(current.left != null && current.right != null) {
				this.size++;
				E res = current.value;
				NodoABB<E> sucesor =  current.right;
				
				while(sucesor.left != null) {
					sucesor = sucesor.left;
				}
		
				this.remove(sucesor.value);
				current.value = sucesor.value;
				this.size--;
				return res;
			}
			
		}catch(NullPointerException ex) {
			throw new NoSuchElementException("No se encontró el valor " + value + " en el árbol");
		
		}
		return value;
	}
		
	
	
//------------------------------------------------------------------------------------------------*******************************************         MAIN	
	public static void main(String[] args) {
		MyABB<Integer> arbol = new MyABB<>();
		
	
		
   //------------------------------------------------	
		/*
		arbol.root = new NodoABB(21);
		arbol.root.left = new NodoABB(13);
		arbol.root.right = new NodoABB(33);
		arbol.root.left.left = new NodoABB(10);
		arbol.root.left.right = new NodoABB(18);
		arbol.root.right.left = new NodoABB(25);
		arbol.root.right.right = new NodoABB(40);
		arbol.root.right.left.right= new NodoABB(27);
		
		arbol.root.right.right.right= new NodoABB(42);
		
		arbol.root.right.right.right.right= new NodoABB(45);
		arbol.root.right.right.right.left= new NodoABB(41);
		
		arbol.root.right.right.right.right.right= new NodoABB(47);
		arbol.root.right.right.right.right.left =  new NodoABB(43);
	
		
		arbol.size = 13;
		System.out.println("NIVEL----------------------------------------------------------------------------------------------------------------");
		arbol.nivel();
		
		System.out.println("size:" +arbol.size);
		System.out.println("---------------");
		//System.out.println(arbol.remove(45));
		
		System.out.println("---------------");
		//arbol.preorden();
		System.out.println("size" + arbol.size);
		
		*/
		
//--------------------------------------------------------------
		//System.out.println(arbol.search(60));
		//arbol.insert(20);
		//arbol.insert();
		//arbol.insert(62);
		
		//System.out.println(arbol.search(85));
		//System.out.println(arbol.root.left.left.value);
		//System.out.println(arbol.search(62));
		//System.out.println(arbol.size);
		
		/*
		arbol.insert(62);
		//System.out.println(arbol.search(62));
		System.out.println(arbol.root.value);
		*/
		//-----------------------------------------------------------CASO 2
		
		arbol.root = new NodoABB(10);
		arbol.root.left = new NodoABB(5);
		arbol.root.right = new NodoABB(15);
		arbol.root.left.left = new NodoABB(3);
		arbol.root.left.right = new NodoABB(8);
		arbol.root.left.right.left = new NodoABB(6);
		arbol.root.left.right.right = new NodoABB(9);
		arbol.root.left.right.left.right = new NodoABB(7);
		
		
		
		arbol.root.right.left = new NodoABB(12);
		arbol.root.right.right = new NodoABB(20);
		arbol.root.right.right.right = new NodoABB(30);
		
		arbol.size = 11;
		arbol.nivel();
		System.out.println(arbol.remove(5));
		arbol.nivel();
		/*
		arbol.preorden();
		System.out.println("size:" +arbol.size);
		System.out.println("---------------");
		System.out.println(arbol.remove(5));
		
		System.out.println("---------------");
		arbol.preorden();
		System.out.println("size" + arbol.size);
		*/
	//---------------------------------------------------	
	}
	
	
}

//-------------------------------------------------------------------------------------------------------------------NodoABB
class NodoABB <E extends Comparable<E>>{
	E value;
	NodoABB<E> left,
			   right;
	
	
	public NodoABB(E value) {
		super();
		this.value = value;
	}
	
	
	public NodoABB(E value, NodoABB<E> left, NodoABB<E> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
//------------------------------------------------------------------------------------------GETTERS Y SETTERS     Se quitó setValue
	public E getValue() {
		return value;
	}
	
	
	public NodoABB<E> getLeft() {
		return left;
	}
	public void setLeft(NodoABB<E> left) {
		this.left = left;
	}
	public NodoABB<E> getRight() {
		return right;
	}
	public void setRight(NodoABB<E> right) {
		this.right = right;
	}
	
	
}

//Operadores ternarios siempre regresa algo
//If    no siempre regresa algo
