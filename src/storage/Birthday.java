package storage;/*
 * Created by Liam Rahav on 5/24/16.
 */

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Birthdays")
public class Birthday {
    private String user;
    private String date;

    public Birthday(String user, String date) {
        this.user = user;
        this.date = date;
    }

    @DynamoDBHashKey(attributeName = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @DynamoDBHashKey(attributeName = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
