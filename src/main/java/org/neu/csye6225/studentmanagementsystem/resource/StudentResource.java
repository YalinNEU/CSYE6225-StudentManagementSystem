package org.neu.csye6225.studentmanagementsystem.resource;

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
import org.neu.csye6225.studentmanagementsystem.datamodel.Course;
import org.neu.csye6225.studentmanagementsystem.datamodel.Program;
import org.neu.csye6225.studentmanagementsystem.datamodel.Student;

@Path("programs/{programId}/students")
public class StudentResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<String> getCourseList(@PathParam("programId") String programId) {
		DynamoDB dynamoDB = DynamoDB.getInstance();
		BasicObject program = dynamoDB.getItem("Programs", programId);
		if(program == null)
			return null;
		return ((Program)program).getStudents();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student createStudent(@PathParam("programId") String programId, Student student) {
		DynamoDB dynamoDB = DynamoDB.getInstance();
		Program program = (Program)dynamoDB.getItem("Programs", programId);
		if(dynamoDB.contains("Students", student.id) || program == null)
			return null;
		
		program.getStudents().add(student.id);
		dynamoDB.addOrUpdateItem("Programs", program);
		dynamoDB.addOrUpdateItem("Students", student);
		return student;
	}
	
}