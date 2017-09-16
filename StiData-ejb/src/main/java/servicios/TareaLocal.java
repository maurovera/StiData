package servicios;

import java.util.List;

import entidades.Tarea;
import entidades.TareaDetalle;

public interface TareaLocal {

	public void crearTarea(Tarea tarea);
	public Tarea verTarea(Integer id);//ver
	public void crearTareaConEjercicios(Tarea tarea, List<TareaDetalle> listaEjercicios);
	
}
