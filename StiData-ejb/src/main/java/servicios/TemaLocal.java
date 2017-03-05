package servicios;

import java.util.List;

import javax.ejb.Local;

import entidades.Tema;

@Local
public interface TemaLocal {

	public void crearTema(Tema tema); //crear
	public void modifTema(Tema tema); //modificar
	public void eliminarTema(Integer id);//eliminar
	public Tema verTema(Integer id);//ver
	public List<Tema> listaTemas(); 
}
