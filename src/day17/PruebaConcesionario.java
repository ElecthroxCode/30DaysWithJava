package day17;

public class PruebaConcesionario {

	public static void main(String[] args) {
		Menu menu = new Menu();
		int o = menu.obtenerOpcion();
		menu.subMenu(o);

	}

}