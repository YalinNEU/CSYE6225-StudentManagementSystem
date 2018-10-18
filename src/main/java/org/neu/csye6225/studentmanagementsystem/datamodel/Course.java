package org.neu.csye6225.studentmanagementsystem.datamodel;

import java.util.Set;

public class Course extends BasicObject {
	public String name;
	public String board;
	public String roaster;
	public Set<String> enrolledStudent;
	public String TA;
	public Set<String> lectures;
	
	public Course() {
		
	}
	
	public Course(String id, String name, String board, String roaster, Set<String> enrolledStudent, String TA) {
		this.id = id;
		this.name = name;
		this.board = board;
		this.roaster = roaster;
		this.enrolledStudent = enrolledStudent;
		this.TA = TA;
	}
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }
	
	public String getCourseName () {
		return name;
	}
	public void setCourseName(String name) {
		this.name = name;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getRoaster() {
		return roaster;
	}
	public void setRoaster(String roaster) {
		this.roaster = roaster;
	}
	public Set<String> getEnrolledStudent() {
		return enrolledStudent;
	}
	public void setEnrolledStudent(Set<String> enrolledStudent) {
		this.enrolledStudent = enrolledStudent;
	}
	public String getTA() {
		return TA;
	}
	public void setTA(String TA) {
		this.TA = TA;	
	}
	public Set<String> getLectures() {
		return lectures;
	}
	public void setLectures(Set<String> lectures) {
		this.lectures = lectures;
	}
}