package org.neu.csye6225.studentmanagementsystem.datamodel;

import java.util.HashSet;
import java.util.Set;

public class Program extends BasicObject {
	public String name;
	public Set<String> courses;
	public Set<String> students;
	public Program() {
		
	}
	public Program(String id, String name, Set<String> courses, Set<String> students) {
		this.id = id;
		this.name = name;
		this.courses = courses;
		this.students = students;
	}
	
	public String getId() { return this.id; } 
	public void setId(String programId) { this.id = programId; } 
	
	public Set<String> getCourses() { 
		if (this.courses == null) {
			this.courses = new HashSet<>();
		}
		return this.courses; 
	}
	public void setNotes(Set<String> courses) { this.courses = courses; }
	
	public Set<String> getStudents() { 
		if (this.students == null) {
			this.students = new HashSet<>();
		}
		return this.students; 
	}
	public void setMaterials(Set<String> students) { this.students = students; }
}