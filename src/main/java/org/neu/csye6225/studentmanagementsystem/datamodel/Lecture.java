package org.neu.csye6225.studentmanagementsystem.datamodel;

import java.util.Set;
import java.util.HashSet;

public class Lecture extends BasicObject{
	public Set<String> notes;
	public Set<String> materials;
	
	public String getId() { return this.id; }
	public void setId(String id) { this.id = id; }
	
	public Set<String> getNotes() { 
		if (this.notes == null) {
			this.notes = new HashSet<>();
		}
		return this.notes; 
	}
	public void setNotes(Set<String> notes) { this.notes = notes; }
	
	public Set<String> getMaterials() { 
		if (this.materials == null) {
			this.materials = new HashSet<>();
		}
		return this.materials; 
	}
	public void setMaterials(Set<String> materials) { this.materials = materials; }
}