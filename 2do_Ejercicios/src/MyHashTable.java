import java.util.LinkedList;

public class MyHashTable<K,V> {    //Con Direccionamiento por Encadenamiento             //Arreglos, Listas enlazadas, Genericos
	private LinkedList<MyNodoHT<K,V>>[] tabla;          //Tabla de listas enlazadas con nodos(nodos hash tables)
	private int size;
	private static final double loadFactor = 0.75;
	
	public MyHashTable(){
		this.tabla = (LinkedList<MyNodoHT<K,V>>[])new LinkedList[11];    //**********  Dijo que no se podia declarar un array a partir de genericos
		for(int i=0; i<this.tabla.length;i++) {
			this.tabla[i] = new LinkedList<>();   //********** Cuando se pone solo los <>
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
		
	}
/*	
	public V remove (K llave) {
		//Boorsa de la tabla el elemento que tiene esa llave y regresa el valor asociado
		//Si la llave no esta arrojada NoSuchElementException
	}
	
*/
	
	//get(llave)   : valor                        Se va a lista a la posicion a donde deberia estar guardada la
	//												llave, voy a iterra la lista y vere si en alguna elemento esta guardado
	//												la llave y regre algo, sino no un no such element exception
	//			puedo usar un for each / Iterador --->  For mejorado
	
	//private rehasing() : Incrementa el tama�o de la lista al doble+1  cuando se exceda el loadFactor
	//containsKey : Boolena si la llave esta en la HT
	
			//
	//remove                 buscar elemento y si borrarlo y si no arrojar excecion 
	
	
	//Al insertar primero se hace el reharsing 
	
	public static void main(String[] args) {
		//MyHashTable<String, Integer> ht = new MyHashTable<String, Integer>();
	}
	
	
	

}



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


//CointainsValue es dificil
