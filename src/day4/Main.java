package day4;

import day4.operacionesMath.OperacionesMatematicas;

public class Main {
	/* Crea un paquete que contenga una clase con el método main y otro paquete 
	 * que contenga las operaciones matemáticas básicas: sumar, restar, multiplicar y dividí. 
	 * Mostrar por pantalla la suma, la resta, la multiplicación y la división 
	 * de los números 16 y 32 haciendo uso de la clase que contiene las operaciones matemáticas.
	 */
	public static void main(String[] args) {
		
		System.out.println("Suma: " + OperacionesMatematicas.sumar(16, 32));
		System.out.println("Resta: " + OperacionesMatematicas.restar(16, 32));
		System.out.println("Multiplicación: " + OperacionesMatematicas.multiplicar(16, 32));
		System.out.println("División: " + OperacionesMatematicas.dividir(16, 32));
		
	}
}
