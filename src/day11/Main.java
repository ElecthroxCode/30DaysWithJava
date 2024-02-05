package day11;

import java.util.Scanner;

public class Main {
	/*
	 * Escriba un método llamado esPar que utilice el operador residuo (%) para determinar si un entero dado es par. El método debe tomar un argumento entero y devolver true si el entero es par, y false en caso contrario. Incorpore este método en una aplicación que reciba como entrada una secuencia de enteros (uno a la vez), y que determine si cada uno es par o impar.
	 **/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n [] = new int[5];
		int cont = 0;
		do {
			System.out.println("Ingrese un número para saber si es PAR: ");
			int x = sc.nextInt();
			n[cont] = x;
			boolean b = esPar(x);
			if(b) {
				System.out.println("Es par!\n");
			}else {
				System.out.println("Es impar!\n");
			}
			cont++;
		}while(cont < n.length);
		System.out.println("****Fin del programa****");

	}
	public static Boolean esPar(int numero) {
		if(numero % 2 == 0) {
			return true;
		}
		return false;
	}

}
