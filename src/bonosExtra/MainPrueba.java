package bonosExtra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Collections;

public class MainPrueba {

	public static void main(String[] args) {
		// Convierte la siguiente lista en un array:
		
		int [] enteros = {5, 9, 4, 2, 1,3, 15, 2};
		
		System.out.println("Arreglo original: " + Arrays.toString(enteros));
		
		System.out.println("Convertido en List:");
		
		List<Integer> listInt = new ArrayList<>();
		for(int e : enteros) {
			listInt.add(e);
		}
		System.out.println(listInt.toString());
		System.out.println("Ordenado la lista:");
		Collections.sort(listInt);
		System.out.println(listInt.toString());
		System.out.println("El mayor es " + Collections.max(listInt));
		System.out.println("El menor es  " + Collections.min(listInt));
		System.out.println("El número 2 se repite " + Collections.frequency(listInt, 2));
		System.out.println("USANDO LAMBDAS: ");
		System.out.println("\tAplicando un forEach:");
			IntStream.of(enteros).forEach( x -> {System.out.print(x + " ");});
			System.out.println("\nEl valor minimo: " +
			IntStream.of(enteros).min().getAsInt());
			System.out.println("El valor máximo: " +
			IntStream.of(enteros).max().getAsInt());
			System.out.println("El promedio: "+
			IntStream.of(enteros).average().getAsDouble());
			System.out.println("Suma de los valores: " + 
			IntStream.of(enteros).sum());
			System.out.println("Suma de cuadrados de cada elemento con reduce: " +
			IntStream.of(enteros).reduce(0, (x, y) -> x + y*y));
			System.out.println("Multiplicación de los elementos con reduce: "+ 
			IntStream.of(enteros).reduce(1, (x, y)-> x*y));
			System.out.println("Valores impares multplicado por 10 y mostrado en orden:");
			IntStream.of(enteros)
					.filter(x -> x % 2 != 0)
					.map(y -> y * 10)
					.sorted()
					.forEach( x -> System.out.printf("%d ",x));
			System.out.println();
			System.out.println("Suma de de los números de 1 al 3: " + 
			IntStream.range(1, 4).sum());
			System.out.println("Suma de de los números de 1 al 4: " + 
					IntStream.rangeClosed(1, 4).sum());
			Integer[] numeros = {2,4,5,6};
			
			System.out.println("Ordenado el nuevo array: " + 
			Arrays.stream(numeros).sorted().collect(Collectors.toList()));
			System.out.println("Suma: "+  
			Arrays.stream(numeros).reduce(0, (x, y) -> x+y));
			System.out.printf("Mayores que 3: ");
			Arrays.stream(numeros).filter(x -> x >3).forEach(x -> System.out.printf("%d ", x));
			System.out.println();
			System.out.println();
	}

}
