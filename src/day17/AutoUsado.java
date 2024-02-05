package day17;

public class AutoUsado extends Auto{
	String km;

	public AutoUsado() {
	}

	public AutoUsado(String matricula, String marca, String modelo, String color, String km) {
		super(matricula, marca, modelo, color);
		this.km = km;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}
	
	@Override
	public String toString() {
		return String.format("MATRICULA: %s%nMARCA: %s%nMODELO: %s%nCOLOR: %s%nCOLOR: %s%nKM RECORRIDOS: %s%n",
				this.getMatricula(), this.getMarca(), this.getModelo(), this.getColor(), this.getKm());
	}
}
