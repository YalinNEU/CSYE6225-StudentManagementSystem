package org.neu.csye6225.studentmanagementsystem.resource;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.neu.csye6225.studentmanagementsystem.database.DynamoDB;
import org.neu.csye6225.studentmanagementsystem.datamodel.BasicObject;
import org.neu.csye6225.studentmanagementsystem.datamodel.Program;


@Path ("programs")
public class ProgramResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<String> getProgramList() {
		return DynamoDB.getInstance().getAllItems("Programs");
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Program createProgram(Program program) {
		DynamoDB dynamoDB = DynamoDB.getInstance();		
		dynamoDB.addOrUpdateItem("Programs", program);
		return program;
	}
	
	@GET
	@Path("{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Program getProgram(@PathParam("programId") String programId) {
		DynamoDB dynamoDB = DynamoDB.getInstance();
		BasicObject object = dynamoDB.getItem("Programs", programId);
		return (Program)object;
	}
	
	@PUT
	@Path("{programId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Program updateProgram(@PathParam("programId") String programId
			, Program program) {
		DynamoDB dynamoDB = DynamoDB.getInstance();
		dynamoDB.addOrUpdateItem("Programs", program);	
		return program;
	}
	
	@DELETE
	@Path("{programId}")
	public void deleteProgram(@PathParam("programId") String programId) {
		DynamoDB dynamoDB = DynamoDB.getInstance();
		dynamoDB.deleteItem("Programs", programId);
	}
}