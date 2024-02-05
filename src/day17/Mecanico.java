package day17;

import java.time.LocalDate;

public class Mecanico extends Persona{
	private int id;
	private LocalDate fechaContratacion;
	private double salario;
	public Mecanico() {
	}
	public Mecanico(int id, LocalDate fechaContratacion, double salario) {
		this.id = id;
		this.fechaContratacion = fechaContratacion;
		this.salario = salario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}
	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
