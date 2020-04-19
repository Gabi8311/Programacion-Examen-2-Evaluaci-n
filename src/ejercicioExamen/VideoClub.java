package ejercicioExamen;
                    
import java.util.ArrayList;

import java.util.Scanner;

public class VideoClub { 

	UsuarioJefe jefe;

	UsuarioEstandar usuarioEstandar;

	Cliente client;

	String peli;

	String serie;

	Double valoracionCliente;

	String nombre;

	String apellido;

	Integer numSocio;

	String respuesta;

	Integer aux;

	private ArrayList<Alquilables> listaElementos = new ArrayList<Alquilables>();

	private ArrayList<UsuarioSistema> staff = new ArrayList<UsuarioSistema>();

	private ArrayList<UsuarioSistema> usuariosAplicacion = new ArrayList<UsuarioSistema>();

	private ArrayList<Alquilables> totalElementos = new ArrayList<Alquilables>();

	private ArrayList<UsuarioEstandar> dependientes = new ArrayList<UsuarioEstandar>();

	private ArrayList<Cliente> socios = new ArrayList<Cliente>();

	private ArrayList<Peliculas> peliculas = new ArrayList<Peliculas>();

	private ArrayList<Peliculas> cienciaFiccion = new ArrayList<Peliculas>();

	private ArrayList<Peliculas> animacion = new ArrayList<Peliculas>();

	private ArrayList<Peliculas> tradicional = new ArrayList<Peliculas>();

	private ArrayList<Peliculas> porOrdenador = new ArrayList<Peliculas>();

	private ArrayList<Peliculas> stopMotion = new ArrayList<Peliculas>();

	private ArrayList<Peliculas> peliculasAlq = new ArrayList<>();

	private ArrayList<Peliculas> otras = new ArrayList<>();

	private ArrayList<Series> series = new ArrayList<>();

	private ArrayList<Series> seriesAlq = new ArrayList<>();

	private Integer opc;

	private Peliculas nueva;

	private Series estreno;

	Peliculas p1 = new Peliculas("Star Wars:Episodio 1-La amenaza fantasma", "George Lucas", 1999, 5.0, 10,"Ciencia Ficción");
	Peliculas p2 = new Peliculas("Star Wars:Episodio 2-El ataque de los clones", "George Lucas", 2002, 5.0, 10,"Ciencia Ficción");
	Peliculas p3 = new Peliculas("Star Wars:Episodio 3-La venganza de los Sith", "George Lucas", 2005, 5.0, 10,"Ciencia Ficción");
	Peliculas p4 = new Peliculas("Star Wars:Episodio 4-Una nueva esperanza", "George Lucas", 1977, 5.0, 10,"Ciencia Ficción");
	Peliculas p5 = new Peliculas("Star Wars:Episodio 5-El Imperio contraataca", "George Lucas", 1980, 5.0, 10,"Ciencia Ficción");
	Peliculas p6 = new Peliculas("Star Wars:Episodio 6-El retorno del Jedi", "George Lucas", 1983, 5.0, 10,"Ciencia Ficción");
	Peliculas p7 = new Peliculas("Star Wars:Episodio 7-El despertar de la fuerza", "George Lucas", 2015, 5.0, 10,"Ciencia Ficción");
	Peliculas p8 = new Peliculas("Star Wars:Episodio 8-Los últimos Jedi", "George Lucas", 2017, 5.0, 10,"Ciencia Ficción");
	Peliculas p9 = new Peliculas("Star Wars:Episodio 9-El ascenso de Skywalker", "George Lucas", 2019, 5.0, 10,"Ciencia Ficción");
	Peliculas p10 = new Peliculas("Rogue One:Una historia de Star Wars", "George Lucas", 2016, 5.0, 10,"Ciencia Ficción");
	Peliculas p11 = new Peliculas("Han Solo:Una historia de Star Wars", "George Lucas", 1999, 5.0, 10,"Ciencia Ficción");
	Peliculas p12 = new Peliculas("La guerra de los clones", "George Lucas", 2008, 5.0, 10, "Ciencia Ficción");

	Peliculas p13 = new Peliculas("El Rey León", "Rob Minkoff", 1994, 5.0, 10, "Animación:Tradicional");
	Peliculas p14 = new Peliculas("Aladdin", "Ron Clements", 1992, 5.0, 10, "Animación:Tradicional");
	Peliculas p15 = new Peliculas("Dragon Ball Z: El más fuerte del mundo", "Daisuke Nishio", 1990, 5.0, 10,"Animación:Tradicional");
	Peliculas p16 = new Peliculas("Gru,mi villano favorito", "Pierre Coffin", 2010, 5.0, 10, "Animación:Por ordenador");
	Peliculas p17 = new Peliculas("Gru,mi villano favorito 2", "Pierre Coffin", 2013, 5.0, 10,"Animación:Por ordenador");
	Peliculas p18 = new Peliculas("Gru,mi villano favorito 3", "Pierre Coffin", 2017, 5.0, 10,"Animación:Por ordenador");
	Peliculas p19 = new Peliculas("Minions", "Pierre Coffin", 2015, 5.0, 10, "Animación:Por ordenador");
	Peliculas p20 = new Peliculas("Lego,The movie", "Phil Lord", 2014, 5.0, 10, "Animación:Stop Motion");
	Peliculas p21 = new Peliculas("La oveja Shaun,La película", "Richard Goleszowski", 2015, 5.0, 10,"Animación:Stop Motion");
	Peliculas p22 = new Peliculas("Cavernícola", "Nick Park", 2018, 5.0, 10, "Animación:Stop Motion");

	Series s1 = new Series("La casa de papel", "Alex Pina", 2017, 5.0, 10, 4);
	Series s2 = new Series("Gomorra", "Roberto Saviano", 2014, 5.0, 10, 4);
	Series s3 = new Series("Juego de tronos", "George R.R.Martin", 2011, 5.0, 10, 8);
	Series s4 = new Series("Los Soprano", "David Chase", 1999, 5.0, 10, 6);
	Series s5 = new Series("Hijos de la Anarquía", "Kurt Sutter", 2008, 5.0, 10, 7);
	Series s6 = new Series("Breaking Bad", "Vince Gilligan", 2008, 5.0, 10, 5);
	
	Scanner sc = new Scanner(System.in);

	public boolean iniciarSesion(UsuarioSistema usuario, ArrayList<UsuarioSistema> usuariosAplicacion) {

		for (UsuarioSistema i : usuariosAplicacion) {

			if (i.getNombre().equals(usuario.getNombre()) && i.getContra().equals(usuario.getContra())) {

				System.out.println(i);

				if (i instanceof UsuarioEstandar) {

					return true;

				}

			}

		}
		return false;

	}

	public void usuarioJefe() {

		UsuarioSistema uS = null;

		jefe = new UsuarioJefe();

		client = new Cliente();

		addPeliculasSeries();

		Integer idCliente = null;

		do {

			menuJefe();

			switch (opc) {

			case 1:

				AddJefeAEmpleado(uS);

				break;

			case 2:

				despedirJefeAEmpleado();

				break;

			case 3:

				jefe.ListarEmpleados(staff);

				break;

			case 4:

				do {

					menuCuandoLlegaUnCliente();

					switch (opc) {

					case 11:

						jefeAddCliente();

						break;

					case 22:

						jefeBorraCliente();

						break;

					case 33:

						jefe.ListarClientes(socios);

						break;

					case 44:

						idCliente = jefe.introducirNumCliente();

						if (jefe.LoginCliente(idCliente, socios) == false) {

							System.out.println("Este número de socio no corresponde a ningún cliente");

						} else {

							do {

								menuAtendiendoCliente();

								switch (opc) {

								case 111:

									imprimirTotalPeliculas();

									preguntarImprimirPorTipos();

									if (respuesta.equalsIgnoreCase("S")) {

										imprimirPeliculasCienciaFiccion();

										imprimirPeliculasAnimacionPorSeparado();

										imprimirPeliculasTipoOtras();

									} else {

										break;

									}

									break;

								case 222:

									imprimirTotalSeries();

									break;

								case 333:

									do {

										menuTipoPeliculaAlquilar();

										if (opc == 1) {

											imprimirPeliculasCienciaFiccion();

										} else if (opc == 3) {

											if (otras.size() == 0) {

												System.out.println("No hay películas de otro tipo");

											} else {

												imprimirPeliculasTipoOtras();

											}

										} else if (opc == 2) {

											imprimirPeliculasAnimacionPorSeparado();

										} else {

											opcionIncorrecta();

										}

									} while (controlDeErrores123());

									System.out.println("Qué pelicula quieres alquilar?");
									peli = sc.nextLine();

									if (jefe.alquilarPelicula(peli, peliculas, peliculasAlq) == 1) {

										System.out.println("Pelicula Alquilada");

									} else if (jefe.alquilarPelicula(peli, peliculas, peliculasAlq) == -1) {

										System.out.println("No disponemos de esa pelicula en este videoclub");

									} else {

										System.out.println("Película no disponible,todas las copias están alquiladas");

									}

									break;

								case 444:

									System.out.println("Qué serie quieres alquilar?");
									serie = sc.nextLine();

									if (jefe.alquilarSerie(serie, series, seriesAlq) == 1) {

										System.out.println("Serie Alquilada");

									} else if (jefe.alquilarSerie(serie, series, seriesAlq) == -1) {

										System.out.println("No disponemos de esa serie en el videoclub");

									} else {

										System.out.println("Serie no disponible,todas las copias están alquiladas");

									}

									break;

								case 555:

									System.out.println("Qué pelicula se devuelve?");
									peli = sc.nextLine();

									if (jefe.devolverPelicula(peli, peliculas, peliculasAlq) == true) {

										System.out.println("Pelicula devuelta");

										pedirValoracionDePelicula();

										hacerMediaValoracionesPelicula();

									} else {

										System.out.println("Esta pelicula no es de este establecimiento");

									}

									break;

								case 666:

									System.out.println("Qué serie se devuelve?");
									serie = sc.nextLine();

									if (jefe.devolverSerie(serie, series, seriesAlq) == true) {

										System.out.println("Serie devuelta");

										pedirValoracionSerie();

										hacerMediaValoracionesSerie();

									} else {

										System.out.println("Esta serie no es de nuestro establecimiento");

									}

									break;

								case 777:

									do {

										menuEncontrarElementoPorAtributo();

										switch (opc) {

										case 1111:

											introducirNombre();

											listaElementos = (jefe.buscarAlquilablePorNombre(nombre, totalElementos));

											System.out.println(listaElementos.toString());

											break;

										case 2222:

											introducirDirector();

											listaElementos = jefe.buscarAlquilablePorDirector(nombre, totalElementos);

											System.out.println(listaElementos.toString());

											break;

										case 3333:

											introducirAñoLanzamiento();

											listaElementos = jefe.buscarAlquilableLanzamiento(aux, totalElementos);

											System.out.println(listaElementos.toString());

											break;

										case 4444:

											introducirNumeroCopias();

											listaElementos = jefe.buscarAlquilableNumCopias(aux, totalElementos);

											System.out.println(listaElementos.toString());

											break;

										case 5555:

											imprimirVolverAlMenuAnterior();

											break;

										default:

											opcionIncorrecta();
											
											break;

										}
										

									} while (opc != 5555);

									
									
									break;

								case 888:

									imprimirVolverAlMenuAnterior();

									break;

								default:

									opcionIncorrecta();

									break;

								}

							} while (opc != 888);

						}

						break;

					case 55:

						imprimirVolverAlMenuAnterior();

						break;

					default:

						opcionIncorrecta();

						break;

					}

				} while (opc != 55);

				break;

			case 5:

				imprimirTotalElementos();

				preguntarImprimirPorTipos();

				if (respuesta.equalsIgnoreCase("S")) {

					imprimirPeliculasCienciaFiccion();

					imprimirPeliculasAnimacionPorSeparado();

					imprimirPeliculasTipoOtras();

					imprimirTotalSeries();

				} else {

					break;

				}

				break;

			case 6:

				do {

					preguntarQueElementoAdd();

					if (opc == 1) {

						nueva = new Peliculas();

						nueva.addPeliculaAlVideoClub(nueva, totalElementos, peliculas, animacion, cienciaFiccion,tradicional, porOrdenador, stopMotion, otras);

					} else if (opc == 2) {

						estreno = new Series();

						if (estreno.addSeriesAlVideoClub(totalElementos, series) == false) {

							System.out.println("Esa serie ya la tenemos en el videoclub");

						} else {

							System.out.println("Serie añadida");

						}

					} else {

						opcionIncorrecta();

					}

				} while (opc != 1 && opc != 2);

				break;

			case 7:

				do {
					
					menuEliminarElemento();

					if (opc == 1) {

						System.out.println("Qué nombre tiene la película que vamos a eliminar?");
						nombre = sc.nextLine();

						nueva = new Peliculas();
						
						if (nueva.eliminarPelicula(nombre, totalElementos, peliculas, animacion, cienciaFiccion,tradicional, porOrdenador, stopMotion, otras) == true) {

							System.out.println("");
							System.out.println("Película eliminada de la Base de Datos");

						} else {
							
							System.out.println("");
							System.out.println("Los datos introducidos no son correctos");

						}

					} else if (opc == 2) {
						
						System.out.println("Qué nombre tiene la serie que vamos a eliminar?");
						nombre = sc.nextLine();

						estreno = new Series();

						if (estreno.eliminarSerie(nombre, totalElementos, series) == true) {

							System.out.println("");
							System.out.println("Serie eliminada de la Base de Datos");

						} else {

							System.out.println("");
							System.out.println("El nombre introducido no corresponde con ninguna serie del videoclub");

						}

					} else {

						opcionIncorrecta();

					}

				} while (opc != 1 && opc != 2);

				break;

			case 8:
				
				System.out.println("");
				System.out.println("Gracias por utilizar la Aplicación!!Hasta pronto!!");

				break;

			default:

				opcionIncorrecta();

				break;

			}

		} while (opc != 8);

	}

	public void preguntarQueElementoAdd() {

		System.out.println("Qué elemento quieres añadir?");
		System.out.println("1.Película        2.Serie");

		pedirOpcion();
		
	}

	public void imprimirTotalElementos() {

		System.out.println("TOTAL ELEMENTOS");
		System.out.println("===============");

		for (Alquilables i : totalElementos) {

			System.out.println(i);

		}

	}

	public void imprimirVolverAlMenuAnterior() {

		System.out.println("Vuelves al menú anterior");

	}

	public void introducirNumeroCopias() {

		System.out.println("Introduce el número de copias:");
		aux = sc.nextInt();
		sc.nextLine();

	}

	public void introducirAñoLanzamiento() {

		System.out.println("Introduce el año de lanzamiento:");
		aux = sc.nextInt();
		sc.nextLine();

	}

	public void introducirDirector() {

		System.out.println("Introduce el nombre del director:");
		nombre = sc.nextLine();

	}

	public void introducirNombre() {

		System.out.println("Introduce el nombre:");
		nombre = sc.nextLine();

	}

	public void menuEncontrarElementoPorAtributo() {
		
		
		System.out.println("Qué atributo usamos para encortrarlo?");
		System.out.println("1.Nombre");
		System.out.println("2.Director");
		System.out.println("3.Año de Lanzamiento");
		System.out.println("4.Número de copias");
		System.out.println("5.Salir");

		pedirOpcion();

	}

	public void hacerMediaValoracionesSerie() {

		for (Series i : series) {

			if (i.getNombre().equalsIgnoreCase(serie)) {

				i.valoracion = i.mediaValoracion(i.mediaValoraciones, valoracionCliente);

			}

		}

	}

	public void pedirValoracionSerie() {

		System.out.println("Dame una valoración de la serie del 0 al 5");
		valoracionCliente = sc.nextDouble();
		sc.nextLine();

		while (valoracionCliente < 0 || valoracionCliente > 5) {

			System.out.println("La valoración tiene que ser del 0 al 5");
			valoracionCliente = sc.nextDouble();
			sc.nextLine();

		}

	}

	public void hacerMediaValoracionesPelicula() {

		for (Peliculas i : peliculas) {

			if (i.getNombre().equalsIgnoreCase(peli)) {

				i.valoracion = i.mediaValoracion(i.mediaValoraciones, valoracionCliente);

			}

		}

	}

	public void pedirValoracionDePelicula() {

		System.out.println("Dame una valoración de la pelicula del 0 al 5");
		valoracionCliente = sc.nextDouble();
		sc.nextLine();

		while (valoracionCliente < 0 || valoracionCliente > 5) {

			System.out.println("La valoración tiene que ser del 0 al 5");
			valoracionCliente = sc.nextDouble();
			sc.nextLine();

		}

	}

	public void menuTipoPeliculaAlquilar() {

		System.out.println("");
		System.out.println("Que tipo de película quieres alquilar?");
		System.out.println("1.Ciencia Ficción");
		System.out.println("2.Animación");
		System.out.println("3.Otras");

		pedirOpcion();

	}

	public void imprimirTotalSeries() {
		
		System.out.println("TOTAL SERIES");
		System.out.println("------------");

		for (Series i : series) {

			System.out.println(i);
			
		}

		System.out.println("");

	}

	public boolean controlDeErrores123() {

		return opc != 1 && opc != 2 && opc != 3;

	}

	public void opcionIncorrecta() {

		System.out.println("** OPCIÓN INCORRECTA **");

	}

	public void imprimirPeliculasTipoOtras() {

		System.out.println("");
		System.out.println("OTRAS");
		System.out.println("-----");

		for (Peliculas i : otras) {

			System.out.println(i);

		}
		
		System.out.println("");

	}

	public void imprimirPeliculasAnimacionPorSeparado() {

		System.out.println("");
		System.out.println("PELÍCILAS DE ANIMACIÓN");
		System.out.println("----------------------");
		System.out.println("");
		System.out.println("ANIMACIÓN TRADICIONAL");
		System.out.println("......................");

		for (Peliculas i : this.tradicional) {

			System.out.println(i);

		}

		System.out.println("");
		System.out.println("ANIMACIÓN POR ORDENADOR");
		System.out.println("........................");

		for (Peliculas i : this.porOrdenador) {

			System.out.println(i);
			
		}

		System.out.println("");
		System.out.println("ANIMACIÓN STOP MOTION");
		System.out.println("........................");

		for (Peliculas i : this.stopMotion) {

			System.out.println(i);

		}

	}

	public void imprimirPeliculasCienciaFiccion() {

		System.out.println("");
		System.out.println("PELÍCILAS DE CIENCIA FICCIÓN");
		System.out.println("----------------------------");

		for (Peliculas i : this.cienciaFiccion) {

			System.out.println(i);

		}

		System.out.println("");

	}

	public void preguntarImprimirPorTipos() {

		do {

			System.out.println("Las quiere ver separadas por tipos? S/N");
			respuesta = sc.nextLine();

		} while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));

	}

	public void imprimirTotalPeliculas() {

		System.out.println("TOTAL PELICULAS");
		System.out.println("===============");

		for (Peliculas i : this.peliculas) {

			System.out.println(i);

		}

		System.out.println("");

	}

	public void menuAtendiendoCliente() {

		System.out.println("");
		System.out.println("1.Ver las peliculas");
		System.out.println("2.Ver las series");
		System.out.println("3.Alquilar pelicula");
		System.out.println("4.Alquilar serie");
		System.out.println("5.Devolver pelicula");
		System.out.println("6.Devolver serie");
		System.out.println("7.Buscar un elemento del videoclub");
		System.out.println("8.Salir");

		pedirOpcion();

	}

	public void jefeBorraCliente() {

		String nombreCliente;
		System.out.println("Introduce el nombre del Cliente a para darle de baja en el videoclub");
		nombreCliente = sc.nextLine();

		System.out.println("Introduce el número de socio del cliente");
		numSocio = sc.nextInt();
		sc.nextLine();

		if (jefe.removeCliente(nombreCliente, numSocio, socios) == 1) {

			System.out.println("Cliente borrado");

		} else if (jefe.removeCliente(nombreCliente, numSocio, socios) == 0) {

			System.out.println("El número de socio no se corresponde con el nombre del cliente ");

		} else if (jefe.removeCliente(nombreCliente, numSocio, socios) == -1) {

			System.out.println("El nombre no corresponde a ningún cliente");

		} else {

			System.out.println("No tiene socios");

		}

	}

	public void jefeAddCliente() {

		if (jefe.addCliente(socios) == true) {

			System.out.println("Nuevo cliente añadido a nuestra Base de Datos");

		} else {

			System.out.println("Esta número de socio ya está asignado a otro cliente nuestro");

		}

	}

	public void menuCuandoLlegaUnCliente() {

		System.out.println("");
		System.out.println("1.Registrar un nuevo socio");
		System.out.println("2.Dar de baja un socio");
		System.out.println("3.Lista de socios");
		System.out.println("4.Introducir número de socio");
		System.out.println("5.Salir");

		pedirOpcion();

	}

	public void despedirJefeAEmpleado() {

		System.out.println("Introduce el nombre del empleado a despedir");
		nombre = sc.nextLine();

		System.out.println("Introduce su número de identificador");
		numSocio = sc.nextInt();
		sc.nextLine();

		if (jefe.removeEmpleado(nombre, numSocio, staff, usuariosAplicacion) == 1) {

			System.out.println("Empleado despedido");

		} else if (jefe.removeEmpleado(nombre, numSocio, staff, usuariosAplicacion) == 0) {

			System.out.println("El número de identificador no se corresponde con el nombre del empleado ");

		} else if (jefe.removeEmpleado(nombre, numSocio, staff, usuariosAplicacion) == -1) {

			System.out.println("El nombre no corresponde a ningún empleado");

		} else {

			System.out.println("No tiene empleados");

		}

	}

	public void AddJefeAEmpleado(UsuarioSistema uS) {

		if (jefe.addEmpleado(uS, staff, usuariosAplicacion) == true) {

			System.out.println("El nuevo empleado se ha sumado a nuestro Staff");

		} else {

			System.out.println("Este número de empleado ya forma parte de nuestro equipo");

		}

	}

	public void menuJefe() {

		System.out.println("");
		System.out.println("1.Dar de alta un nuevo trabajador");
		System.out.println("2.Dar de baja a un trabajador");
		System.out.println("3.Listar empleados");
		System.out.println("4.Atender a un cliente");
		System.out.println("5.Ver los elementos del videoclub al completo");
		System.out.println("6.Introducir elemento al videoclub");
		System.out.println("7.Borrar elemento del videoclub");
		System.out.println("8.Salir");
		System.out.println("");
		System.out.println("Elige una opción:");

		pedirOpcion();

	}

	public void usuarioEstandar() {

		usuarioEstandar = new UsuarioEstandar();

		client = new Cliente();

		addPeliculasSeries();

		Integer idCliente = null;

		do {

			menuEmpleado();

			switch (opc) {

			case 1:

				do {

					menuCuandoLlegaUnCliente();

					switch (opc) {

					case 11:

						empleadoAddCliente();

						break;

					case 22:

						empleadoBorraCliente();

						break;

					case 33:

						usuarioEstandar.ListarClientes(socios);

						break;

					case 44:

						idCliente = usuarioEstandar.introducirNumCliente();

						if (usuarioEstandar.LoginCliente(idCliente, socios) == false) {

							System.out.println("Este número de socio no corresponde a ningún cliente");

						} else {

							do {

								menuAtendiendoCliente();

								switch (opc) {

								case 111:

									imprimirTotalPeliculas();

									preguntarImprimirPorTipos();

									if (respuesta.equalsIgnoreCase("S")) {

										imprimirPeliculasCienciaFiccion();

										imprimirPeliculasAnimacionPorSeparado();

										imprimirPeliculasTipoOtras();

									} else {

										break;

									}

									break;

								case 222:

									imprimirTotalSeries();

									break;

								case 333:

									do {

										menuTipoPeliculaAlquilar();

										if (opc == 1) {

											imprimirPeliculasCienciaFiccion();

										} else if (opc == 3) {

											if (otras.size() == 0) {

												System.out.println("No hay películas de otro tipo");

											} else {

												imprimirPeliculasTipoOtras();

											}

										} else if (opc == 2) {

											imprimirPeliculasAnimacionPorSeparado();

											System.out.println("");

										} else {

											opcionIncorrecta();

										}

									} while (controlDeErrores123());

									System.out.println("Qué pelicula quieres alquilar?");
									peli = sc.nextLine();

									if (usuarioEstandar.alquilarPelicula(peli, peliculas, peliculasAlq) == 1) {

										System.out.println("Pelicula Alquilada");

									} else if (usuarioEstandar.alquilarPelicula(peli, peliculas, peliculasAlq) == -1) {

										System.out.println("No disponemos de esa pelicula en este videoclub");

									} else {

										System.out.println("Película no disponible,todas las copias están alquiladas");

									}

									break;

								case 444:

									System.out.println("Qué serie quieres alquilar?");
									serie = sc.nextLine();

									if (usuarioEstandar.alquilarSerie(serie, series, seriesAlq) == 1) {

										System.out.println("Serie Alquilada");

									} else if (usuarioEstandar.alquilarSerie(serie, series, seriesAlq) == -1) {

										System.out.println("No disponemos de esa serie en el videoclub");

									} else {

										System.out.println("Serie no disponible,todas las copias están alquiladas");

									}

									break;

								case 555:

									System.out.println("Qué pelicula se devuelve?");
									peli = sc.nextLine();

									if (usuarioEstandar.devolverPelicula(peli, peliculas, peliculasAlq) == true) {

										System.out.println("Pelicula devuelta");
										
										pedirValoracionDePelicula();

										hacerMediaValoracionesPelicula();

									} else {

										System.out.println("Esta pelicula no es de este establecimiento");

									}

									break;

								case 666:

									System.out.println("Qué serie se devuelve?");
									serie = sc.nextLine();

									if (usuarioEstandar.devolverSerie(serie, series, seriesAlq) == true) {

										System.out.println("Serie devuelta");
										
										pedirValoracionSerie();

										hacerMediaValoracionesSerie();

									} else {

										System.out.println("Esta serie no es de nuestro establecimiento");

									}

									break;

								case 777:

									//do {

										menuEncontrarElementoPorAtributo();

										switch (opc) {

										case 1111:

											introducirNombre();

											listaElementos = (usuarioEstandar.buscarAlquilablePorNombre(nombre,totalElementos));

											System.out.println(listaElementos.toString());

											break;

										case 2222:

											introducirDirector();

											listaElementos = usuarioEstandar.buscarAlquilablePorDirector(nombre,totalElementos);

											System.out.println(listaElementos.toString());

											break;

										case 3333:

											introducirAñoLanzamiento();

											listaElementos = usuarioEstandar.buscarAlquilableLanzamiento(aux,totalElementos);

											System.out.println(listaElementos.toString());

											break;

										case 4444:

											introducirNumeroCopias();

											listaElementos = usuarioEstandar.buscarAlquilableLanzamiento(aux,totalElementos);

											System.out.println(listaElementos.toString());

											break;

										case 5555:

											imprimirVolverAlMenuAnterior();

											break;

										default:

											opcionIncorrecta();

										break;
										
										}

									//} while (opc != 5555);

									//break;

								case 888:

									imprimirVolverAlMenuAnterior();

									break;

								default:

									opcionIncorrecta();

									break;

								}

							} while (opc != 888);

						}

						break;

					case 55:

						imprimirVolverAlMenuAnterior();

						break;

					default:

						opcionIncorrecta();

						break;

					}

				} while (opc != 55);

				break;

			case 2:

				imprimirTotalElementos();

				preguntarImprimirPorTipos();

				if (respuesta.equalsIgnoreCase("S")) {

					imprimirPeliculasCienciaFiccion();

					imprimirPeliculasAnimacionPorSeparado();

					imprimirPeliculasTipoOtras();

					imprimirTotalSeries();

				} else {

					break;

				}

				break;
				
			case 3:
				
				do {

					preguntarQueElementoAdd();

					if (opc == 1) {

						nueva = new Peliculas();

						nueva.addPeliculaAlVideoClub(nueva, totalElementos, peliculas, animacion, cienciaFiccion,tradicional, porOrdenador, stopMotion, otras);

					} else if (opc == 2) {
						
						estreno = new Series();
						
						estreno.addSeriesAlVideoClub(totalElementos, series);

					} else {

						opcionIncorrecta();

					}

				} while (opc != 1 && opc != 2);

				break;


				

			case 4:

				do {
					
					menuEliminarElemento();

					if (opc == 1) {

						System.out.println("Qué nombre tiene la película que vamos a eliminar?");
						nombre = sc.nextLine();

						nueva = new Peliculas();

						if (nueva.eliminarPelicula(nombre, totalElementos, peliculas, animacion, cienciaFiccion,tradicional, porOrdenador, stopMotion, otras) == true) {

							System.out.println("Película eliminada de la Base de Datos");

						} else {
							
							System.out.println("");
							System.out.println("Los datos introducidos no son correctos");

						}

					} else if (opc == 2) {

						estreno = new Series();

						if (estreno.eliminarSerie(nombre, totalElementos, series) == true) {

							System.out.println("Serie eliminada de la Base de Datos");

						} else {

							System.out.println("El nombre introducido no corresponde con ninguna serie del videoclub");

						}

					} else {

						opcionIncorrecta();

					}

				} while (opc != 1 && opc != 2);

				break;

			case 5:
				
				System.out.println("");
				System.out.println("Gracias por utilizar la Aplicación!!Hasta pronto!!");

				break;

			default:

				opcionIncorrecta();

				break;

			}

		} while (opc != 5);

	}

	public void menuEliminarElemento() {
		
		System.out.println("Qué elemento quieres eliminar?");
		System.out.println("1.Película        2.Serie");

		pedirOpcion();
		
	}

	public void empleadoBorraCliente() {

		String nombreCliente;

		System.out.println("Introduce el nombre del Cliente a para darle de baja en el videoclub");
		nombreCliente = sc.nextLine();

		System.out.println("Introduce el número de socio del cliente");
		numSocio = sc.nextInt();
		sc.nextLine();

		if (usuarioEstandar.removeCliente(nombreCliente, numSocio, socios) == 1) {

			System.out.println("Cliente borrado");

		} else if (usuarioEstandar.removeCliente(nombreCliente, numSocio, socios) == 0) {

			System.out.println("El número de socio no se corresponde con el nombre del cliente ");

		} else if (usuarioEstandar.removeCliente(nombreCliente, numSocio, socios) == -1) {

			System.out.println("El nombre no corresponde a ningún cliente");

		} else {

			System.out.println("No tiene socios");

		}

	}

	public void empleadoAddCliente() {

		if (usuarioEstandar.addCliente(socios) == true) {

			System.out.println("Nuevo cliente añadido a nuestra Base de Datos");

		} else {

			System.out.println("Esta persona ya es cliente nuestro");

		}

	}

	public void menuEmpleado() {

		System.out.println("");
		System.out.println("1.Atender a un cliente");
		System.out.println("2.Ver los elementos del videoclub al completo");
		System.out.println("3.Introducir elemento al videoclub");
		System.out.println("4.Eliminar elemento al videoclub");
		System.out.println("5.Salir");
		System.out.println("");
		System.out.println("Elige una opción:");

		pedirOpcion();

	}

	public void addPeliculasSeries() {

		totalElementos.add(p1);
		totalElementos.add(p2);
		totalElementos.add(p3);
		totalElementos.add(p4);
		totalElementos.add(p5);
		totalElementos.add(p6);
		totalElementos.add(p7);
		totalElementos.add(p8);
		totalElementos.add(p9);
		totalElementos.add(p10);
		totalElementos.add(p11);
		totalElementos.add(p12);
		totalElementos.add(p13);
		totalElementos.add(p14);
		totalElementos.add(p15);
		totalElementos.add(p16);
		totalElementos.add(p17);
		totalElementos.add(p18);
		totalElementos.add(p19);
		totalElementos.add(p20);
		totalElementos.add(p21);
		totalElementos.add(p22);
		totalElementos.add(s1);
		totalElementos.add(s2);
		totalElementos.add(s3);
		totalElementos.add(s4);
		totalElementos.add(s5);
		totalElementos.add(s6);

		peliculas.add(p1);
		peliculas.add(p2);
		peliculas.add(p3);
		peliculas.add(p4);
		peliculas.add(p5);
		peliculas.add(p6);
		peliculas.add(p7);
		peliculas.add(p8);
		peliculas.add(p9);
		peliculas.add(p10);
		peliculas.add(p11);
		peliculas.add(p12);
		peliculas.add(p13);
		peliculas.add(p14);
		peliculas.add(p15);
		peliculas.add(p16);
		peliculas.add(p17);
		peliculas.add(p18);
		peliculas.add(p19);
		peliculas.add(p20);
		peliculas.add(p21);
		peliculas.add(p22);

		cienciaFiccion.add(p1);
		cienciaFiccion.add(p2);
		cienciaFiccion.add(p3);
		cienciaFiccion.add(p4);
		cienciaFiccion.add(p5);
		cienciaFiccion.add(p6);
		cienciaFiccion.add(p7);
		cienciaFiccion.add(p8);
		cienciaFiccion.add(p9);
		cienciaFiccion.add(p10);
		cienciaFiccion.add(p11);
		cienciaFiccion.add(p12);

		animacion.add(p13);
		animacion.add(p14);
		animacion.add(p15);
		animacion.add(p16);
		animacion.add(p17);
		animacion.add(p18);
		animacion.add(p19);
		animacion.add(p20);
		animacion.add(p21);
		animacion.add(p22);

		tradicional.add(p13);
		tradicional.add(p14);
		tradicional.add(p15);

		porOrdenador.add(p16);
		porOrdenador.add(p17);
		porOrdenador.add(p18);
		porOrdenador.add(p19);

		stopMotion.add(p20);
		stopMotion.add(p21);
		stopMotion.add(p22);

		series.add(s1);
		series.add(s2);
		series.add(s3);
		series.add(s4);
		series.add(s5);
		series.add(s6);

	}

	public void pedirOpcion() {

		opc = sc.nextInt();
		sc.nextLine();

	}

	public Integer comprobarUsuario(Integer numeroEmpleado) {

		if (numeroEmpleado == 1) {

			return 1;

		} else {

			for (UsuarioEstandar i : this.dependientes) {

				if (i.getId().equals(numeroEmpleado)) {

					return 2;

				}

			}

		}

		return -1;

	}

	public ArrayList<UsuarioSistema> getStaff() {

		return staff;

	}

	public ArrayList<UsuarioSistema> getUsuariosAplicacion() {

		return usuariosAplicacion;

	}

}
