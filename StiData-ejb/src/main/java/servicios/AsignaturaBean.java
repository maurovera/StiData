package servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Asignatura;

@Stateless
@LocalBean
public class AsignaturaBean implements AsignaturaLocal, AsignaturaRemote{
	@PersistenceContext
	protected EntityManager em;

	@Override
	public void crearAsignatura(Asignatura asignatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifAsignatura(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimAsignatura(Integer id) {
		// TODO Auto-generated method stub
		
	}

//	 public List getConceptoList(int idTema) {
//	    	Tema tema = em.find(Tema.class, idTema);
//	    	List conceptoList = tema.getConceptoList();
//	    	System.out.println(conceptoList.toString());
//	    	return conceptoList;
//	    }
//	
	
	
	 public Asignatura verAsignatura(Integer id) {
		 Asignatura asig = em.find(Asignatura.class, id);
	    	List temaLista = asig.getListaTemas();
	    	System.out.println("trajo " + temaLista.get(0).toString());
	    	return asig;
	    }
	
	
	
//	@Override
//	public Asignatura verAsignatura(Integer id) {
//		String ql = "SELECT d from Asignatura d WHERE d.id=:id"; //se refiere a la clase
//		Query q = em.createQuery(ql).setParameter("id", id);
//		Asignatura asignatura = (Asignatura) q.getSingleResult();
//
//		return asignatura;
//	}
	
}
