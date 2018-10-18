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

@Path("programs/{programId}/courses")
public class CourseResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<String> getCourseList(@PathParam("programId") String programId) {
		DynamoDB dynamoDB = DynamoDB.getInstance();
		BasicObject program = dynamoDB.getItem("Programs", programId);
		if(program == null)
			return null;
		return ((Program)program).getCourses();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Course createCourse(Course course, @PathParam("programId") String programId) {
		DynamoDB dynamoDB = DynamoDB.getInstance();
		if(dynamoDB.contains("Courses", course.id))
			return null;
		
		dynamoDB.addOrUpdateItem("Courses", course);
		BasicObject program = dynamoDB.getItem("Programs", programId);
		System.out.println(course.id);
		System.out.println(((Program)program).getCourses());
		((Program)program).getCourses().add(course.id);
		dynamoDB.addOrUpdateItem("Programs", program);
		return course;
	}
	
	@GET
	@Path("{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourse(@PathParam("courseId") String courseId) {
		DynamoDB dynamoDB = DynamoDB.getInstance();
		return (Course)dynamoDB.getItem("Courses", courseId);
	}
	
	@PUT
	@Path("{courseId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Course updateCourse(Course course, @PathParam("courseId") String courseId) {
		if(!course.id.equals(courseId))
			return null;
		DynamoDB dynamoDB = DynamoDB.getInstance();
		dynamoDB.addOrUpdateItem("Courses", course);
		return course;
	}
	
	@DELETE
	@Path("{courseId}")
	public void removeCourse(@PathParam("programId") String programId, 
			@PathParam("courseId") String courseId) {
		DynamoDB dynamoDB = DynamoDB.getInstance();
		if(!dynamoDB.contains("Courses", courseId))
			return;
		dynamoDB.deleteItem("Courses", courseId);
		BasicObject program = dynamoDB.getItem("Programs", programId);
		((Program)program).getCourses().remove(courseId);
		dynamoDB.addOrUpdateItem("Programs", program);
	}
}