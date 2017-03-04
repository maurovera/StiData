package servicios;

import javax.ejb.Local;

import entidades.Datos;

@Local
public interface DatosLocal {

	public String saluda(String nombre);
	
	public Datos traerUnDato();
	
	public void guardarUnDato(Datos dato);
	
	
}
