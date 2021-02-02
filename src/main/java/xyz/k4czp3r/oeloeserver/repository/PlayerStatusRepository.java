package xyz.k4czp3r.oeloeserver.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import xyz.k4czp3r.oeloeserver.domain.PlayerStatus;
import xyz.k4czp3r.oeloeserver.models.ConfigEntry;
import xyz.k4czp3r.oeloeserver.utils.ConfigUtils;

public class PlayerStatusRepository {
    private final MongoCollection<PlayerStatus> collection;
    public PlayerStatusRepository(ConfigUtils configUtils) {
        MongoDatabase database = Database.getMongoClient(
                configUtils.getConfigString(ConfigEntry.MONGO_URL)
        );

        collection = database.getCollection("PlayerStatus", PlayerStatus.class);
    }


    public void insert(PlayerStatus playerStatus)
    {
        collection.insertOne(playerStatus);
    }
}
