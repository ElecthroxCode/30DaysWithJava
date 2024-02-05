package day6;

import day6.Empleado;

public class PruebaEmpleado {
	/* Cree una clase llamada Empleado, que incluya tres variables 
	 * de instancia: un primer nombre (tipo String), un apellido paterno 
	 * (tipo String) y un salario mensual (double). Su clase debe tener 
	 * un constructor que inicialice las tres variables de instancia. 
	 * Proporcione un método establecer y un método obtener para cada 
	 * variable de instancia. Si el salario mensual no es positivo, 
	 * no establezca su valor. Escriba una aplicación de prueba 
	 * llamada PruebaEmpleado, que demuestre las capacidades de la clase 
	 * Empleado. Cree dos objetos Empleado y muestre el salario anual de 
	 * cada objeto. Después, proporcione a cada Empleado un aumento del 10% 
	 * y muestre el salario anual de cada Empleado otra vez.
	 */
	public static void main(String[] args) {
		Empleado empleado1 = new Empleado("José", "Peréz", 1200);
		Empleado empleado2 = new Empleado("María", "Castañeda", 1300);
		Empleado empleado3 = new Empleado("Juan", "Humberto", -120);
		Empleado empleado4 = new Empleado("Francisco", "Marín", 1320);
		
		System.out.println(empleado1.obtenerNombre()+ " " + empleado1.obtenerApellido() +
				" - Sueldo menseual: " + empleado1.obtenerSalario() + " - Sueldo Anual: " + 
				empleado1.salarioAnual());
		System.out.println(empleado2.obtenerNombre()+ " " + empleado2.obtenerApellido() +
				" - Sueldo menseual: " + empleado2.obtenerSalario() + " - Sueldo Anual: " + 
				empleado2.salarioAnual());
		System.out.println(empleado3.obtenerNombre()+ " " + empleado3.obtenerApellido() +
				" - Sueldo menseual: " + empleado3.obtenerSalario() + " - Sueldo Anual: " + 
				empleado3.salarioAnual());
		System.out.println(empleado4.obtenerNombre()+ " " + empleado4.obtenerApellido() +
				" - Sueldo menseual: " + empleado4.obtenerSalario() + " - Sueldo Anual: " + 
				empleado4.salarioAnual());
		System.out.println("\nAumentado el 10% del sueldo a José y a María: \n");
		empleado1.establecerSalario(empleado1.obtenerSalario()*0.1 + empleado1.obtenerSalario());
		empleado2.establecerSalario(empleado2.obtenerSalario()*0.1 + empleado1.obtenerSalario());
		System.out.println(empleado1.obtenerNombre()+ " " + empleado1.obtenerApellido() +
				" - Sueldo menseual: " + empleado1.obtenerSalario() + " - Sueldo Anual: " + 
				empleado1.salarioAnual());
		System.out.println(empleado2.obtenerNombre()+ " " + empleado2.obtenerApellido() +
				" - Sueldo menseual: " + empleado2.obtenerSalario() + " - Sueldo Anual: " + 
				empleado2.salarioAnual());

	}

}
