package day17;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String DNI;
	private String direccion;
	private String telefono;
	private String email;
	
	public Persona() {
	}

	public Persona(String nombre, String apellido, String DNI, String direccion, String telefono, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
