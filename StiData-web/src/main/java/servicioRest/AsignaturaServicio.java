package servicioRest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import servicios.AsignaturaBean;
import entidades.Asignatura;
import entidades.Tema;

@Path("asignatura")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class AsignaturaServicio {

	@EJB
	private AsignaturaBean asignaturaBean;

	/**
	 * Lista de Asignatura
	 **/
	@GET
	@Path("/asignaturas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Asignatura> listaAsignaturas() {
		return asignaturaBean.listaAsignatura();
	}
	
	//trae una asignatura
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/asignaturas/{id}")
	public Asignatura obtenerAsig(@PathParam("id") Integer id) {
		Asignatura asignatura = new Asignatura();
		try {
		asignatura = asignaturaBean.verAsignatura(id);
		} catch (Exception e) {	
			   System.out.println(e);		
	}
		return asignatura;
	}
	

	/**
	 * Modificar una asignatura
	 * 
	 **/
	@POST
	@Path("/asignaturas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificarAsig(Asignatura asignatura) {
		asignaturaBean.modifAsignatura(asignatura);
		String result = "Asig Modificada : " + asignatura.getDescripcion();
		return Response.status(201).entity(result).build();

	}
	
	
	/**
	 * Crear un tema
	 * 
	 **/
	@PUT
	@Path("/asignaturas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearAsig(Asignatura asignatura) {
		asignaturaBean.crearAsignatura(asignatura);
		String result = "Asig Creada : " + asignatura.getDescripcion();
		return Response.status(201).entity(result).build();
	}


	/**
	 * Eliminar un tema
	 * 
	 ***/
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/asignaturas/{id}")
	public Response eliminarAsig(@PathParam("id") Integer id) {
		asignaturaBean.elimAsignatura(id);
		String result = "Asig Eliminada ";
		return Response.status(200).entity(result).build();

	}
}

