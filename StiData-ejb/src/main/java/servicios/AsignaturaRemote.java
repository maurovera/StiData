package servicios;

import java.util.List;

import javax.ejb.Remote;

import entidades.Asignatura;

@Remote
public interface AsignaturaRemote {


		public void crearAsignatura(Asignatura asignatura); //crear
		public void modifAsignatura(Integer id); //modificar
		public void elimAsignatura(Integer id);//eliminar
		public Asignatura verAsignatura (Integer id);//ver
	
}
