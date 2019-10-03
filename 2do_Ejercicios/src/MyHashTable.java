/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: MyHashTable.java
 Fecha: 02 de octubre de 2019
 Comentarios: No recordaba que era un HashCode
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyHashTable<K,V> {    //Con Direccionamiento por Encadenamiento             //Arreglos, Listas enlazadas, Genericos
	private LinkedList<MyNodoHT<K,V>>[] tabla;          //Tabla de listas enlazadas con nodos(nodos hash tables)
	private int size;
	private static final double loadFactor = 0.75;
	
	
	public MyHashTable(){
		this.tabla = (LinkedList<MyNodoHT<K,V>>[])new LinkedList[11];    //No se podia declarar un array a partir de genericos
		for(int i=0; i<this.tabla.length;i++) {
			this.tabla[i] = new LinkedList<>();  
		}
		this.size = 0;
	}
	
	
	public void put(K llave, V valor) {   // rehasing = rehacer
		if(((double) this.size) / this.tabla.length > MyHashTable.loadFactor) {
			rehasing();
		}
		int pos = Math.abs(llave.hashCode()) % this.tabla.length;  // % da un res:  entre 0 y n-1
		this.tabla[pos].add(new MyNodoHT<K,V>(llave, valor));
		this.size++;
	}
	
	
	private void rehasing() {  
		LinkedList<MyNodoHT<K,V>>[] t_temp = this.tabla;  
		
		this.tabla= (LinkedList<MyNodoHT<K,V>>[])new LinkedList[this.tabla.length*2+1];
		
		for(int i=0; i<this.tabla.length;i++) {
			this.tabla[i] = new LinkedList<>();   
		}
		
		for(int i=0; i<t_temp.length;i++) {
			while(!t_temp[i].isEmpty()) {
				put(t_temp[i].getFirst().llave,t_temp
						[i].getFirst().valor);
				t_temp[i].removeFirst();
			}
		}	
	}
	
	
	public V get(K llave) {
		int pos = Math.abs(llave.hashCode()) % this.tabla.length;  
		try {
		for(MyNodoHT<K,V> nodo : tabla[pos]) {
			if(nodo.llave.equals(llave)) {
				return nodo.valor;
			}	
		}
		throw new Exception();
		}catch(Exception ex) {
			throw new NoSuchElementException("No se encontr� el elemento asociado a esa llave");
		}
	}
	
	
	public V remove(K llave) {
		int pos = Math.abs(llave.hashCode()) % this.tabla.length;  
		V res;
		try {
			for(MyNodoHT<K,V> nodo : tabla[pos]) {
				if(nodo.llave.equals(llave)) {
					res = nodo.valor;
					tabla[pos].remove(nodo);
					return res;
				}	
			}
			throw new Exception();
			}catch(Exception ex) {
				throw new NoSuchElementException("No se encontr� el elemento asociado a esa llave");
			}
		
	}
	
	
	public boolean containsKey(K llave) {
		int pos = Math.abs(llave.hashCode()) % this.tabla.length;  
		for(MyNodoHT<K,V> nodo : tabla[pos]) {
			if(nodo.llave.equals(llave)) {
				return true;
			}	
		}
		return false;
	}
	
//--------------------------------------------------------------------------------------------------------MAIN
	public static void main(String[] args) {
		MyHashTable<String, Integer> ht = new MyHashTable<String, Integer>();
		
		ht.put("a", 1);
		ht.put("b", 2);
		ht.put("c", 3);
		ht.put("d", 4);
		ht.put("e", 5);
		ht.put("f", 6);
		ht.put("g", 7);
		ht.put("h", 8);
		ht.put("i", 9);
		ht.put("j", 10);
		ht.put("k", 11);
		/*
		for(int i=0; i< ht.tabla.length;i++) {
			System.out.println(ht.tabla[i]);
		}
		*/
		//System.out.println(ht.get("h"));
		/*System.out.println(ht.remove("c"));
		
		for(int i=0; i< ht.tabla.length;i++) {
			System.out.println(ht.tabla[i]);
		}
		*/
		System.out.println(ht.containsKey("a"));
	}
}

//---------------------------------------------------------------------------------------------------------MyNodoHT<K,V>
class MyNodoHT<K,V> {
	K llave;
	V valor;
	
	public MyNodoHT(K llave, V valor){
		this.llave = llave;
		this.valor = valor;
	}
	
	public String toString() {
		return "Key: " + this.llave + ", value:" + this.valor; 
	}
	
}



