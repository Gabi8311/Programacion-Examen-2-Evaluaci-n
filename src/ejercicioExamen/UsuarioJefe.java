package ejercicioExamen;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioJefe extends UsuarioSistema {

	Scanner sc = new Scanner(System.in);

	protected ArrayList<UsuarioSistema> empleados = new ArrayList<>();

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

	public ArrayList<UsuarioSistema> getEmpleados() {

		return empleados;

	}

	public void setEmpleados(ArrayList<UsuarioSistema> empleados) {

		this.empleados = empleados;

	}

	public boolean addEmpleado(UsuarioSistema uS, ArrayList<UsuarioSistema> staff,
			ArrayList<UsuarioSistema> usuariosAplicacion) {// Este método mira que no haya 2
		// números de cliente iguales

		uS = new UsuarioEstandar(introducirNombreEmpleNuevo(), introducirContraseñaEmpleNuevo(contra),
				introducirIdEmpleNuevo(idEmple));
		sc.nextLine();

		for (UsuarioSistema i : staff) {// Este metodo tiene que evitar que se llamen igual el jefe y los empleados

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

		while (nombre.equals("g")) {// CAMBIAR ESTO Y EL JEFE USUARIO SISTEMA

			System.out.println("Nombre reservado para la empresa.Introduce otro nombre válido");
			System.out.println("Introduce el nombre del nuevo empleado");
			nombre = sc.nextLine();

		}

		return nombre;

	}

	public String introducirContraseñaEmpleNuevo(String contraseña) {

		System.out.println("Introduce la contraseña del nuevo empleado");

		return sc.nextLine();

	}

	public Integer introducirIdEmpleNuevo(Integer idEmple) {

		do {

			System.out.println("Introduce el número de empleado del nuevo empleado");

			idEmple = sc.nextInt();

			if (idEmple == 1) {

				System.out.println("Ese número está reservado para el CEO");

			}

		} while (idEmple == 1);

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

}
