/*
 Autor: Linda Nayeli Abundis Lopez   A01636416
 Nombre de la clase: EvaluarExpresion.java
 Fecha: 23 de septiembre de 2019
 Comentarios: Me cost� mucho encontrar la manera de resolver el problema
 */

import java.util.Stack;
public class EvaluarExpresion {
	private String expresionInfija;

	public EvaluarExpresion(String expresionInfija) {                               //CONSTRUCTOR
		this.expresionInfija = expresionInfija;
	}


	public void setExpresionInfija(String expresionInfija) {                         //SETTER 
		this.expresionInfija = expresionInfija;
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	public double evaluaExpresion(String expresionInfija) {
		String[] postfija = expresionPostfijo(expresionInfija).split(" ");
		Stack < Double > pila = new Stack < Double > ();
		double op_1;
		double op_2;
		
		for(int i=0; i<postfija.length; i++) {
			if(EvNum(postfija[i]) == true) {
				pila.push(Double.parseDouble(postfija[i]));
			}
			else {
				
				op_2 = pila.pop();
				op_1 = pila.pop();
				
				 switch (postfija[i]) {
			       
			        case "+":
			            pila.push(op_1+op_2);
			            break;
			        case "-":
			            pila.push(op_1-op_2);
			            break;
			        case "*":
			            pila.push(op_1*op_2);
			            break;
			        case "/":
			            pila.push(op_1/op_2);
			            break;
			        case "^":
			            pila.push(Math.pow(op_1, op_2));
			            break;
			        }
			}//else end
		}//for end
		return pila.pop();	
	}
	
	
	public static boolean EvNum(String cadena) {
        try {
        	Double.parseDouble(cadena);
        	//System.out.println(x);
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public String expresionPostfijo(String expresionInfija) {
		String[] infija = expresionInfija.split(" ");
		String[] resultado = new String[infija.length];
		Stack < String > pila = new Stack < String > ();          //Creo la pila
		int pos = -1;
		
		for(int i=0; i< infija.length; i++) {
			
			if(infija[i].equals("+") || infija[i].equals("-") || infija[i].equals("*") || infija[i].equals("/") || infija[i].equals("^") || infija[i].equals( "(") || infija[i].equals( ")") ){
				
				if(pila.empty() ) {
					pila.push(infija[i]);
				
				}else {
					int signo_actual;
					int signo_pila = jerarquia(pila.peek());
					
					if(infija[i].equals("+") || infija[i].equals("-")) {
						signo_actual = 2;
						
						if(signo_actual <= signo_pila) {
							while(pila.empty() == false) {
								if(!pila.peek().equals("(")) {
									pos += 1;
									resultado[pos] = pila.pop();
								}	
								else if(pila.peek().equals("(")) {
									break;
								}
							}
							pila.push(infija[i]);
							
						}else {
							pila.push(infija[i]);
						}
					}
					
					else if(infija[i].equals("*") || infija[i].equals("/")) {
						signo_actual = 3;
						if(signo_actual <= signo_pila) {
						
							while(pila.empty() == false) {
								if(!pila.peek().equals("(")) {
									pos += 1;
									resultado[pos] = pila.pop();
								}
								else if(pila.peek().equals("(")) {
									break;
								}
							}
							pila.push(infija[i]);
						}else {
							pila.push(infija[i]);
						}
					}
					
					else if(infija[i].equals("^") ) {
						signo_actual = 4;
						
						if(signo_actual <= signo_pila) {
							while(pila.empty() == false) {
								if(!pila.peek().equals("(")) {
									pos += 1;
									resultado[pos] = pila.pop();
								}
								if(pila.peek().equals("(")) {
									break;
								}
							}
							pila.push(infija[i]);
						}else {
							pila.push(infija[i]);
						}
					}
					else if(infija[i].equals("(")){
						pila.push(infija[i]);
					}
					else if(infija[i].equals(")") ){
						while(!pila.peek().equals("(")) {
							pos += 1;
							resultado[pos] = pila.pop();
						}
						pila.pop();
					}
				}	
			}
			else {

				pos += 1;
				resultado[pos] = infija[i];
			}		
		
	}//for end
		
		while(pila.empty() == false) {
			pos += 1;
			resultado[pos] = pila.pop();
		}
		
		String res = "";
		
		for(int i=0; i<resultado.length;i++) {
			if(resultado[i] != (null)) {
				res = res + resultado[i] + " ";
			}
				
		}
		
		
		
		return res;
	}
	
//---------------------------------------------------------------------------------------------------------------------------------------------------------	
	 public static int jerarquia(String elemento) {
	        int jer = 0;
	        switch (elemento) {
	        case ")":
	            jer = 5; break;
	        case "^":
	            jer = 4; break;
	        case "*": case "/":
	            jer = 3; break;
	        case "+": case "-":
	            jer = 2; break;
	        case "(":
	            jer = 1; break;
	        }
	        return jer;
	    }
	
//---------------------------------------------------------------------------- MAIN
	
	public static void main(String[] args) {
		String expresion = "( 5 + 10 * 2 - 3 / 4 ) * ( 10 + 20 / 2 )";
		String exp = "10 + 20 * ( 50 / 2 ) - 5.8";
		EvaluarExpresion e = new EvaluarExpresion(expresion);
		String resultado = e.expresionPostfijo(exp);
		System.out.println(resultado);
		
		double res = e.evaluaExpresion(expresion);
		System.out.println(res);
	

		
	}
}