package ejercicioExamen;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		UsuarioSistema uJ;

		UsuarioSistema uS;

		VideoClub v1 = new VideoClub();

		Integer contador = 3;

		System.out.println("=============================================");
		System.out.println("BIENVENIDOS AL VIDEOCLUB DE LA FAMILIA MORENO");
		System.out.println("=============================================");
		System.out.println("              Iniciar sesión");

		uJ = new UsuarioJefe("Daniel", "Programación", 1);// Nombre,contraseña y Id inicial del UsuarioJefe

		uS = new UsuarioSistema();

		v1.getUsuariosAplicacion().add(uJ);

		do {

			System.out.println("");
			System.out.println("      Introduce tu nombre de usuario");
			System.out.println("");

			String nombre = sc.nextLine();

			if (uS.loginEmpleado(nombre, v1.getUsuariosAplicacion()) == false) {

				System.out.println("** ACCESO DENEGADO **");

				contador--;

			} else {

				if (v1.iniciarSesion(uS, v1.getUsuariosAplicacion()) == false) {

					v1.usuarioJefe();

				} else {

					v1.usuarioEstandar();

				}
			}

		} while (contador > 0);

		if (contador == 0) {

			System.out.println("********************");
			System.out.println("* CUENTA BLOQUEADA *");
			System.out.println("********************");

		}

		sc.close();

	}

}
