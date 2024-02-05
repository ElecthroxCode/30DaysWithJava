package day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
	
		List<Empleado> listEmpleado = new ArrayList<>();
		String op = "s";
		int cont = 0;
		System.out.println("\tLISTANDO EMPLEADO");
		do {
			System.out.println("EMPLEADO N° " + ++cont);
			System.out.println("Agregue el nombre completo: ");
			String nombre = sc1.nextLine();
			System.out.println("Especifique le número de horas trabajadas durante la semana: ");
			int h = sc.nextInt();
			System.out.println("Establezca la tarifa por hora: ");
			int t = sc.nextInt();
			listEmpleado.add(new Empleado(nombre, h, t));
			System.out.println("¡Se ha agregado!");
			System.out.println("¿Desea agrgar otro empleado? (s: si / n: no)");
			op = sc2.next();
		}while(op.equalsIgnoreCase("s"));
		
		for(Empleado em : listEmpleado) {
			System.out.println(em.toString());
		}
	}

}
