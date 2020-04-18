package ejercicioExamen;

public class UsuarioEstandar extends UsuarioSistema{
	
	public UsuarioEstandar() {
		
	}
	
	public UsuarioEstandar(String nombre,String contraseña,Integer id) {
		
		super(nombre,contraseña,id);
			
	}
	
	@Override
	public String toString() {

		return "Empleado: "+"\n"+super.toString();
	
	}	
	
}