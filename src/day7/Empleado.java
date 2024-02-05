package day7;

public class Empleado {
	private String nombreFull;
	private int horaTrabajadaXSemana;
	private double sueldoSemanal;
	private double tarifa;
	
	public Empleado(String nombreFull, int horaTrabajadaXSemana, double tarifa) {
		super();
		this.nombreFull = nombreFull;
		this.horaTrabajadaXSemana = horaTrabajadaXSemana;
		this.tarifa = tarifa;
		if(this.horaTrabajadaXSemana > 40) {
			//se agrega tarifa y media por exceder las 40 horas
			this.sueldoSemanal = (horaTrabajadaXSemana*(tarifa + (tarifa/2)));
		}else {
			this.sueldoSemanal = tarifa * horaTrabajadaXSemana;
		}
	}
	public String getNombreFull() {
		return nombreFull;
	}
	public void setNombreFull(String nombreFull) {
		this.nombreFull = nombreFull;
	}
	public int getHoraTrabajadaXSemana() {
		return horaTrabajadaXSemana;
	}
	public void setHoraTrabajadaXSemana(int horaTrabajadaXSemana) {
		this.horaTrabajadaXSemana = horaTrabajadaXSemana;
	}
	public double getSueldoSemanal() {
		return sueldoSemanal;
	}
	public void setSueldoSemanal(double sueldoSemanal) {
		this.sueldoSemanal = sueldoSemanal;
	}
	public double getTarifa() {
		return tarifa;
	}
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	@Override
	public String toString() {
		return "Empleado [" + nombreFull + ", horas trabajada por semana=" + horaTrabajadaXSemana
				+ ", sueldo bruto semanal=" + sueldoSemanal + ", tarifa por hora=" + tarifa + "]";
	}
	
	
	
	
}
