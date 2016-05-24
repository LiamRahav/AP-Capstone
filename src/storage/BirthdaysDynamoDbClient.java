package storage;/*
 * Created by Liam Rahav on 5/24/16.
 */

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class BirthdaysDynamoDbClient {
    private final AmazonDynamoDBClient dynamoDBClient;

    public BirthdaysDynamoDbClient(final AmazonDynamoDBClient dynamoDBClient) {
        this.dynamoDBClient = dynamoDBClient;
    }
}
