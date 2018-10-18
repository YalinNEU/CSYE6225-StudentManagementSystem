package org.neu.csye6225.studentmanagementsystem.datamodel;

import java.util.List;
import java.util.Set;

public class Student extends BasicObject{
	private String name;
	private String image;
	private String programName;
	private Set<String> courseEnrolled;
	
	public Student() {
		
	}
	public Student(String id, String name, String programName, Set<String> courseEnrolled) {
		this.id = id;
		this.name = name;
		this.programName = programName;
		this.courseEnrolled = courseEnrolled;
	}
	public String getId() { return this.id; } 
	public void setId(String programId) { this.id = programId; } 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProgram() {
		return programName;
	}
	public void setProgram(String programName) {
		this.programName = programName;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Set<String> getCourseEnrolled() {
		return courseEnrolled;
	}
	public void setCourseEnrolled(Set<String> courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}
}
