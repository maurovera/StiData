package servicioRest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import servicios.AsignaturaBean;
import entidades.Asignatura;

@Path("asignatura")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class AsignaturaServicio {

	@EJB
	private AsignaturaBean asignaturaBean;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/obtener/{id}")
	public Asignatura obtenerAsig(@PathParam("id") Integer id) {
		Asignatura asignatura = new Asignatura();
		try {
		asignatura = asignaturaBean.verAsignatura(id);
		} catch (Exception e) {	
			   System.out.println(e);		
	}
		return asignatura;
	}
}

