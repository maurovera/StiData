package servicios;

import java.util.List;

import javax.ejb.Local;

import entidades.Asignatura;
import entidades.Tema;

@Local
public interface AsignaturaLocal {
	public void crearAsignatura(Asignatura asignatura); //crear
	public void modifAsignatura(Asignatura asignatura); //modificar
	public void elimAsignatura(Integer id);//eliminar
	public Asignatura verAsignatura (Integer id);//ver
	public List<Asignatura> listaAsignatura();
}
