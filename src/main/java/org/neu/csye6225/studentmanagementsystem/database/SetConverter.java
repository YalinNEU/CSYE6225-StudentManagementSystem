package org.neu.csye6225.studentmanagementsystem.database;

import java.util.HashSet;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class SetConverter implements DynamoDBTypeConverter<String, Set<String>>{
	@Override
	public String convert(Set<String> set) {
		StringBuilder strBuilder = new StringBuilder();
		for (String str : set) {
			strBuilder.append(str + ",");
		}
		return strBuilder.toString();
	}
	
	@Override
	public Set<String> unconvert(String str) {
		String[] strs = str.split(",");
		Set<String> set = new HashSet<>();
		for(String item : strs) {
			set.add(item);
		}
		return set;
	}
}