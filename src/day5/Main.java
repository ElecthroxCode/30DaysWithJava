package day5;

import java.util.Scanner;

public class Main {
	/* Escriba una aplicación que reciba del usuario un número compuesto por cinco dígitos, 
	 * que separe ese número en sus dígitos individuales y los imprima, cada uno separado 
	 * de los demás por tres espacios. Por ejemplo, si el usuario escribe el número 42339, 
	 * el programa debe imprimir: 4  2  3  3  9
	 */
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese un número de 5 digitos: ");
		int n = teclado.nextInt();
		
		String s = String.valueOf(n);
		
		if(n <100000 && n > 10000) {
			String z = "";
			System.out.println(s);
			for(int i = 0; i < s.length(); i++) {
				z +=  s.charAt(i) + "   " ;
			}
			System.out.println(z);
			System.out.println("***Fin del programa***");
		}else {
			System.out.println("Tiene que ser un número de 5 digitos validos!");
			System.out.println("***Fin del programa***");
		}
		
	}
	

}
