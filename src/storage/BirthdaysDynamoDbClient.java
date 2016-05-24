package storage;/*
 * Created by Liam Rahav on 5/24/16.
 */

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class BirthdaysDynamoDbClient {
    private final AmazonDynamoDBClient dynamoDBClient;

    public BirthdaysDynamoDbClient(final AmazonDynamoDBClient dynamoDBClient) {
        this.dynamoDBClient = dynamoDBClient;
    }

    public Birthday loadBirthday(final Birthday birthday) {
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);
        return mapper.load(birthday);
    }

    public void saveBirthday(final Birthday birthday) {
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);
        mapper.save(birthday);
    }
}
