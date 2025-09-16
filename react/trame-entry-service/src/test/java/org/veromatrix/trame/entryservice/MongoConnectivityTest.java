package org.veromatrix.trame.entryservice;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

public class MongoConnectivityTest {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongoClient.getDatabase("trackme_db");
        System.out.println(db.listCollectionNames().into(new ArrayList<>()));
    }
}
