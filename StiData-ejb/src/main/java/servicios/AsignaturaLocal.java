package servicios;

import java.util.List;

import javax.ejb.Local;

import entidades.Asignatura;

@Local
public interface AsignaturaLocal {
	public void crearAsignatura(Asignatura asignatura); //crear
	public void modifAsignatura(Integer id); //modificar
	public void elimAsignatura(Integer id);//eliminar
	public Asignatura verAsignatura (Integer id);//ver
}
