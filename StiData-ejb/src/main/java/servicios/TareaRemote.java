package servicios;

import entidades.Tarea;

public interface TareaRemote {

	public void crearTarea(Tarea tarea);
	public Tarea verTarea(Integer id);
	
}
