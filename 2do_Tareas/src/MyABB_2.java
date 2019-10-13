/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: MyABB.java
 Fecha: 10 de octubre de 2019
 Comentarios:Se me dificultó mucho hacer la eliminacion del nodo con dos hijos.
 */

import java.util.NoSuchElementException;

public class MyABB_2 <E extends Comparable<E>>{   //Se parametriza con         <E> extends Comparable
	private NodoABB2<E> root;
	private int size;
	
	public MyABB_2() {
		super();
	}
	
	public E search(E value) {
		NodoABB2<E> current =  this.root;
		
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
		
		NodoABB2<E> current =  this.root;
		NodoABB2<E> current_prev = null;
		NodoABB2<E> nodo_new =  new NodoABB2(value);
		
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

	public void preorden(NodoABB2<E> current) {   //Funcion recorsiva   -> Recibir como parametro un nodo
		if(current != null) {
			System.out.println(current.value + ", ");
			preorden(current.left);
			preorden(current.right);
		}
	}
	
	public void inorden(E value) {
		inorden(this.root);
	}
	
	public void inorden(NodoABB2<E> current) { 
		if(current != null) {
			inorden(current.left);
			System.out.println(current.value + ", ");
			inorden(current.right);
		}
	}

	public void postorden(E value) {
		postorden(this.root);
	}
	
	public void postorden(NodoABB2<E> current) { 
		if(current != null) {
			postorden(current.left);
			postorden(current.right);
			System.out.println(current.value + ", ");
		}
	}
	
	public void nivel(E value) {
		nivel(this.root);
	}
	
	public void nivel(NodoABB2<E> current) {    //Usar cola de java     Imprime separados por ","
		
	}
	
	public E remove(E value) {                        //3 casos con casoso especiales              cuidar size
		NodoABB2<E> current =  this.root,
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
				return current.value;
			}
	   //----------------------------------------------------------------Borrar una un nodo con 1 hijo
			else if((current.left != null && current.right == null) || (current.left == null && current.right != null)) {
				if(parent.left == current && current.left == null) {
					parent.left = current.right;
					//System.out.println("-----" + parent.right.value);
				}
				else if(parent.left == current && current.right == null) {
					parent.left = current.left;
					
				}
				else if(parent.right == current && current.left == null) {
					parent.left = current.right;

				}
				else if(parent.right == current && current.right == null) {
					parent.left = current.left;
					
				}
				return current.value;
			}
			
	   //----------------------------------------------------------------Borrar un nodo con 2 hijos
			else if(current.left != null && current.right != null) {
				NodoABB2<E> sucesor=  current.right;
				
				while(sucesor.left != null) {
					sucesor = sucesor.left;
				}
				
				NodoABB2<E> aux=   new NodoABB2<E>(sucesor.value, current.left, current.right);
				
				
				if(current.value.compareTo(parent.value)<0) {
					parent.left = aux;
				}else if(current.value.compareTo(parent.value)>0) {
					parent.right = aux;
				}
	//------------------------------------------------------------------------------------------PARTE NUEVA     
				
				if(current.value.compareTo(parent.value)<0) {
					parent = sucesor.;
				}else if(current.value.compareTo(parent.value)>0) {
					parent.right = aux;
				}
				parent = sucesor.right;
				while(!parent.left.value.equals(sucesor.value)) {
					if() {
						parent = parent.left;
					}else {
						num_sucesores += 1;
					}
					
				}//while end
				parent
				if(current.value.compareTo(parent.value)>0) {
					parent.right = aux;
				}
				//remove(sucesor.value);
				/*
				NodoABB2<E> remove_pos =   new NodoABB2<E>(current.right.value);
				
				System.out.println("current ini: " + current.value);
				while(!current.left.equals(null) && !current.left.value.equals(sucesor.value)) {           //*****Checar
					current = current.right;
					System.out.println("current: " + current.value);
				}
				if(current.left.equals(sucesor.value) && !current.left.right.equals(null)) {
					current.left = current.left.right;
				}
				else if(current.left.equals(sucesor.value) && !current.left.right.equals(null)) {
					current.left = null;
				}
				
				*/
			
			}
				size--;
				return current.value;
		}catch(NullPointerException ex) {
			throw new NoSuchElementException("No se encontró el valor " + value + " en el árbol");
		}
	}
	
	
//---------------------------------------------------------------------------------------------------MAIN	
	public static void main(String[] args) {
		MyABB_2<Integer> arbol = new MyABB_2<>();
		 
	
		
   //------------------------------------------------	
		/*
		arbol.root = new NodoABB2(21);
		arbol.root.left = new NodoABB2(13);
		arbol.root.right = new NodoABB2(33);
		arbol.root.left.left = new NodoABB2(10);
		arbol.root.left.right = new NodoABB2(18);
		arbol.root.right.left = new NodoABB2(25);
		arbol.root.right.right = new NodoABB2(40);
		arbol.root.right.left.right= new NodoABB2(27);
		
		arbol.root.right.right.right= new NodoABB2(42);
		arbol.root.right.right.right.right= new NodoABB2(43);
		arbol.root.right.right.right.left= new NodoABB2(41);
		
		arbol.size = 11;
		
		arbol.preorden();
		System.out.println("size:" +arbol.size);
		System.out.println("---------------");
		System.out.println(arbol.remove(42));
		
		System.out.println("---------------");
		arbol.preorden();
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
		
		arbol.root = new NodoABB2(10);
		arbol.root.left = new NodoABB2(5);
		arbol.root.right = new NodoABB2(15);
		arbol.root.left.left = new NodoABB2(3);
		arbol.root.left.right = new NodoABB2(8);
		arbol.root.left.right.left = new NodoABB2(6);
		arbol.root.left.right.right = new NodoABB2(9);
		arbol.root.left.right.left.right = new NodoABB2(7);
		
		
		
		arbol.root.right.left = new NodoABB2(12);
		arbol.root.right.right = new NodoABB2(20);
		arbol.root.right.right.right = new NodoABB2(30);
		
		arbol.size = 11;
		
		//arbol.preorden();
		System.out.println("size:" +arbol.size);
		System.out.println("---------------");
		System.out.println(arbol.remove(5));
		
		System.out.println("---------------");
		arbol.preorden();
		System.out.println("size" + arbol.size);
		
	//---------------------------------------------------	
	}
	
	
}

//-------------------------------------------------------------------------------------------------------------------NodoABB2
class NodoABB2 <E extends Comparable<E>>{
	final E value;
	NodoABB2<E> left,
			   right;
	
	
	public NodoABB2(E value) {
		super();
		this.value = value;
	}
	
	
	public NodoABB2(E value, NodoABB2<E> left, NodoABB2<E> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
//------------------------------------------------------------------------------------------GETTERS Y SETTERS     Se quitó setValue
	public E getValue() {
		return value;
	}
	
	
	public NodoABB2<E> getLeft() {
		return left;
	}
	public void setLeft(NodoABB2<E> left) {
		this.left = left;
	}
	public NodoABB2<E> getRight() {
		return right;
	}
	public void setRight(NodoABB2<E> right) {
		this.right = right;
	}
	
	
}

//Operadores ternarios siempre regresa algo
//If    no siempre regresa algo

