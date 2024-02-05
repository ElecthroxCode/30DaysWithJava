package day3;

import java.util.Scanner;

public class Main {
	/*Se necesita un programa de potenciación que permita recibir número como base 
	 * y un número como exponente y que imprima el resultado por consola.
	 */

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double b, i;
		System.out.println("Escriba la base de la potencia:");
		b = teclado.nextDouble();
		System.out.println("Escriba el indice de la potencia:");
		i = teclado.nextDouble();
		
		System.out.println("Resultado: " + potenciacion(b, i));
	}
	
	public static Double potenciacion(double b, double i) {
		int x = 0;
		double r = 1;
		if(i != 0) {
			while( x < i) {
				r *= b;
				++x;
			}
			return r;
		}
		return r;
	}
}
