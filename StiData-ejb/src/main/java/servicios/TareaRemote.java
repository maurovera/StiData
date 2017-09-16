package servicios;

import java.util.List;

import entidades.Tarea;
import entidades.TareaDetalle;

public interface TareaRemote {

	public void crearTarea(Tarea tarea);
	public Tarea verTarea(Integer id);
	public void crearTareaConEjercicios(Tarea tarea, List<TareaDetalle> listaEjercicios);
	
	
}
