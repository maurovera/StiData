package servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import utilidades.HerramientaSmile;
import dto.TareaDTO;
import entidades.Curso;
import entidades.Tarea;
import entidades.TareaDetalle;

@Stateless
@LocalBean
public class TareaBean implements TareaLocal, TareaRemote {

	@PersistenceContext
	protected EntityManager em;
	
	@EJB
	private CursoBean cursoBean;

	@Override
	public void crearTarea(Tarea tarea) {
		em.persist(tarea);
		HerramientaSmile hs = new HerramientaSmile();
		hs.crearRed();
	}

	@Override
	public Tarea verTarea(Integer id) {
		Tarea tarea = em.find(Tarea.class, id);
		if (tarea == null)
			return null;
		else
			return tarea;

	}

	
	// No se usa. Tener en cuenta esto
	
	@Override
	public void crearTareaConEjercicios(Tarea tarea,
			List<TareaDetalle> listaEjercicios) {

		try {

			for (TareaDetalle td : listaEjercicios) {
				td.setTarea(tarea);
			}
			tarea.setListaTareas(listaEjercicios);
			em.persist(tarea);
		} catch (Exception e) {
				e.getStackTrace();
				
		}

	}
	
	
	
	public void guardar(TareaDTO tareadto){
		
		// Se crea una tarea. Y se setea todo los datos de tareaDTO
		Tarea tarea = new Tarea();
		/**traemos el curso al cual corresponde, en
		 * el dto solo se trae su id. Y aqui se trae de la base
		 * de datos todo el curso
		 * */
		Curso c = cursoBean.verCurso(tareadto.getCurso());
		tarea.setCurso(c);
		tarea.setDescripcion(tareadto.getDescripcion());
		tarea.setEstadoTarea(tareadto.isEstadoTarea());
		tarea.setFechaInicio(tareadto.getFechaInicio());
		tarea.setNombre(tareadto.getNombre());
		// falta tiempo, lista de conceptos y temas.
		
		
		/**Se borra el id ficticio del detalle, se le asigna la tarea y se guarda en la lista.*/
		for (TareaDetalle d : tareadto.getListaTareas()) {
			d.setIdTareaDetalle(null);
			d.setTarea(tarea);
			tarea.getListaTareas().add(d);
		}
		
		em.persist(tarea);

	}
	
}
