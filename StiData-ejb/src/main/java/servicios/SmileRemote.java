package servicios;

import javax.ejb.Remote;

import entidades.Datos;

@Remote
public interface SmileRemote {

	
	public void crearUnArbol(Datos dato);
	
}
