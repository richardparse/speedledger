package service;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;


public class AccountService {

   MongoClient client = new MongoClient("localhost", 27017);
   Datastore datastore = new Morphia().createDatastore(client, "bankAccount");

}
