package day12;

public class Main {
	/*Se dice que un entero positivo es primo si puede dividirse solamente por 1 y por sí mismo. Por ejemplo, 2, 3, 5 y 7 son primos, pero 4, 6, 8 y 9 no. Por definición, el número 1 no es primo.
    a) Escriba un método que determine si un número es primo. 
    b) Use este método en una aplicación que determine y muestre en pantalla todos los                 números primos menores que 10,000. ¿Cuántos números hasta 10,000 tiene que probar         para asegurarse de encontrar todos los números primos? 
    c) Al principio podría pensarse que n/2 es el límite superior para evaluar si un número n es     primo, pero sólo es necesario ir hasta la raíz cuadrada de n. Vuelva a escribir el programa y     ejecútelo de ambas formas.*/
	
	public static void main(String[] args) {
		//int contador = 0;
		boolean b = true;
		for(int i = 2; i <= 10000; i++) {
			b = esPrimo(i);
			if(b) {
				System.out.print(i + " ");
			}
		}
		System.out.println("");
		
		System.out.println("\nPROBANDO SEGUNDA OPCIÓN:");
		
		for(int i = 2; i <= 10000; i++) {
			b = esPrimo2(i);
			if(b) {
				System.out.print(i + " ");
			}
		}
		System.out.println("");
		
	
	}
	
	public static Boolean esPrimo(int num) {
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static Boolean esPrimo2(int n) {
		int d = 0;
		for(int i = 1; i <= n/2; i++) {
			if(n % i == 0) {
				d+=2;
			}
		}
		if(d == 2) {
			return true;
		}
		return false;
	}

}
