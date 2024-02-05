package day10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	/*
	 * Un vendedor minorista en línea vende cinco productos cuyos precios de venta
	 * son los siguientes: producto 1, $2.98; producto 2, $4.50; producto 3, $9.98;
	 * producto 4, $4.49 y producto 5, $6.87. Escriba una aplicación que lea una
	 * serie de pares de números, como se muestra a continuación: a) número del
	 * producto; b) cantidad vendida. Su programa debe utilizar una instrucción
	 * switch para determinar el precio de venta de cada producto. Debe calcular y
	 * mostrar el valor total de venta de todos los productos vendidos. Use un ciclo
	 * controlado por centinela para determinar cuándo debe el programa dejar de
	 * iterar para mostrar los resultados finales.
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int contador = 0;
		Map<Integer, Integer> productos = new HashMap<>();
		HashMap<Integer, Double> listPrecios = new HashMap<>();

		boolean t = true;

		do {
			String opt = "s";
			System.out.println("\n\t\t****");
			System.out.println("1.Agregar un producto.");
			System.out.println("2.Determinar el precio de un producto.");
			System.out.println("3.Valor total de los productos.");
			System.out.println("4.Salir.\n");
			System.out.print("Opción: ");
			int x = sc.nextInt();
			System.out.println("");
			switch (x) {
			case 1:
				while (opt.equalsIgnoreCase("s")) {
					System.out.println("Escriba el número del producto:");
					int n = sc.nextInt();
					System.out.println("Escriba la cantidad vendida:");
					int c = sc.nextInt();
					productos.put(n, c);
					System.out.println("¡Se ha agregado el producto!");
					System.out.println("¿Desea agregar otro producto? (s: si / n: no)");
					opt = sc1.next();
				}
				break;
			case 2:
				Scanner scDouble = new Scanner(System.in);
				while (opt.equalsIgnoreCase("s")) {

					System.out.println("Escriba el número del referencia del producto:");
					int referencia = sc.nextInt();
					if (productos.containsKey(referencia)) {
						System.out.println("Estblezca el precio del producto con referencia " + referencia + ": ");
						double precio = scDouble.nextDouble();
						listPrecios.put(referencia, precio);
						System.out.println("¿Desea agregar el precio a otro articulo? (s: si / n: no)");
						opt = sc1.next();
					} else {
						System.out.println("El número de referencia no existe!");
					}
				}
				break;
			case 3:
				System.out.println("\t_=tLista de Productos=_");
				double precioXCantidad = 0;
				double total = 0;
				if (!productos.isEmpty()) {
					System.out.println("N° Referencia\tCantidad\tPrecio\tPrecioXcantidad");
					for (Map.Entry<Integer, Integer> pr : productos.entrySet()) {
						System.out.printf("%d -%6d%10d", ++contador, pr.getKey(), pr.getValue());
						for (Map.Entry<Integer, Double> e : listPrecios.entrySet()) {
							if (e.getKey().equals(pr.getKey())) {
								precioXCantidad = pr.getValue() * e.getValue();
								total += precioXCantidad;
								System.out.printf("%16.2f%12.2f%n", e.getValue(), precioXCantidad);
							}
						}

					}
					System.out.printf("%n\t\t\t\t    Total: %.2f", total);
				} else {
					System.out.println("Debes agregar poducto y sus precios");
				}

				break;
			case 4:
				System.out.println("****Programa finalizado****");
				t = false;
				break;
			default:
				System.out.println("Opción invalida!");
				break;
			}
		} while (t);

	}

}
