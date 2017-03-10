package servicioRest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import servicios.TareaBean;
import entidades.Tarea;


@Path("ServicioTarea")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class TareaServicio {

	
	@EJB
	private TareaBean tareaServicio;
	
	/**
	 * Crear una Tarea
	 * 
	 **/
	@PUT
	@Path("/tareas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearTema(Tarea tarea) {
		tareaServicio.crearTarea(tarea);
		String result = "Tarea Creado : " + tarea.getNombre();
		return Response.status(201).entity(result).build();

	}

	/**
	 * Trae un Tema
	 **/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tareas/{id}")
	public Tarea obtenerTarea(@PathParam("id") Integer id) {
		Tarea t = tareaServicio.verTarea(id);
		return t;
	}
	
	
	
}
