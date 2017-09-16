package servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import utilidades.HerramientaSmile;
import entidades.Datos;


@Stateless
@LocalBean
public class SmileBean implements SmileLocal, SmileRemote{

	
	@PersistenceContext
	protected EntityManager em;




	@Override
	public void crearUnArbol(Datos dato) {
		HerramientaSmile hs = new HerramientaSmile();
		hs.crearRed();
		System.out.println("pase");
	}
	
	public void crearUnArbolSinInterfaz(Datos dato) {
		HerramientaSmile hs = new HerramientaSmile();
		hs.crearRed();
		System.out.println("pase");
	}
	
		

}
