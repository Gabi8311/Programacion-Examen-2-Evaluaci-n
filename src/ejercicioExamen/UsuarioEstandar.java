package ejercicioExamen;

public class UsuarioEstandar extends UsuarioSistema{
	
	public UsuarioEstandar() {
		
	}
	
	public UsuarioEstandar(String nombre,String contraseña,Integer id) {
		
		super(nombre,contraseña,id);
			
	}
	
//	public void mostrarDatos() {ESTO NO HACE FALTA
//
//		System.out.println(this);
//		
//	}
	
	
	@Override
	public String toString() {

		return "Empleado: "+"\n"+super.toString();
	
	}	
	
}