package ejercicioExamen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UsuarioSistema extends Usuario {

	protected Cliente cliente;

	protected String nomCliente;

	protected String apeCliente;

	protected Alquilables nuevoAlquilable;

	protected ArrayList<Usuario> personal = new ArrayList<Usuario>();

	protected ArrayList<Alquilables> ordenar = new ArrayList<Alquilables>();

	protected ArrayList<Peliculas> peliculas = new ArrayList<Peliculas>();

	protected ArrayList<Series> series = new ArrayList<Series>();

	protected ArrayList<Peliculas> peliculasAlq = new ArrayList<>();

	protected ArrayList<Series> seriesAlq = new ArrayList<>();

	Scanner sc = new Scanner(System.in);

	public UsuarioSistema() {

	}

	public UsuarioSistema(String nombre) {

		super(nombre);

	}

	public UsuarioSistema(String nombre, String contra) {

		super(nombre, contra);

	}

	public UsuarioSistema(String nombre, String contra, Integer id) {

		super(nombre, contra, id);

	}

	public ArrayList<Usuario> getPersonal() {

		return personal;

	}

	public void setPersonal(ArrayList<Usuario> personal) {

		this.personal = personal;

	}

	public boolean loginEmpleado(String nombre, ArrayList<UsuarioSistema> usuarioAplicacion) {

		String contra;

		for (UsuarioSistema i : usuarioAplicacion) {

			if (i.getNombre().equalsIgnoreCase(nombre)) {

				System.out.println("");
				System.out.println("Contraseña:");
				System.out.println("");

				contra = sc.nextLine();

				System.out.println("");

				if (i.getContra().equals(contra)) {

					this.nombre = nombre;

					this.contra = contra;

					return true;

				}

			}

		}

		return false;

	}

	public boolean LoginCliente(Integer numCliente, ArrayList<Cliente> socios) {

		for (Cliente i : socios) {

			if (i.getAccountNumber() == (numCliente)) {

				System.out.println("Estás atendiendo a: " + i);

				return true;

			}

		}

		return false;
	}

	/*
	 * Crea el nuevo cliente y le asigna nombre,apellido y número de cliente.
	 * Comprueba que no haya 2 socios con el mismo número
	 */

	public boolean addCliente(ArrayList<Cliente> socios) {

		cliente = new Cliente(introducirNombre(), introducirApellido(), introducirNumClienteNuevo());
		sc.nextLine();

		for (Cliente i : socios) {

			if (cliente.getAccountNumber() == i.getAccountNumber()) {

				return false;

			}

		}

		socios.add(cliente);

		return true;

	}

	/*
	 * Borra al cliente.Devuelve 2 si no hay socios a los que borrar. Devuelve 1 si
	 * todo funciona correcto y se borra el cliente. Devuelve 0,si el nombre
	 * coincide pero el número de socio no. Devuelve -1,si el nombre no coincide con
	 * el introducido.
	 */

	public int removeCliente(String nombre, Integer numSocio, ArrayList<Cliente> socios) {

		Integer contador = 0;

		if (socios.size() == 0) {

			return 2;

		} else {

			for (Cliente i : socios) {

				if (i.getName().equalsIgnoreCase(nombre)) {

					contador++;

					if (i.getAccountNumber() == (numSocio)) {

						contador++;

						if (contador == 2) {

							socios.remove(i);

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

	public void ListarClientes(ArrayList<Cliente> socios) {

		if (socios.size() == 0) {

			System.out.println("No hay socios que listar");

		} else {
			
			System.out.println("LISTA DE SOCIOS");
			System.out.println("...............");

			for (Cliente i : socios) {

				System.out.println(i);

			}
			
		}
		
	}

	public void ordenar(ArrayList<Alquilables> lista) {

		lista.sort(Comparator.comparing(Alquilables::getNombre));

	}

	public ArrayList<Alquilables> buscarAlquilablePorNombre(String nombre, ArrayList<Alquilables> ListProductos) {

		ArrayList<Alquilables> lista = new ArrayList<Alquilables>();

		for (Alquilables i : ListProductos) {

			if (i.getNombre().equalsIgnoreCase(nombre)) {

				lista.add(i);

				return lista;

			}

		}

		ordenar(lista);

		return lista;

	}

	public ArrayList<Alquilables> buscarAlquilablePorDirector(String director, ArrayList<Alquilables> ListProductos) {

		ArrayList<Alquilables> lista = new ArrayList<Alquilables>();

		for (Alquilables i : ListProductos) {

			if (i.getDirector().equalsIgnoreCase(director)) {

				lista.add(i);

			}

		}

		ordenar(lista);

		return lista;

	}

	public ArrayList<Alquilables> buscarAlquilableLanzamiento(Integer lanzamiento,
			ArrayList<Alquilables> ListProductos) {

		ArrayList<Alquilables> lista = new ArrayList<Alquilables>();

		for (Alquilables i : ListProductos) {

			if (i.getLazamiento().equals(lanzamiento)) {

				lista.add(i);

			}

		}

		ordenar(lista);

		return lista;

	}

	public ArrayList<Alquilables> buscarAlquilablevaloracion(Double valoracion, ArrayList<Alquilables> ListProductos) {

		ArrayList<Alquilables> lista = new ArrayList<Alquilables>();

		for (Alquilables i : ListProductos) {

			if (i.getValoracion() == valoracion) {

				lista.add(i);

			}

		}

		ordenar(lista);

		return lista;

	}

	public ArrayList<Alquilables> buscarAlquilableNumCopias(Integer numCopias, ArrayList<Alquilables> ListProductos) {

		ArrayList<Alquilables> lista = new ArrayList<Alquilables>();

		for (Alquilables i : ListProductos) {

			if (i.getNumCopias() == numCopias) {

				lista.add(i);

			}

		}

		ordenar(lista);

		return lista;

	}

	public Integer alquilarPelicula(String peli, ArrayList<Peliculas> pelis, ArrayList<Peliculas> alquiladas) {

		for (Peliculas i : pelis) {

			if (i.getNombre().equalsIgnoreCase(peli)) {

				if (i.getNumCopias() == 0) {

					return 2;// No quedan más copias

				} else {

					alquiladas.add(i);

					i.setNumCopias(i.getNumCopias() - 1);

				}

				return 1;// pelicula alquilada

			}

		}

		return -1;// no se ha encontrado película en este videoclub

	}

	public boolean devolverPelicula(String peli, ArrayList<Peliculas> pelis, ArrayList<Peliculas> alquiladas) {

		for (Peliculas i : alquiladas) {

			if (i.getNombre().equalsIgnoreCase(peli)) {

				alquiladas.remove(i);

				for (Peliculas j : pelis) {

					if (j.getNombre().equalsIgnoreCase(peli)) {

						j.setNumCopias(j.getNumCopias() + 1);

						return true;

					}

				}

			}

		}

		return false;

	}

	public boolean buscarSerie(String serie) {

		for (Series i : series) {

			if (i.getNombre().equalsIgnoreCase(serie)) {

				return true;

			}

		}

		return false;

	}

	public int alquilarSerie(String serie, ArrayList<Series> series, ArrayList<Series> SeriesAlq) {

		for (Series i : series) {

			if (i.getNombre().equalsIgnoreCase(serie)) {

				if (i.getNumCopias() == 0) {

					return 2;// No quedan más copias

				} else {

					seriesAlq.add(i);

					i.setNumCopias(i.getNumCopias() - 1);

				}

				return 1;// serie alquilada

			}

		}

		return -1;// no se ha encontrado serie en este videoclub

	}

	public boolean devolverSerie(String serie, ArrayList<Series> series, ArrayList<Series> SeriesAlq) {

		for (Series i : seriesAlq) {

			if (i.getNombre().equalsIgnoreCase(serie)) {

				seriesAlq.remove(i);

				for (Series j : series) {

					if (j.getNombre().equalsIgnoreCase(serie)) {

						j.setNumCopias(j.getNumCopias() + 1);

					}

				}

				return true;

			}

		}

		return false;

	}

	/*
	 * ESTE MÉTODO ESTÁ INUTILZADO.LO HICE PARA EL ALQUILER DE TEMPORADA,PERO POR
	 * FALTA DE TIEMPO, NO PUDE.EN UN FUTURO PRÓXIMO LO TERMINARÉ,DÁNDOLE SU
	 * UTILIDAD
	 */

	public int alquilarTemporada(String serie, ArrayList<Series> series, ArrayList<Series> SeriesAlq,
			ArrayList<Temporadas> temporadas, Integer numTemporada) {

		int numTemp;

		for (Series i : series) {

			if (i.getNombre().equalsIgnoreCase(serie)) {

				if (i.getNumCopias() == 0) {

					return 2;// No quedan más copias

				} else {

					System.out.println("Qué temporada quieres alquilar?");

					System.out.println("De la serie:" + i + " hay " + temporadas.size() + " temporadas");

					do {

						System.out.println("Cual quieres alquilar?");
						numTemp = sc.nextInt();
						sc.nextLine();

						if (numTemp > 1 || numTemp < temporadas.size()) {

							System.out.println("Número de temporada INCORRECTO");
							System.out.println("Elige entre las temporadas que tiene la serie");
							System.out.println("De la serie:" + i + " hay " + temporadas.size() + " temporadas");

						}

					} while (numTemp > 1 || numTemp < temporadas.size());

					i.setNumCopias(i.getNumCopias() - 1);

				}

				return 1;// temporada alquilada

			}

		}

		return -1;// no se ha encontrado serie en este videoclub

	}

	public String introducirNombre() {

		System.out.println("Introduce el nombre");

		return sc.nextLine();

	}

	public String introducirApellido() {

		System.out.println("Introduce el apellido");

		return sc.nextLine();

	}

	public Integer introducirNumClienteNuevo() {

		System.out.println("Registra el nuevo número de socio del nuevo Cliente");

		return sc.nextInt();

	}

	public String introducirContraseña() {

		System.out.println("Introduce tu contraseña");

		return sc.nextLine();

	}

	public Integer introducirIdEmple() {

		System.out.println("Introduce el número de id empleado");

		return sc.nextInt();

	}

	public Integer introducirNumCliente() {

		System.out.println("Introduce el número de Socio");

		return sc.nextInt();

	}

}