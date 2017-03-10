package servicios;

import entidades.Tarea;

public interface TareaLocal {

	public void crearTarea(Tarea tarea);
	public Tarea verTarea(Integer id);//ver
	
}
