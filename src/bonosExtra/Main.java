package bonosExtra;


import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	private static Formatter salida;
	
	public static void main(String[] args) {
		char[] arrayChar = {'h','o','l','a'};
		
		//Crea un archivo ."txt":
		abrirArchivo("textoPrueba1.txt");
		escribirArchivo();
		cerrarArchivo();
		
	
	}
	
	public static void abrirArchivo(String nombreArchivo) {
		try {
			salida = new Formatter(nombreArchivo);
		} catch (FileNotFoundException e) {
			System.err.print("Error al abrir el archivo. Terminado");
			System.exit(1);
		}
	}
	
	public static void escribirArchivo() {
		Scanner sc = new Scanner(System.in);
		try{
			System.out.println("Escribe un texto corto: Ejemplo --> Nombre y apellido");
			salida.format("%s %s%n", sc.next(), sc.next());
		}catch(FormatterClosedException formatterClosedExcption){
			System.err.println("Error al escribir en archivo.");
			
		}catch(NoSuchElementException elementsException) {
			System.err.println("Entrada invalida. Intetalo de nuevo");
			sc.nextLine();
		}
	}
	
	public static void cerrarArchivo() {
		if(salida != null) salida.close();
	}

}
