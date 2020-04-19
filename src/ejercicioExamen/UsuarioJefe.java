package ejercicioExamen;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioJefe extends UsuarioSistema {

	Scanner sc = new Scanner(System.in);

	private ArrayList<UsuarioSistema> empleados = new ArrayList<>();

	private Integer idEmple;

	public UsuarioJefe() {

	}

	public UsuarioJefe(String nombre, String contraseña) {

		super(nombre, contraseña);

	}

	public UsuarioJefe(String nombre, String contraseña, Integer idEmple) {

		super(nombre, contraseña);

		this.id = idEmple;

	}
	
	/*Crea y añade empleado,al ArrayList de los usuarios de la Aplicación y a otro
	 * del staff del videoclub.Le pasamos los dos ArrayList*/

	public boolean addEmpleado(UsuarioSistema uS, ArrayList<UsuarioSistema> staff,
			ArrayList<UsuarioSistema> usuariosAplicacion) {

		uS = new UsuarioEstandar(introducirNombreEmpleNuevo(), introducirContraseñaEmpleNuevo(contra),
				introducirIdEmpleNuevo(staff));

		for (UsuarioSistema i : staff) {

			if (uS.getId() == i.getId()) {

				for (UsuarioSistema j : usuariosAplicacion) {

					if (uS.getId() == j.getId()) {

						return false;

					}

				}

			}

		}

		usuariosAplicacion.add(uS);

		staff.add(uS);

		return true;

	}

	/*Borra al empleado de los ArrayList a los que pertenece.
	 * Devuelve 2 si el ArrayList está vacio.
	 * Devuelve 1 si todo va correctamente.
	 * Devuelve 0 si el nombre coincide pero no el Id
	 * Devuelve -1 si el nombre no coincide*/
	
	public int removeEmpleado(String nombre, Integer numero, ArrayList<UsuarioSistema> staff,
			ArrayList<UsuarioSistema> usuariosAplicacion) {

		Integer contador = 0;

		if (staff.size() == 0) {

			return 2;

		} else {

			for (UsuarioSistema i : staff) {

				if (i.getNombre().equals(nombre)) {

					contador++;

					if (i.getId() == (numero)) {

						contador++;

						if (contador == 2) {

							staff.remove(i);

							usuariosAplicacion.remove(i);

							return 1;

						}

					}

				}

			}

			if (contador == 1) {

				return 0;

			} else {

				return -1;

			}

		}

	}

	public String introducirNombreEmpleNuevo() {

		System.out.println("Introduce el nombre del nuevo empleado");
		nombre = sc.nextLine();

		while (nombre.equals("Daniel")) {

			System.out.println("Nombre reservado para la empresa.Introduce otro nombre válido");
			System.out.println("");
			System.out.println("Introduce el nombre del nuevo empleado");
			nombre = sc.nextLine();

		}

		return nombre;

	}

	public String introducirContraseñaEmpleNuevo(String contraseña) {

		System.out.println("Introduce la contraseña del nuevo empleado");

		return sc.nextLine();

	}
	
	/*Se pide el Id y se comprueba que no coincida con el del UsuarioJefe,en este caso el 1,
	 * y también comprueba que no haya otro empleado con ese Id.Se le pasa el ArrayList de los
	 * empleados del videoclub .Retorna el Id,asegurando que no hay otro igual*/

	public Integer introducirIdEmpleNuevo(ArrayList<UsuarioSistema> staff) {

		Integer idEmple;

		boolean condicion = true;

		do {
			
			condicion = true;

			System.out.println("Introduce el número de Id del nuevo empleado");
			idEmple = sc.nextInt();
			sc.nextLine();

			if (idEmple == 1) {

				System.out.println("** Este número está reservado para el CEO de la empresa **");
				System.out.println("");

				condicion = false;

			} else {

				if (staff.size() == 0) {

					condicion = true;

				} else {

					for (UsuarioSistema i : staff) {

						if (idEmple.equals(i.getId())) {

							System.out.println("Identificador no válido,ya tenemos un empleado registrado con ese número");
							System.out.println("");
							
							condicion = false;
						}

					}
					
				}

			}

		} while (condicion == false);

		return idEmple;

	}

	public void ListarEmpleados(ArrayList<UsuarioSistema> staff) {

		if (staff.size() == 0) {

			System.out.println("No tienes empleados que listar");

		} else {

			for (UsuarioSistema i : staff) {

				System.out.println(i);
			}

		}

	}

	@Override
	public String toString() {

		return "CEO de la Empresa: " + "\n" + "==================" + "\n" + super.toString();

	}

	public Integer getIdEmple() {
		
		return idEmple;
		
	}

	public void setIdEmple(Integer idEmple) {
		
		this.idEmple = idEmple;
		
	}

	public ArrayList<UsuarioSistema> getEmpleados() {

		return empleados;

	}

	public void setEmpleados(ArrayList<UsuarioSistema> empleados) {

		this.empleados = empleados;

	}
	
}
