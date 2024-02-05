package day8;

import java.util.Scanner;

public class Main {
	/*	El proceso de encontrar el valor más grande se utiliza con frecuencia en aplicaciones de 		computadora. Por ejemplo, un programa para determinar el ganador de un concurso de ventas 		recibe como entrada el número de unidades vendidas por cada vendedor. El vendedor que 		haya vendido más unidades es el que gana el concurso. Escriba un programa en seudocódigo 		y después una aplicación en Java que reciba como entrada una serie de 10 números enteros, 		y que determine e imprima el mayor de los números. Su programa debe utilizar cuando menos 		las siguientes tres variables:
    	a) contador: un contador para contar hasta 10 (para llevar el registro de cuántos números         		se han introducido, y para determinar cuando se hayan procesado los 10 números). 
    	b) numero: el entero más reciente introducido por el usuario. 
    	c) mayor: el número más grande encontrado hasta ahora.
    */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] enteros = new int[10];
		int contador;
		int numero;
		int mayor = 0;
		System.out.println("/tINGRESE 10 NÚMEROS:\n");
		for(contador  = 0; contador < enteros.length; contador++) {
			System.out.println("Escriba un número (n°"+ (contador+1) +": ");
			int n = sc.nextInt();
			enteros[contador] = n;
		}
		numero = enteros[enteros.length-1];
		System.out.println("Arreglo: ");
		for(int en : enteros) {
			System.out.printf("%d ",en);
			int n = en;
			if(n > mayor) {
				mayor = n;
			}
		}
		
		System.out.println("\nEl número mayor de los 10 números ingresados es: " + mayor);
		System.out.println("El número más rieciente introducido es --> " + numero);

	}

}
