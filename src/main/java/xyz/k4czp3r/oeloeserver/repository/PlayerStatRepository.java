package xyz.k4czp3r.oeloeserver.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bukkit.entity.Player;
import xyz.k4czp3r.oeloeserver.domain.PlayerStat;

import javax.xml.crypto.Data;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class PlayerStatRepository {
    private final MongoCollection<PlayerStat> collection;

    public PlayerStatRepository() {
        MongoDatabase database = Database.getMongoClient();
        collection = database.getCollection("PlayerStat", PlayerStat.class);
    }

    public void updateOrInsert(PlayerStat playerStat)
    {
        PlayerStat foundPlayerStat = collection.find(eq("statType", playerStat.getStatType())).first();
        if(foundPlayerStat == null)
        {
            collection.insertOne(playerStat);
        }
        else{
            collection.replaceOne(eq("statType", playerStat.getStatType()), playerStat);
        }
    }
}
