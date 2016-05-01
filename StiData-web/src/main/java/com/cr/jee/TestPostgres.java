package com.cr.jee;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import fpuna.sti.base.entity.Regla;
import fpuna.sti.serviceBean.ReglaServiceBean;

@Path("postgres")
@Stateless
@LocalBean
public class TestPostgres {

	@EJB
	private ReglaServiceBean r;

	@GET
	public Response findByID(@QueryParam("id") Integer base) throws Throwable {

		GenericEntity<List<Regla>> list = new GenericEntity<List<Regla>>(r.findByID(base)) {};
        return Response.ok(list).build();
		
	}
}