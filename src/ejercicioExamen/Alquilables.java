package ejercicioExamen;					

import java.util.ArrayList;

public class Alquilables {

	protected String nombre;

	protected String director;

	protected Integer lazamiento;

	protected Double valoracion;

	protected ArrayList<Double> mediaValoraciones = new ArrayList<>();

	protected ArrayList<Alquilables> totalElementos = new ArrayList<Alquilables>();

	protected Integer numCopias;
	

	public Alquilables() {

	}

	public Alquilables(String nombre, Double valoracion) {

		this.nombre = nombre;

		this.valoracion = valoracion;

	}

	public Alquilables(String nombre, String director, Integer lanzamiento) {

		this.nombre = nombre;

		this.director = director;

		this.lazamiento = lanzamiento;

	}

	public Alquilables(String nombre, String director, Integer lanzamiento, Double valoracion) {

		this.nombre = nombre;

		this.director = director;

		this.lazamiento = lanzamiento;

		this.valoracion = valoracion;

	}

	public Alquilables(String nombre, String director, Integer lanzamiento, Double valoracion, Integer numCopias) {

		this.nombre = nombre;

		this.director = director;

		this.lazamiento = lanzamiento;

		this.valoracion = valoracion;

		this.numCopias = numCopias;

	}

	/*Este método saca la media de las valoraciones.
	 * Le pasamos el ArrayList de las medias de las valoraciones
	 * y le pasamos la nueva valoración.
	 * */
	
	public Double mediaValoracion(ArrayList<Double> valoraciones, Double valoracion) {

		Double nuevaMedia = 0.0;

		valoraciones.add(valoracion);

		for (int i = 0; i < valoraciones.size(); i++) {

			nuevaMedia += valoraciones.get(i);

		}

		nuevaMedia = nuevaMedia / (valoraciones.size());

		return nuevaMedia;

	}
	


	public String getNombre() {

		return nombre;

	}

	public void setNombre(String nombre) {

		this.nombre = nombre;

	}

	public String getDirector() {

		return director;

	}

	public void setDirector(String director) {

		this.director = director;

	}

	public Integer getLazamiento() {

		return lazamiento;

	}

	public void setLazamiento(Integer lazamiento) {

		this.lazamiento = lazamiento;

	}

	public Integer getNumCopias() {

		return numCopias;

	}

	public void setNumCopias(Integer numCopias) {

		this.numCopias = numCopias;

	}

	public Double getValoracion() {

		return valoracion;

	}

	public void setValoracion(Double valoracion) {

		this.valoracion = valoracion;

	}

	public ArrayList<Double> getMediaValoraciones() {

		return mediaValoraciones;

	}

	public void setMediaValoraciones(ArrayList<Double> mediaValoraciones) {

		this.mediaValoraciones = mediaValoraciones;

	}

	@Override
	public String toString() {

		return "Título: " + this.nombre + "\n Director: " + this.director + "; Año de estreno: " + this.lazamiento +

				"; Valoración de los usuarios: " + this.valoracion + "; Num.Copias: " + this.numCopias;

	}

}
