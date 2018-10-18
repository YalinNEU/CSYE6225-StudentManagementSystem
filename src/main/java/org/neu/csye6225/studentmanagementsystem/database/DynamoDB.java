package org.neu.csye6225.studentmanagementsystem.database;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.neu.csye6225.studentmanagementsystem.datamodel.BasicObject;
import org.neu.csye6225.studentmanagementsystem.datamodel.Course;
import org.neu.csye6225.studentmanagementsystem.datamodel.Program;
import org.neu.csye6225.studentmanagementsystem.datamodel.Student;

public class DynamoDB {
	
	private static DynamoDB instance = null;
	Map<String, Map<String, BasicObject>> map;
	
	public DynamoDB() {
		map = new HashMap<>();
		map.put("Programs", new HashMap<String, BasicObject>());
	    map.put("Courses", new HashMap<String, BasicObject>());
		map.put("Lectures", new HashMap<String, BasicObject>());
		map.put("Students", new HashMap<String, BasicObject>());
		Program program1 = new Program("IS","Information System", new HashSet<>(Arrays.asList("INFO6001","INFO5000","CSYE6225")), new HashSet<>(Arrays.asList("stu001", "stu003")));
		Program program2 = new Program("CS","Computer Science", new HashSet<>(Arrays.asList("CS5001","CS6570")), new HashSet<>(Arrays.asList("stu002","stu004")));
		Student student1 = new Student("stu001", "Yalin", "IS", new HashSet<>(Arrays.asList("CSYE6225","INFO5000")));
		Student student2 = new Student("stu002", "Lynne", "CS", new HashSet<>(Arrays.asList("CS5001","CS6570")));
		Student student3 = new Student("stu003", "Ben", "IS", new HashSet<>(Arrays.asList("INFO6001","INFO5000")));
		Student student4 = new Student("stu004", "Jack", "CS", new HashSet<>(Arrays.asList("CS5001")));
		Course course1 = new Course("CSYE6225", "Cloud Computing", "BOARD", "ROASTER", new HashSet<>(Arrays.asList("stu001")), "stu003");
		Course course2 = new Course("INFO5000", "JAVA", "BOARD", "ROASTER", new HashSet<>(Arrays.asList("stu001","stu003")), "stu001");
		Course course3 = new Course("CS5001", "PDP", "BOARD", "ROASTER", new HashSet<>(Arrays.asList("stu004")), "stu002");
		Course course4 = new Course("CS6570", "OOD", "BOARD", "ROASTER", new HashSet<>(Arrays.asList("stu001","stu003")), "stu004");
		Course course5 = new Course("INFO6001", "Web Design", "BOARD", "ROASTER", new HashSet<>(Arrays.asList("stu002","stu004")), "stu002");
		map.get("Programs").put("IS", program1);
		map.get("Programs").put("CS", program2);
		map.get("Courses").put("CSYE6225", course1);
		map.get("Courses").put("INFO5000", course2);
		map.get("Courses").put("CS5001", course3);
		map.get("Courses").put("CS6570", course4);
		map.get("Courses").put("INFO6001", course5);
		map.get("Students").put("stu001", student1);
		map.get("Students").put("stu002", student2);
		map.get("Students").put("stu003", student3);
		map.get("Students").put("stu004", student4);
	}
	
	public static DynamoDB getInstance() {
		if (instance == null) {
			instance = new DynamoDB();
		}
		return instance;
	}
	
	public void addOrUpdateItem(String tableName, BasicObject obj) {
		if (!map.containsKey(tableName)) {
			map.put(tableName, new HashMap<String, BasicObject>());
		}
		Map<String, BasicObject> items = map.get(tableName);
		System.out.println(obj.id);
		System.out.println(obj);
		items.put(obj.id, obj);
	}
	
	public BasicObject getItem(String tableName, String key) {
		BasicObject object = map.get(tableName).get(key);
		return object;
	}
	public Set<String> getAllItems(String tableName) {
		
		System.out.println(tableName);
		
		if (map.get(tableName) ==  null) {
			return new HashSet<>();
		}
		Map<String, BasicObject> items = map.get(tableName);
		System.out.print(items.keySet());
		
		
		//return "";
	    return items.keySet();
	}
	
	public void deleteItem(String tableName, String key) {
		if (contains(tableName, key)) {
			map.get(tableName).remove(key);
		}
	}
	
	public boolean contains(String tableName, String key) {
		if (map.containsKey(tableName) && map.get(tableName).containsKey(key)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("start db");
		DynamoDB dynamoDB = DynamoDB.getInstance();
		dynamoDB.map.put("Programs", new HashMap<String, BasicObject>());
		System.out.println("insert program map");
		dynamoDB.map.put("Courses", new HashMap<String, BasicObject>());
		System.out.println("insert course map");
		dynamoDB.map.put("Lectures", new HashMap<String, BasicObject>());
		dynamoDB.map.put("Students", new HashMap<String, BasicObject>());
	}
}