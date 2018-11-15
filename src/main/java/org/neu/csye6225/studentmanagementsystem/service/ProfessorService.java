package org.neu.csye6225.studentmanagementsystem.service;

import org.neu.csye6225.studentmanagementsystem.database.DynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class ProfessorService {
	
	DynamoDB dynamoDB;
	DynamoDBMapper mapper ;
	
	public ProfessorService() {
		dynamoDB = new DynamoDB();
	}
}