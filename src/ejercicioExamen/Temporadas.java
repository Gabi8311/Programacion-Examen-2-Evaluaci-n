package ejercicioExamen;

import java.util.ArrayList;
import java.util.Scanner;

public class Temporadas {

	private ArrayList<Episodios> capitulos = new ArrayList<Episodios>();

	private Integer numCopias;

	public Temporadas() {

	}

	public Temporadas(Double valoracion) {

		Scanner sc = new Scanner(System.in);

		Integer numEpisodios;

		System.out.println("Cuántos episodios tiene?");
		numEpisodios = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < numEpisodios; i++) {

			Episodios capit = new Episodios(valoracion);

			capitulos.add(capit);

		}
	}

	public ArrayList<Episodios> getCapitulos() {

		return capitulos;

	}

	public void setCapitulos(ArrayList<Episodios> capitulos) {

		this.capitulos = capitulos;

	}

	public Integer getNumCopias() {

		return numCopias;

	}

	public void setNumCopias(Integer numCopias) {

		this.numCopias = numCopias;

	}

}
