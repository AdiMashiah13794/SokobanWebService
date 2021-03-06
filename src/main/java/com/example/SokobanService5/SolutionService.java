package com.example.SokobanService5;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.db.DbHandler;
import com.example.db.SokobanSolution;

@Path("solutions")
public class SolutionService {

	private DbHandler dbHandler=new DbHandler();

	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
	// @Path("{name}")
	  public String getSolution(@QueryParam("name") String name) {
	       return dbHandler.getSolution(name);
	    }

	 @POST
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public void addSolution(@FormParam("name") String name,@FormParam("solution") String solution) {
		 System.out.println("add solution in the service");
		 System.out.println(name);
		 System.out.println(solution);
	       SokobanSolution sol=new SokobanSolution(name,solution);
	       dbHandler.addSolution(sol);
	    }

}
