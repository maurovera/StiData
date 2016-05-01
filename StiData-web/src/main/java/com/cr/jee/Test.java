package com.cr.jee;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Session Bean implementation class Test
 */
@Path("test")
@Stateless
@LocalBean
public class Test {
    
    @EJB
    private Message message;

    @GET
    @Produces("text/html")
    public String getHtml(){
    	return message.getMessage();
    	
    }
    

}
