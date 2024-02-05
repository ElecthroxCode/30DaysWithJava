package day17;

import java.time.LocalDate;

public class FacturaReparacion {
	private AutoUsado auto;
	private Mecanico mecanico;
	private String descripcion;
	private int tiempoHoras;
	private double precio;
	private LocalDate fecha;
	
	public FacturaReparacion() {
	}

	public FacturaReparacion(AutoUsado auto, Mecanico mecanico, String descripcion, int tiempoHoras, double precio, LocalDate fecha) {
		this.auto = auto;
		this.mecanico = mecanico;
		this.descripcion = descripcion;
		this.tiempoHoras = tiempoHoras;
		this.precio = precio;
		this.fecha = fecha;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public AutoUsado getAuto() {
		return auto;
	}

	public void setAuto(AutoUsado auto) {
		this.auto = auto;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTiempoHoras() {
		return tiempoHoras;
	}

	public void setTiempoHoras(int tiempoHoras) {
		this.tiempoHoras = tiempoHoras;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
