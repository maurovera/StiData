package servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import utilidades.HerramientaSmile;
import entidades.Tarea;
import entidades.Tema;

@Stateless
@LocalBean
public class TareaBean implements TareaLocal, TareaRemote{

	@PersistenceContext
	protected EntityManager em;
	
	
	@Override
	public void crearTarea(Tarea tarea) {
		em.persist(tarea);
		HerramientaSmile hs = new HerramientaSmile();
		hs.crearRed();	
	}


	@Override
	public Tarea verTarea(Integer id) {
		Tarea tarea = em.find(Tarea.class, id);
		if(tarea == null)
			return null;
		else
			return tarea;

	}
	
	
	

}
