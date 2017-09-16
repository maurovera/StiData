package servicios;

import javax.ejb.Local;

import entidades.Datos;

@Local
public interface SmileLocal {
	
	public void crearUnArbol(Datos dato);


}
