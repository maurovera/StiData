package servicioRest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import servicios.TemaBean;
import entidades.Tema;

@Path("temaServicio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class TemaServicio {

	@EJB
	private TemaBean temaBean;

	/**
	 * Lista de temas
	 **/
	@GET
	@Path("/temas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tema> listaTemas() {
		return temaBean.listaTemas();
	}

	/**
	 * Trae un Tema
	 **/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/temas/{id}")
	public Tema obtenerTema(@PathParam("id") Integer id) {
		Tema t = temaBean.verTema(id);
		return t;
	}

	/**
	 * Modificar un tema
	 * 
	 **/
	@POST
	@Path("/temas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificarTema(Tema tema) {
		temaBean.modifTema(tema);
		String result = "Tema Modificado : " + tema.getNombre();
		return Response.status(201).entity(result).build();

	}
	
	
	/**
	 * Crear un tema
	 * 
	 **/
	@PUT
	@Path("/temas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearTema(Tema tema) {
		temaBean.crearTema(tema);
		String result = "Tema Creado : " + tema.getNombre();
		return Response.status(201).entity(result).build();

	}


	/**
	 * Eliminar un tema
	 * 
	 ***/
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/temas/{id}")
	public Response eliminarTema(@PathParam("id") Integer id) {
		temaBean.eliminarTema(id);
		String result = "Tema Eliminado ";
		return Response.status(200).entity(result).build();

	}

	
}
