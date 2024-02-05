package day17;

public class AutoNuevo extends Auto{
	private static int contador = 0;
	private double precio;
	
	public AutoNuevo() {
		contador++;
	}
	
	public AutoNuevo(String marca, String modelo, String color, double precio) {
		super(marca, modelo, color);
		this.setMatricula("K-00"+(++contador));
		this.precio = precio;
		contador++;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		AutoNuevo.contador = contador;
	}

	@Override
	public String toString() {
		
		return String.format("%-18s%-18s%-18s%-18s%.2f",
				this.getMatricula(),
				this.getMarca(), 
				this.getModelo(),
				this.getColor(),
				this.getPrecio());
	}
	
	
	

	
}
