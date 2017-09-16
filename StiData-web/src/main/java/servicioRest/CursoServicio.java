package servicioRest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import servicios.CursoBean;
import dto.CursoDTO;

@Path("ServicioCurso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class CursoServicio {

	
	@EJB
	private CursoBean cursoServicio;
	
	/**
	 * Crear una Tarea
	 * 
	 **/
	@PUT
	@Path("/guardar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardar(CursoDTO cursodto) {
		cursoServicio.guardar(cursodto);
		String result = "Tarea Creado : " + cursodto.getNombre();
		return Response.status(201).entity(result).build();

	}

	
	
}
