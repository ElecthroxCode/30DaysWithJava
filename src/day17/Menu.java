package day17;


import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Menu {
	Scanner sc;
	boolean b;
	Cliente cliente;
	Mecanico mecanico;
	AutoUsado autoUsado;
	String matric;
	Set<AutoNuevo> listaAutosNuevos = new HashSet<>();
	Set<Persona> listaClientes = new HashSet<>();
	Set<Persona> listaMecanicos = new HashSet<>();
	List<AutoUsado> listaAutoUsados = new LinkedList<AutoUsado>();
	List<FacturaReparacion> listaFacturaReparacion = new LinkedList<FacturaReparacion>();
	public int obtenerOpcion() {
		sc = new Scanner(System.in);
		int op;
		System.out.println("+-------------------------------+");
		System.out.println("|     1.Comprar Auto            |");
		System.out.println("|     2.Reparar Auto            |");
		System.out.println("|     3.Agregar Cliente         |");
		System.out.println("|     4.Agregar Mécanico        |");
		System.out.println("|     5.Anexar Auto al Taller   |");
		System.out.println("|     6.Crear Factura           |");
		System.out.println("|     7.Ver Facturas            |");
		System.out.println("|     8.Salir                   |");
		System.out.println("+-------------------------------+");
		op = sc.nextInt();
		return op;
	}
	
	public void subMenu(int op) {
		switch(op) {
		case 1:
			sc = new Scanner(System.in);
			llenarStock();
			mostrarAutosNuevos();
			b = esCompra();
			while(b) {
				List<Auto> anexoAutos = new ArrayList<>();
				System.out.print("\nIngresa DNI del cliente: ");
				String dni = sc.nextLine();
				cliente = buscarCliente(dni);
				if(cliente != null) {
					ejecucionCompra(sc, cliente, anexoAutos);
					b = false;
				}else {
					agregarCliente(cliente, dni);
					if(sc != null) {
						ejecucionCompra(sc,cliente,anexoAutos);
						b = false;
						break;
					}
						sc = abrirScanner(sc);
						ejecucionCompra(sc,cliente,anexoAutos);
						b = false;
				}
				
			}
			break;
		case 2:
			//al iniciar, muestra una lista temporal de clientes.
			if(listaClientes.size() == 0) {
				listaClientes.addAll(llenarCliente());
				verLista(listaClientes);
			}
			break;
		case 3:
			//busca el cliente con el DNI ingresado, si no lo encuentra, creará un cliente.
			System.out.println("Escriba el DNI del cliente: ");
			String dni = sc.next();
			cliente = buscarCliente(dni);
			if(cliente != null) {
				System.out.println("El cliente con DNI " + dni + " ya se encuentra registrado.");
			}else {
				agregarCliente(cliente, dni);
				System.out.println("¡Registro exitoso!");
				System.out.println("\t\tLISTA DE CLIENTES");
				verLista(listaClientes);
			}
			break;
		case 4:
			//busca el mécanico con el DNI ingresado, si no lo encuentra, creará un mécanico.
			System.out.println("Escriba el DNI del mécanico: ");
			String dniMec = sc.next();
			mecanico = buscarMecanico(dniMec);
			if(mecanico != null) {
				System.out.println("El cliente con DNI " + dniMec + " ya se encunetra registrado.");
			}else {
				agregarMecanico(mecanico, dniMec);
				System.out.println("¡Registro exitoso!");
				System.out.println("\t\tLISTA DE MÉCANICOS");
				verLista(listaMecanicos);
			}
			break;
		case 5:
			//busca el mécanico con el DNI ingresado, si no lo encuentra, creará un mécanico.
			System.out.println("Escriba el DNI del cliente: ");
			String dniC = sc.next();
			cliente = buscarCliente(dniC);
			if(cliente != null) {
				System.out.println("\t\tREGISTRANDO DATOS DE VEHICULO");
				autoUsado = registrarAuto();
				cliente = buscarCliente(dniC);
				cliente.agregarAuto(autoUsado);
				System.out.println("¡Registro exitoso!");
				System.out.printf("Cliente: %s %s    Matricula de Vehículo: %s%n%n", 
						cliente.getNombre(), cliente.getApellido(), autoUsado.getMatricula());
			}else {
				agregarCliente(cliente, dniC);
				System.out.println("\t\tREGISTRANDO DATOS DE VEHICULO");
				autoUsado = registrarAuto();
				cliente = buscarCliente(dniC);
				cliente.agregarAuto(autoUsado);
				System.out.println("¡Registro exitoso!");
				System.out.printf("Cliente: %s %s    Matricula de Vehículo: %s%n%n", 
						cliente.getNombre(), cliente.getApellido(), autoUsado.getMatricula());
			}
			
			break;
		case 6:
			
			AutoUsado autoU = new AutoUsado();
			System.out.println("Ingrese la Matricula del Vehículo: ");
			String m = sc.nextLine();
			autoU = (AutoUsado) buscarVehiculo(m, listaAutoUsados);
			System.out.println("Ingrese DNI del Cliente: ");
			String c = sc.nextLine();
			cliente = buscarCliente(c);
			if(autoU != null) {
				if(cliente != null) {
					for(Auto a : cliente.autos) {
						if(a.getMatricula().equalsIgnoreCase(c)) {
							FacturaReparacion factura = new FacturaReparacion();
							System.out.println("Descripción: ");
							String desc = sc.nextLine();
							System.out.println("Fecha de Entrega (ej. 31-12-2024): ");
							String fechRep = sc.nextLine();
							LocalDate fechR = formatoFecha(fechRep);
							System.out.println("Escriba el tiempo de la reparación (en horas): ");
							int horas = sc.nextInt();
							System.out.println("Establezca el precio: ");
							double precioRep = sc.nextDouble();
							factura.setAuto(autoU);
							factura.setDescripcion(desc);
							factura.setFecha(fechR);
							factura.setTiempoHoras(horas);
							factura.setPrecio(precioRep);
							listaFacturaReparacion.add(factura);
						}
					}
				}else {
					System.out.println("El cliente con DNI: "+ c + " no existe!!");
				}
			}else {
				System.out.println("El auto con matricula " + m + " no existe en la lista!");
			}
			break;
		case 7:
			System.out.println("\t\tLISTA DE FACTURAS");
			verLista(listaFacturaReparacion);
			break;
		case 8:
			System.out.println("***Fin del programa***");
			break;
		default:
			System.out.println("Opción incorrecta.\nFin del programa!");
			break;
			
		}
	}
	
	public void menuPrincipal() {
		boolean activo = true;
		while(activo) {
			int opt = obtenerOpcion();
			subMenu(opt);
		}
	}
	
	public void mostrarAutosNuevos() {
		if(listaAutosNuevos.size() != 0) {
			System.out.printf("%-20s%-18s%-18s%-18s%s%n", "MATRICULA","MARCA", "MODELO", "COLOR", "PRECIO");
			listaAutosNuevos.forEach(s -> System.out.printf("- %s%n", s.toString()));
		}else {
			System.out.println("No hay autos para vender.");
		}
		
	}
	
	public void llenarStock() {
		AutoNuevo[] autosNuevos = {
				new AutoNuevo("BMW", "2024","Blanco", 43000),
				new AutoNuevo("Corvette", "Z06","Naranja", 51000),
				new AutoNuevo("Mazda", "MX-5","Negro", 34000),
				new AutoNuevo("Porsche", "718 Boxter","Gris Oscuro", 49000),
				new AutoNuevo("Lamborghini", "Huracán Técnica","Negro", 55000),
				new AutoNuevo("Maserati", "MC20","Perla", 44000),
				new AutoNuevo("McLaren", "765LT","Azul", 38000)
		};
		listaAutosNuevos.addAll(Arrays.asList(autosNuevos));
	}
	public List<Auto> comprarAuto(String... codigo) {
		Optional<AutoNuevo> auto;
		List<Auto>compras = new ArrayList<>();
		for(int i = 0; i < codigo.length; i++) {
			String matricula = codigo[i];
			auto = listaAutosNuevos.stream().filter(a -> a.getMatricula().equalsIgnoreCase(matricula)).findAny();
			if(auto.isPresent()) {
				compras.add(auto.get());
			}
		}
		return compras;
	}
	
	public boolean esCompra() {
		System.out.println("¿Desea comprar más autos? (s: si / n: no)");
		String s = sc.next();
		if(s.equalsIgnoreCase("s")) {
			return true;
		}
		System.out.println("***Programa Finalizado***");
		return false;
	}
	
	public void cerrarScanner() {
		if(sc != null) sc.close();
	}
	public Scanner abrirScanner(Scanner sc) {
		if(sc == null) {
			sc = new Scanner(System.in);
			return sc;
		}
		return sc;
	}
	
	public Cliente buscarCliente(String dni) {
		Optional<Persona> optPersona;
		optPersona = listaClientes.stream().filter(p -> p.getDNI().equalsIgnoreCase(dni)).findAny();
		if(optPersona.isPresent()) {
			return (Cliente) optPersona.get();
		}
		return null;
	}
	
	public Mecanico buscarMecanico(String dni) {
		Optional<Persona> optPersona;
		optPersona = listaMecanicos.stream().filter(p -> p.getDNI().equalsIgnoreCase(dni)).findAny();
		if(optPersona.isPresent()) {
			return (Mecanico) optPersona.get();
		}
		return null;
	}
	
	public Auto buscarVehiculo(String matricula, List<AutoUsado> listaAutoUsados) {
		Optional<AutoUsado> optAuto;
		optAuto = listaAutoUsados.stream().filter(a -> a.getMatricula().equalsIgnoreCase(matricula)).findAny();
		if(optAuto.isPresent()) {
			return  optAuto.get();
		}
		return null;
	}
	
	public String[] formatearMatricula(String cadena) {
		String[] t = cadena.strip().split("\\s");
		return t;
	}
	public void ejecucionCompra(Scanner sc, Cliente cliente, Collection<Auto> anexoAutos) {
		System.out.println("Ingrese el CÓDIGO MATRICULA del vehiculo nuevo.");
		System.out.println("En caso de ser varios vehiculos, ingresar las distintas matriculas separadas por UN 'ESPACIOS'.");
		System.out.println("Cuando desee finalizar el ingreso de matricula presione 'enter': ");
		String matricula = String.format("%s", sc.nextLine());
		String[] m = formatearMatricula(matricula);
		anexoAutos =  comprarAuto(m);
		cliente.agregarAuto(anexoAutos);
		System.out.println("¡Compra exitosa!");
		listaClientes.add(cliente);
	}
	
	public List<Persona> llenarCliente() {
		
		//int id = randomNumeros(1, 500);
		Persona[] c = {
				new Cliente("Pedro",
						"Pérez",
						"2323",
						"Calle 56-b#22",
						"03442234",
						"pedro@gmail.net",
						randomNumeros(1, 500)),
				new Cliente("Sandra",
						"Bulock",
						"12355",
						"Calle 12-#g-2442",
						"034421234",
						"sandra@gmai56l.net",
						randomNumeros(1, 500)),
				new Cliente("Ken",
						"Benson",
						"99803",
						"Calle 102-c-#98",
						"02318833",
						"benson@gmai56l.net",
						randomNumeros(1, 500)),
		};
		List<Persona> clientes = Arrays.asList(c);
		return clientes;
	}
	
	public void agregarCliente(Cliente cliente, String dni) {
		cliente = new Cliente();
		sc.nextLine();
		cliente.setDNI(dni);
		System.out.println("Nombre del Cliente: ");
		String nom = sc.nextLine();
		System.out.println("Apellido del Cliente: ");
		String ape = sc.nextLine();
		System.out.println("DNI del Cliente: " + cliente.getDNI());
		System.out.println("Télefono del Cliente: ");
		String tel = sc.nextLine();
		System.out.println("Email del Cliente: ");
		String em = sc.nextLine();
		System.out.println("Direccion del Cliente: ");
		String dir = sc.nextLine();
		System.out.println("ID del Cliente (solo números): ");
		int idd = sc.nextInt();
		cliente.setNombre(nom);
		cliente.setApellido(ape);
		cliente.setTelefono(tel);
		cliente.setEmail(em);
		cliente.setDireccion(dir);
		cliente.setId(idd);
		listaClientes.add(cliente);
		
	}

	public void agregarMecanico(Mecanico mecanico, String dni) {
		mecanico = new Mecanico();
		sc.nextLine();
		mecanico.setDNI(dni);
		System.out.println("Nombre del Mécanico: ");
		String nom = sc.nextLine();
		System.out.println("Apellido del Mécanico: ");
		String ape = sc.nextLine();
		System.out.println("DNI del Mécanico: " + mecanico.getDNI());
	
		System.out.println("Télefono del Mécanico: ");
		String tel = sc.nextLine();
		System.out.println("Email del Mécanico: ");
		String em = sc.nextLine();
		System.out.println("Direccion del Mécanico: ");
		String dir = sc.nextLine();
		System.out.println("Escriba la Fecha de Contratación (ej: 31-12-2024): ");
		String fecha = sc.nextLine();
		System.out.println("ID del Mécanico (solo números): ");
		int idd = sc.nextInt();
		System.out.println("Establezca el Salario: ");
		double salario = sc.nextDouble();
		mecanico.setNombre(nom);
		mecanico.setApellido(ape);
		mecanico.setTelefono(tel);
		mecanico.setEmail(em);
		mecanico.setDireccion(dir);
		mecanico.setFechaContratacion(formatoFecha(fecha));
		mecanico.setId(idd);
		mecanico.setSalario(salario);
		listaMecanicos.add(mecanico);
		
	}
	
	public LocalDate formatoFecha(String fecha) {
		String[] fech = fecha.split("-");
		return LocalDate.of(Integer.parseInt(fech[0]), Integer.parseInt(fech[1]), Integer.parseInt(fech[2]));
		
	}
	public int randomNumeros(int inicio, int fin) {
		SecureRandom numerosAleatorios = new SecureRandom();
		return numerosAleatorios.nextInt(fin)+inicio;
	}
	
	public <T> void verLista(Collection<T> lista) {
		lista.forEach(System.out::println);
	}
	
	public AutoUsado registrarAuto() {
		autoUsado = new AutoUsado();
		System.out.println("Ingrese la Matricula del Vehiculo: ");
		String matricula = sc.nextLine();
		System.out.println("Marca del Vehículo: ");
		String marca = sc.nextLine();
		System.out.println("Modelo del Vehículo: ");
		String modelo = sc.nextLine();
		System.out.println("Color del Vehículo: ");
		String color = sc.nextLine();
		System.out.println("Kilometros recorridos: ");
		String km = sc.nextLine();
		autoUsado.setMatricula(matricula);
		autoUsado.setMarca(marca);
		autoUsado.setModelo(modelo);
		autoUsado.setColor(color);
		autoUsado.setKm(km);
		listaAutoUsados.add(autoUsado);
		return autoUsado;
	}
	
}
