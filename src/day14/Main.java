package day14;


import java.util.Scanner;

public class Main {
	/* Internet y Web permiten que cada vez haya más personas conectadas en red, 
	 * unidas por una causa, expresen sus opiniones, etcétera. Los candidatos presidenciales 
	 * recientes usaron Internet en forma intensiva para expresar sus mensajes y 
	 * recaudar dinero para sus campañas. En este ejercicio, escribirá un pequeño 
	 * programa de encuestas que permite a los usuarios calificar cinco asuntos de 
	 * conciencia social, desde 1 (menos importante) hasta 10 (más importante). 
	 * Elija cinco causas que sean importantes para usted (por ejemplo, 
	 * temas políticos, sobre el medio ambiente). Use un arreglo unidimensional 
	 * llamado temas (de tipo String) para almacenar las cinco causas. 
	 * Para sintetizar las respuestas de la encuesta, use un arreglo bidimensional de 5 filas 
	 * y 10 columnas llamado respuestas (de tipo int), en donde cada fila corresponda a un 
	 * elemento del arreglo temas. Cuando se ejecute el programa, debe pedir al usuario que 
	 * califique cada tema. Haga que sus amigos y familiares respondan a la encuesta. 
	 * Después haga que el programa muestre un resumen de los resultados, incluyendo:
  
    a) Un informe tabular con los cinco temas del lado izquierdo y las 10 calificaciones en la
       parte superior, listando en cada columna el número de calificaciones recibidas para   
       cada tema. 
    b) A la derecha de cada fila, muestre el promedio de las calificaciones para cada tema específico. 
    c) ¿Qué tema recibió la mayor puntuación total? Muestre ambos, el asunto y la puntuación. 
    d)¿Cuál obtuvo la menor puntuación total? Muestre tanto el tema como la puntuación total.
	 * */

	public static void main(String[] args) {
		int[][] respuestas = new int [5][10]; 
		String[] temas = {"Economía", "Educación", "Electric", "Software", "Turismo",};
		System.out.println("Califique de 1 a 10 su interés en los siguientes temas:");
		imprimirTemas(temas);
		System.out.println();
		ingresoCalificacion(respuestas, temas);
		System.out.println("TABLA DE TODAS LAS CALIFICACIONES");
		imprimeRespuestas(respuestas);
		System.out.println();
		System.out.println("\t\t\t::::TABLA::::");
		tabla(respuestas, temas);
	}
	
	public static void imprimirTemas(String[] temas) {
		int cont = 0;
		for(String t : temas) {
			System.out.println(++cont + "-" + t);
		}
	}
	 public static void ingresoCalificacion(int[][] resp, String[] temas) {
		 Scanner sc = new Scanner(System.in);
		 int n;
		 for(int i = 0; i < resp.length; i++) {
			 for(int j = 0; j < resp[i].length; j++) {
				 System.out.printf("Calificación %d para el tema %s:%n", j+1, temas[i]);
				 n = sc.nextInt();
				 resp[i][j] = n;
			 }
		 }
		 sc.close();
	 }
	 public static void imprimeRespuestas(int[][] respuestas) {
		 for(int[] r : respuestas) {
			 for(int re : r) {
				 System.out.printf("%d ", re);
			 }
			 System.out.println();
		 }
	 }
	public static void tabla(int[][] resp, String[] tem) {
		int cont = 0;
		int tamanio = 0;
		double suma = 0.0;
		double prom = 0.0;
		System.out.printf("\tTemas\t\tCalificaciones\t\t\tN°Calificaciones\tPromedio%n");
		for(int i = 0; i < resp.length; i++) {
			System.out.printf("%s%40s", tem[i], obtenerCalificacionesXtema(resp, i+1, cont));
			cont++;
			for(int j = 0; j < resp[i].length; j++) {
				suma += resp[i][j];
				tamanio = resp[i].length;
			}
			prom = suma / tamanio;
			System.out.printf("%15d%23.2f%n", tamanio, prom);
			suma = 0;
			prom = 0;
			tamanio = 0;
		}
	}
	public static String obtenerCalificacionesXtema(int[][]resp, int factor, int factorB) {
		String s = "";
		for(int i = factorB; i < factor; i++) {
			
			for(int j = 0; j < resp[i].length; j++) {
				s += resp[i][j] + " ";
			}
		}
		return s;
		
	}
	
}
