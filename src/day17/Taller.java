package day17;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Taller {
	private String encargado;
	private Map<String, Auto> mapAutoUsados = new HashMap<>();
	private Map<LocalDate, String> fechaIngreso = new HashMap<>();
	
	public Taller() {
	}

	public Taller(String encargado) {
		this.encargado = encargado;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	
	public void agregarAuto(Auto auto) {
		String matricula = auto.getMatricula();
		if(!mapAutoUsados.containsKey(matricula)) {
			mapAutoUsados.put(matricula, auto);
			System.out.println("¡Se ha agregado con exito!");
		}else {
			System.out.println("No se puede registrar porque el vehiculo ya existe.");
		}
		
	}
}
