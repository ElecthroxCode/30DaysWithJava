package day6;

public class Empleado {
 private String nombre;
 private String apellidoPaterno;
 private double salario;
 
 public Empleado(String nombre, String apellidoPaterno, double salario) {
	 this.nombre = nombre;
	 this.apellidoPaterno = apellidoPaterno;
	 this.salario = salario;
	 if(this.salario < 1) {
		 this.salario = 0;
	 }
	 
	 }
 public String obtenerNombre() {
	 return this.nombre;
 }
 
 public void establecerNombre(String nuevoNombre) {
	 this.nombre = nuevoNombre;
 }
 
 public String obtenerApellido() {
	 return this.apellidoPaterno;
 }
 
 public void establecerApellido(String nuevoApellido) {
	 this.apellidoPaterno = nuevoApellido;
 }
 
 public double obtenerSalario() {
	 return this.salario;
 }
 public void establecerSalario(double nuevoSalario) {
	 this.salario = nuevoSalario;
 }
 
 public double salarioAnual() {
	 return this.salario *12;
 }
 
 
}
