package ejercicioExamen;

public class Usuario {

	protected String nombre;

	protected String contra;

	protected Integer id;

	public Usuario() {

	}

	public Usuario(String nombre) {

		this.nombre = nombre;

	}

	public Usuario(String nombre, String contra) {

		this.nombre = nombre;

		this.contra = contra;

	}

	public Usuario(String nombre, String contra, Integer id) {

		this.nombre = nombre;

		this.contra = contra;

		this.id = id;

	}

	public String getNombre() {

		return nombre;

	}

	public void setNombre(String nombre) {

		this.nombre = nombre;

	}

	public String getContra() {

		return contra;

	}

	public void setContra(String contra) {

		this.contra = contra;
	}

	public Integer getId() {

		return id;

	}

	public void setId(Integer id) {

		this.id = id;

	}

	@Override
	public String toString() {

		return "Nombre: " + this.nombre + ";\nContraseña: " + this.contra + "; Num.Id: " + this.id;

	}

}
