package org.neu.csye6225.studentmanagementsystem.database;

import java.util.ArrayList;
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

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.util.TableUtils;

public class DynamoDB {

	Map<String, Class> classMap = new HashMap<>();
	private static AmazonDynamoDB dynamoDb;
	private static DynamoDBMapper mapper;
	private static DynamoDB instance = null;
	
	public DynamoDB() {
		try {
			
			BasicAWSCredentials awsCreds = new BasicAWSCredentials("Access_Key_Id"
					, "Secret_Access_Key");
			
			//DefaultAWSCredentialsProviderChain.getInstance()
			dynamoDb = AmazonDynamoDBClientBuilder
					.standard()
					.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
					.withRegion(Regions.US_WEST_2)
					.build();
			
			mapper = new DynamoDBMapper(dynamoDb);
			classMap.put("Programs", Program.class);
		
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static DynamoDB getInstance() {
		if (instance == null) {
			instance = new DynamoDB();
		}
		return instance;
	}
	public void createTable(String tableName, String key) throws Exception {
		List<KeySchemaElement> keySchema = new ArrayList<>();
		List<AttributeDefinition> attributeDefinitions = new ArrayList<>();
		
		keySchema.add(new KeySchemaElement().withAttributeName(key)
				.withKeyType(KeyType.HASH));
		
		attributeDefinitions.add(new AttributeDefinition().withAttributeName(key)
				.withAttributeType(ScalarAttributeType.S));
		
		CreateTableRequest createTableRequest = new CreateTableRequest()
				.withTableName(tableName)
				.withKeySchema(keySchema)
				.withAttributeDefinitions(attributeDefinitions)
				.withProvisionedThroughput(
						new ProvisionedThroughput()
						.withReadCapacityUnits(3L)
						.withWriteCapacityUnits(3L));
		
		TableUtils.createTableIfNotExists(dynamoDb, createTableRequest);
		TableUtils.waitUntilActive(dynamoDb, tableName);
		
	}
	
	public void addOrUpdateItem(BasicObject obj) {
		System.out.print(obj);
		mapper.save(obj);
	}
	
	public BasicObject getItem(String tableName, String key) {
		BasicObject object = (BasicObject) mapper.load(classMap.get(tableName), key);
		return object;
	}
	public Set<String> getAllItems(String tableName) {
		List<BasicObject> objs = mapper.scan(classMap.get(tableName), new DynamoDBScanExpression());
		Set<String> result = new HashSet<>();
		for(BasicObject object : objs)
			result.add(object.id);
		return result;
		
	}
	
	public void deleteItem(String tableName, String key) {
		BasicObject object = (BasicObject) mapper.load(classMap.get(tableName), key);
		mapper.delete(object, new DynamoDBDeleteExpression());
	}
	
	public boolean contains(String tableName, String key) {
		BasicObject object = (BasicObject) mapper.load(classMap.get(tableName), key);
		return object != null;
	}
	
	public static void main(String[] args) throws Exception {
		DynamoDB dynamoDB = DynamoDB.getInstance();
		dynamoDB.createTable("Programs", "id");		
	}
}