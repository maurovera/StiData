package servicios;

import javax.ejb.Remote;

import entidades.Datos;

@Remote
public interface DatosRemote {
	
	public String saluda(String nombre);
	

	public Datos traerUnDato();
	
	public void guardarUnDato(Datos dato);
	
}
