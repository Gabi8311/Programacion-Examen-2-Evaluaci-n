package ejercicioExamen;

import java.util.ArrayList;
import java.util.Scanner;

public class Series extends Alquilables {

	private ArrayList<Temporadas> temporadas = new ArrayList<Temporadas>();

	private Integer numTemporadas;

	public Series() {

		super();

	}

	public Series(ArrayList<Temporadas> temporadas, Integer numTemporadas) {

		this.temporadas = temporadas;

		this.numTemporadas = numTemporadas;

	}

	public Series(Integer numTemporadas) {

		this.numTemporadas = numTemporadas;

	}

	public Series(String nombre, Double valoracion) {

		super(nombre, valoracion);

	}

	public Series(String nombre, String director, Integer lanzamiento, Double valoracion) {

		super(nombre, director, lanzamiento, valoracion);

	}

	public Series(String nombre, String director, Integer lanzamiento, Double valoracion, Integer numCopias,
			Integer numTemporadas) {

		super(nombre, director, lanzamiento, valoracion, numCopias);

		this.numTemporadas = numTemporadas;

	}

	/*Añade la serie al videoclub. Pasamos al método los ArrayList de los que forman parte.*/
	
	public boolean addSeriesAlVideoClub(ArrayList<Alquilables> alquilables, ArrayList<Series> todasSeries) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la informacion de la serie que vas a agregar al videoclub");
		System.out.println("Título:");
		String titulo = sc.nextLine();

		for (Alquilables i : alquilables) {

			if (i.getNombre().equalsIgnoreCase(titulo)) {

				return false;

			} else {

				System.out.println("Introduce el nombre del director:");
				String nomDirector = sc.nextLine();

				System.out.println("Introduce año de lanzamiento:");
				Integer lanzamiento = sc.nextInt();
				sc.nextLine();

				while (lanzamiento > 2020 || lanzamiento < 1951) {

					System.out.println("Año de lanzamiento erróneo");
					System.out.println("Introduce el año de lanzamiento real:");
					lanzamiento = sc.nextInt();
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

				System.out.println("Introduce el número de copias:");
				Integer numCopias = sc.nextInt();
				sc.nextLine();

				System.out.println("Introduce el número de temporadas:");
				Integer numTemp = sc.nextInt();
				sc.nextLine();

				this.nombre = titulo;
				this.director = nomDirector;
				this.lazamiento = lanzamiento;
				this.valoracion = valoracion;
				this.numCopias = numCopias;
				this.numTemporadas = numTemp;

				for (int j = 0; j < numTemp; j++) {

					System.out.println("La " + (j + 1) + "ª");

					this.addTemporadas(temporadas);

				}

				alquilables.add(this);
				todasSeries.add(this);

				return true;

			}

		}

		return false;

	}

	/*Elimina la serie del videoclub. Pasamos al método los ArrayList de los que forman parte.*/
	
	public boolean eliminarSerie(String nombre, ArrayList<Alquilables> alquilables, ArrayList<Series> todasSeries) {

		for (Series i : todasSeries) {

			if (i.getNombre().equalsIgnoreCase(nombre)) {

				todasSeries.remove(i);

				alquilables.remove(i);

				return true;

			}

		}

		return false;

	}

	public void addTemporadas(ArrayList<Temporadas> temporadas) {

		Temporadas temporada = new Temporadas(5.0);

		temporadas.add(temporada);

	}

	public void setTemporadas(Integer numTemporadas) {

		this.numTemporadas = numTemporadas;

	}

	public Integer getNumTemporadas() {

		return numTemporadas;

	}

	public ArrayList<Temporadas> getTemporadas() {

		return temporadas;

	}

	public void setTemporadas(ArrayList<Temporadas> temporadas) {

		this.temporadas = temporadas;

	}

	@Override
	public String toString() {

		return super.toString() + "; Num.de Temporadas: " + this.numTemporadas+"\n";

	}

}
