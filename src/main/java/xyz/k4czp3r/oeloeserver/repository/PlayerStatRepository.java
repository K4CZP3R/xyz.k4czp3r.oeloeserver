package xyz.k4czp3r.oeloeserver.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import xyz.k4czp3r.oeloeserver.domain.PlayerStats;
import xyz.k4czp3r.oeloeserver.models.ConfigEntry;
import xyz.k4czp3r.oeloeserver.utils.ConfigUtils;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class PlayerStatRepository {
    private final MongoCollection<PlayerStats> collection;

    public PlayerStatRepository(ConfigUtils configUtils) {
        MongoDatabase database = Database.getMongoClient(
                configUtils.getConfigString(ConfigEntry.MONGO_URL)
        );
        collection = database.getCollection("PlayerStat", PlayerStats.class);
    }

    public void updateOrInsert(PlayerStats playerStats)
    {
        PlayerStats foundPlayerStats = collection.find(eq("playerId", playerStats.getPlayerId())).first();
        if(foundPlayerStats == null)
        {
            collection.insertOne(playerStats);
        }
        else{
            collection.replaceOne(eq("playerId", playerStats.getPlayerId()), playerStats);
        }
    }
}
