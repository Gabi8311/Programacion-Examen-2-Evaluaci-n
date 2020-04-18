package ejercicioExamen;

import java.util.ArrayList;

import java.util.Scanner;

public class Peliculas extends Alquilables {

	private String tipo;

	public Peliculas() {

	}

	public Peliculas(String tipo) {

		this.tipo = tipo;

	}

	public Peliculas(String nombre, String director, Integer lanzamiento) {

		super(nombre, director, lanzamiento);

	}

	public Peliculas(String nombre, String director, Integer lanzamiento, Double valoracion) {

		super(nombre, director, lanzamiento, valoracion);

	}

	public Peliculas(String nombre, String director, Integer lanzamiento, Double valoracion, Integer numCopias,
			String tipo) {

		super(nombre, director, lanzamiento, valoracion, numCopias);

		this.tipo = tipo;

	}
	
	/*Añade la pelicula al videoclub,y según de que tipo sea,los va añadiendo
	 * ha varios ArrayList,de los generales y a los más concretos a su tipo.
	 * */
	public boolean addPeliculaAlVideoClub(Peliculas nuevo, ArrayList<Alquilables> alquilables,
			ArrayList<Peliculas> peliculas, ArrayList<Peliculas> animacion, ArrayList<Peliculas> cienciaFiccion,
			ArrayList<Peliculas> tradicional, ArrayList<Peliculas> porOrdenador, ArrayList<Peliculas> stopMotion,
			ArrayList<Peliculas> otras) {

		Integer opc;

		Integer opc2;

		Integer contador = 0;

		String otroTipo;

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la informacion de la película que vas a agregar al videoclub");

		System.out.println("Título:");

		String titulo = sc.nextLine();

		for (Alquilables i : alquilables) {

			if (i.getNombre().equalsIgnoreCase(titulo)) {

				contador++;

				System.out.println("Esta película ya la tenemos en el videoclub");

			}

		}

		if (contador == 0) {

			System.out.println("Introduce el nombre del director:");
			String nomDirector = sc.nextLine();

			System.out.println("Introduce año de lanzamiento:");
			Integer lanzamiento = sc.nextInt();
			sc.nextLine();

			if (lanzamiento > 2020) {

				System.out.println("Año de lanzamiento erróneo");
				System.out.println("Introduce el año de lanzamiento real:");
				valoracion = sc.nextDouble();
				sc.nextLine();

			}

			System.out.println("Introduce valoración inicial:");
			Double valoracion = sc.nextDouble();
			sc.nextLine();

			if (valoracion > 5.1 || valoracion < 0.0) {

				System.out.println("La valoración debe ir de 0 a 5");
				System.out.println("Introduce valoración inicial,entre esas cifras:");
				valoracion = sc.nextDouble();
				sc.nextLine();

			}

			System.out.println("Introduce el número de copias");
			Integer numCopias = sc.nextInt();
			sc.nextLine();

			do {

				System.out.println("Qué tipo de película es?");
				System.out.println("1.Ciencia Ficción        2.Animación        3.Otra");

				opc = sc.nextInt();
				sc.nextLine();

				if (opc != 1 && opc != 2 && opc != 3) {

					System.out.println("** OPCIÓN INCORRECTA **");

				}

			} while (opc != 1 && opc != 2 && opc != 3);

			ArrayList<Double> media = new ArrayList<>();

			nuevo.nombre = titulo;
			nuevo.director = nomDirector;
			nuevo.lazamiento = lanzamiento;
			nuevo.valoracion = valoracion;
			nuevo.numCopias = numCopias;
			nuevo.mediaValoraciones = media;

			if (opc == 1) {

				nuevo.setTipo("Ciencia Ficción");				
				alquilables.add(nuevo);			
				peliculas.add(nuevo);
				cienciaFiccion.add(nuevo);

			} else if (opc == 3) {

				System.out.println("Indica el tipo de la película");
				otroTipo = sc.nextLine();
				
				nuevo.setTipo(otroTipo);
				alquilables.add(nuevo);
				peliculas.add(nuevo);
				otras.add(nuevo);

			} else {

				do {

					System.out.println("Qué tipo de pelicula de animación es?");
					System.out.println("1.Tradicional        2.Por ordenador        3.Stop Motion");

					opc2 = sc.nextInt();
					sc.nextLine();

					if (opc2 != 1 && opc2 != 2 && opc2 != 3) {

						System.out.println("** OPCIÓN INCORRECTA **");

					}

				} while (opc2 != 1 && opc2 != 2 && opc2 != 3);

				if (opc2 == 1) {
					
					nuevo.setTipo("Animación:Tradicional");
					alquilables.add(nuevo);
					peliculas.add(nuevo);
					animacion.add(nuevo);
					tradicional.add(nuevo);

				} else if (opc2 == 2) {
					
					nuevo.setTipo("Animación:Por Ordenador");
					alquilables.add(nuevo);
					peliculas.add(nuevo);
					animacion.add(nuevo);
					porOrdenador.add(nuevo);

				} else {
					
					nuevo.setTipo("Animación:Stop Motion");
					alquilables.add(nuevo);
					peliculas.add(nuevo);
					animacion.add(nuevo);
					stopMotion.add(nuevo);

				}

			}

			return true;

		}

		return false;

	}

	public boolean eliminarPelicula(String nombre, ArrayList<Alquilables> alquilables, ArrayList<Peliculas> peliculas,
			ArrayList<Peliculas> animacion, ArrayList<Peliculas> cienciaFiccion, ArrayList<Peliculas> tradicional,
			ArrayList<Peliculas> porOrdenador, ArrayList<Peliculas> stopMotion, ArrayList<Peliculas> otras) {

		Integer opc;

		Integer opc2;

		Scanner sc = new Scanner(System.in);

		for (Alquilables i : peliculas) {

			if (i.getNombre().equalsIgnoreCase(nombre)) {

				do {

					System.out.println("Qué tipo de película es?");
					System.out.println("1.Ciencia Ficción        2.Animación        3.Otra");

					opc = sc.nextInt();
					sc.nextLine();

					if (opc != 1 && opc != 2 && opc != 3) {

						System.out.println("** OPCIÓN INCORRECTA **");

					}

				} while (opc != 1 && opc != 2 && opc != 3);

				if (opc == 1) {

					for (Peliculas j : cienciaFiccion) {

						if (j.getNombre().equalsIgnoreCase(nombre) && j.getTipo().equalsIgnoreCase("Ciencia Ficción")) {

							cienciaFiccion.remove(i);

							peliculas.remove(i);

							alquilables.remove(i);

							return true;

						}

					}

					System.out.println("** Tipo de película incorrecto **");

					return false;

				} else if (opc == 3) {

					for (Peliculas j : otras) {

						if (j.getNombre().equalsIgnoreCase(nombre) && j.getTipo().equalsIgnoreCase("Otra")) {

							otras.remove(i);

							peliculas.remove(i);

							alquilables.remove(i);

							return true;

						}

					}

					System.out.println("** Tipo de película incorrecto **");

					return false;

				} else {

					do {

						System.out.println("Qué tipo de pelicula de animación es?");
						System.out.println("1.Tradicional        2.Por ordenador        3.Stop Motion");

						opc2 = sc.nextInt();
						sc.nextLine();

						if (opc2 != 1 && opc2 != 2 && opc2 != 3) {

							System.out.println("** OPCIÓN INCORRECTA **");

						}

					} while (opc2 != 1 && opc2 != 2 && opc2 != 3);

					if (opc2 == 1) {

						for (Peliculas j : tradicional) {

							if (j.getNombre().equalsIgnoreCase(nombre)
									&& j.getTipo().equalsIgnoreCase("Animación:Tradicional")) {

								animacion.remove(i);

								tradicional.remove(i);

								peliculas.remove(i);

								alquilables.remove(i);

								return true;

							}

						}

						System.out.println("** Tipo de película incorrecto **");

						return false;

					} else if (opc2 == 2) {

						for (Peliculas j : porOrdenador) {

							if (j.getNombre().equalsIgnoreCase(nombre)
									&& j.getTipo().equalsIgnoreCase("Animación:Por ordenador")) {

								animacion.remove(i);

								porOrdenador.remove(i);

								peliculas.remove(i);

								alquilables.remove(i);

								return true;

							}

						}

						System.out.println("** Tipo de película incorrecto **");

						return false;

					} else {

						for (Peliculas j : stopMotion) {

							if (j.getNombre().equalsIgnoreCase(nombre)
									&& j.getTipo().equalsIgnoreCase("Animación:Stop Motion")) {

								animacion.remove(i);

								stopMotion.remove(i);

								peliculas.remove(i);

								alquilables.remove(i);

								return true;

							}

						}

						System.out.println("** Tipo de película incorrecto **");

						return false;

					}

				}

			}

		}

		return false;

	}

	public String getTipo() {

		return tipo;

	}

	public void setTipo(String tipo) {

		this.tipo = tipo;

	}

	@Override
	public String toString() {

		return super.toString() + "; Tipo: " + this.tipo;

	}

}
