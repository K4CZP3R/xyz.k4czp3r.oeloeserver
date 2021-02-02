package xyz.k4czp3r.oeloeserver.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import xyz.k4czp3r.oeloeserver.domain.PlayerStatus;
import xyz.k4czp3r.oeloeserver.models.PlayerStatusType;

public class PlayerStatusRepository {
    private final MongoCollection<PlayerStatus> collection;
    public PlayerStatusRepository() {
        MongoDatabase database = Database.getMongoClient();

        collection = database.getCollection("PlayerStatus", PlayerStatus.class);
    }


    public void insert(PlayerStatus playerStatus)
    {
        collection.insertOne(playerStatus);
    }
}
