package day17;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cliente extends Persona{
	private int id;
	Set<Auto> autos = new HashSet<>();
	
	public Cliente() {
	}
	
	public Cliente(String nombre, String apellido, String DNI, String direccion, String telefono, String email,
			int id) {
		super(nombre, apellido, DNI, direccion, telefono, email);
		this.id = id;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Set<Auto> getAutos() {
		return autos;
	}


	public void setAutos(Set<Auto> autos) {
		this.autos = autos;
	}


	public void agregarAuto(Auto auto) {
		autos.add(auto);
	}
	public void agregarAuto(Collection<Auto> auto) {
		autos.addAll(autos);
	}

	@Override
	public String toString() {
		return String.format("id: %s%nDNI: %s%nNOMBRE: %s%nAPELLIDOS: %s%nTÉLEFONO: %s%nDIRECCIÓN: %s%nE-MAIL: %s%n%n",
				this.getId(),
				this.getDNI(),
				this.getNombre(),
				this.getApellido(),
				this.getTelefono(),
				this.getDireccion(),
				this.getEmail());
	}
	
	
}
