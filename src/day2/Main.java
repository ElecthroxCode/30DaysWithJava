package day2;

public class Main {
	/*	DAY 2
	 * Crear un programa que divida el número 7 entre 2 y que realice el promedio 
	 * de los siguientes números: 5, 28, 33. El programa deberá imprimir por pantalla 
	 * los resultados y  si algunos de los resultados es un número decimal, debes imprimir 
	 * ese resultado pero como un número entero con el siguiente mensaje: 
	 * "Este era un número decimal pero ahora es un entero".
	 * */

	public static void main(String[] args) {
		double a = 7, b = 2, c = 5, d = 28, e = 33, suma, div;
		suma = c + d + e;
		double prom = suma / 3;
		div = a / b;
		System.out.println("DIVISIÓN");
		if(a % b == 0) {
			System.out.printf("El resultado de la división: %d", (int) div);
		} else {
			
			System.out.printf(" %d  <- Este era un número decimal pero ahora es un entero.", (int) div);
		}
		System.out.println("\nPROMEDIO");
		if(suma % 3 == 0) {
			System.out.printf("El resultado del promedio: %d", (int) prom);
		} else {
			
			System.out.printf(" %d  <- Este era un número decimal pero ahora es un entero.", (int) prom);
		}
		

	}

}
