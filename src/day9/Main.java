package day9;

import java.util.Scanner;

public class Main {
	/*Un palíndromo es una secuencia de caracteres que se lee igual al derecho y al revés. Por 	ejemplo, cada uno de los siguientes enteros de cinco dígitos es un palíndromo: 12321, 	55555, 	45554 y 11611. Escriba una aplicación que lea un entero de cinco dígitos y 	determine 	si es un 	palíndromo. Si el número no es de cinco dígitos, el programa debe 	mostrar un 	mensaje de error 	y permitir al usuario que introduzca un nuevo valor.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String txt = "";
		System.out.println("Ingres un numero válido de 5 digitos: ");
		int a = entrada.nextInt();
		if(a > 10000  && a < 100000) {
			String s = String.valueOf(a);
			for(int i = s.length() -1; i >= 0; i--) {
				txt += s.charAt(i);
			}
			if(s.equalsIgnoreCase(txt)) {
				System.out.printf("\nEl número %s es un palíndromo.\n", txt);
			}else {
				System.out.printf("\nEl número %s NO ES un palíndromo.\n", txt);
			}
		}else {
			System.out.println("Tienes que ingresa un número de 5 digitos válidos!");
			System.out.println("**Fin del programa**");
		}

	}

}
