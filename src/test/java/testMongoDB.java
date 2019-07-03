import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class testMongoDB {

    public static void main(String... args) {
        System.err.println("mongoDB");

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

    }
}
