package day13;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * Una pequeña aerolínea acaba de comprar una computadora para su nuevo sistema de reservaciones automatizado. Se le ha pedido a usted que desarrolle el nuevo sistema. Usted escribirá una aplicación para asignar asientos en cada vuelo del único avión de la aerolínea (capacidad: 10 asientos). 
    Su aplicación debe mostrar las siguientes alternativas: Por favor escriba 1 para Primera Clase y Por favor escriba 2 para Economico. Si el usuario escribe 1, su aplicación debe asignarle un asiento en la sección de primera clase (asientos 1 a 5). Si el usuario escribe 2, su aplicación debe asignarle un asiento en la sección económica (asientos 6 a 10). Su aplicación deberá entonces imprimir un pase de abordar, indicando el número de asiento de la persona y si se encuentra en la sección de primera clase o clase económica. 
    Use un arreglo unidimensional del tipo primitivo boolean para representar la tabla de asientos del avión. Inicialice todos los elementos del arreglo con false para indicar que todos los asientos están vacíos. A medida que se asigne cada asiento, establezca el elemento correspondiente del arreglo en true para indicar que ese asiento ya no está disponible. 
    Su aplicación nunca deberá asignar un asiento que ya haya sido asignado. Cuando esté llena la sección económica, su programa deberá preguntar a la persona si acepta ser colocada en la sección de primera clase (y viceversa). Si la persona acepta, haga la asignación de asiento apropiada. Si no, imprima el mensaje “El próximo vuelo sale en 3 horas”.
	 * */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean salir = true;
		boolean asientos [] = new boolean[10];
		int opt;
		int cont;
		boolean flag = false;
		int ocupadosEconomica = 5, ocupadosPrimeraClase = 5;
		do {
			System.out.println("\n\t\t-------------");
			System.out.println("\t1.Asiento en Primera clase");
			System.out.println("\t2.Asiento en Económico");
			System.out.println("\t3.Ver todos los asientos");
			System.out.println("\t4.Salir");
			System.out.print("Opcion: ");
			opt = sc.nextInt();
			System.out.println("\t\t-------------\n");
			
			switch(opt) {
				case 1:
					cont = 0;
					while(cont < 6) {
						for(int i = 0; i < 6; i++) {
							if(asientos[i] == false && ocupadosPrimeraClase > 0) {
								asientos[i] = true;
								imprimePaseAbordar(i, "Primera Clase");
								ocupadosPrimeraClase--;
								cont = 6;
								break;
							}
							cont++;
							if(cont == 6) {
								flag = true;
							}
						}
					}
					if(flag == true) {
						System.out.println("Los asientos de Primera clase estan llenos.");
							System.out.println("¿Desea ser colocado(a) en la Clase Económica? (s: si / n: no)");
							String s = sc.next();
							if(s.equalsIgnoreCase("s")) {
								cont = 0;
								flag = false;
								for(int i = 5; i < asientos.length ; i++) {
									if(asientos[i] == false && ocupadosEconomica > 0) {
										asientos[i] = true;
										imprimePaseAbordar(i, "Clase Económica");
										ocupadosEconomica--;
										break;
									}
									cont++;
								}
								if(cont == 5) {
									System.out.println("El próximo vuelo sale en 3 horas!");
								}
								break;
							}
							flag = false;
					}
					break;
				case 2:
					cont = 5;
					while(cont > 4  && cont < asientos.length) {
						for(int i = 5; i < asientos.length; i++) {
							if(asientos[i] == false && ocupadosEconomica > 0) {
								asientos[i] = true;
								imprimePaseAbordar(i, "Clase Económica");
								ocupadosEconomica--;
								cont = asientos.length;
								break;
							}
							cont++;
							if(cont == asientos.length) {
								flag = true;
							}
						}
					}
					if(flag == true) {
						System.out.println("Los asientos de la Clase Económica están llenos.");
							System.out.println("¿Desea ser colocado(a) en Primera Clase? (s: si / n: no)");
							String s = sc.next();
							if(s.equalsIgnoreCase("s")) {
								cont = 0;
								flag = false;
								for(int i = 0; i < 6; i++) {
									if(asientos[i] == false && ocupadosPrimeraClase > 0) {
										asientos[i] = true;
										imprimePaseAbordar(i, "Primera Clase");
										ocupadosPrimeraClase--;
										break;
									}
									cont++;
									
								}
								if(cont == 6) {
									System.out.println("El próximo vuelo sale en 3 horas!");
								}
								break;
							}
							flag = false;
					}
					break;
				case 3:
					mostrarAsientos(asientos);
					break;
				case 4:
					System.out.println("****Fin del programa****");
					salir = false;
					break;
				default:
					System.out.println("Opción incorrecta. Vuelve a intentarlo.");
					break;
			}
			
		}while(salir);
		
		System.out.println(numeroAsiento(1, 9));
	}
	
	public static int numeroAsiento(int limiteA, int limiteB) {
		SecureRandom random = new SecureRandom();
		int n  = random.nextInt(limiteB) + limiteA;
		return n;
	}
	public static void mostrarAsientos(boolean[] asientos) {
		System.out.println("");
		System.out.println("\t\tASIENTOS DE LA AEROLINEA");
		System.out.println(Arrays.toString(asientos));
		System.out.println("");
	}
	public static void imprimePaseAbordar(int n, String claseAsiento) {
		System.out.println("\t------------------------------");
		System.out.printf("\t%s %d%17s%n","| Asiento N°",n+1, "|");
		System.out.printf("\t%s%s %17s%n", "| ", claseAsiento, "|");
		System.out.printf("\t%s%30s%n", "|", "|");
		System.out.println("\t------------------------------");
	}
}
