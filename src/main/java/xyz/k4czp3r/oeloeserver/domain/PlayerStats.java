package xyz.k4czp3r.oeloeserver.domain;

import org.bson.types.ObjectId;

import java.util.*;

public class PlayerStats {
    private ObjectId id;
    private String playerId;
    private List<Integer> statValues;
    private List<String> statNames;


    public String getPlayerId() {
        return playerId;
    }

    public List<Integer> getStatValues() {
        return statValues;
    }

    public List<String> getStatNames() {
        return statNames;
    }

    public ObjectId getId() {
        return id;
    }

    public static class Builder {
        private final String playerId;
        private final List<Integer> statValues;
        private final List<String> statNames;


        public Builder(UUID playerId)
        {
            this.playerId = playerId.toString();
            statValues = new ArrayList<>();
            statNames = new ArrayList<>();

        }

        public Builder addStats(String statName, int statValue)
        {
            statNames.add(statName);
            statValues.add(statValue);
            return this;
        }

        public Builder addStatsFromHashmap(HashMap<String, Integer> stats)
        {
            for(Map.Entry<String, Integer> s : stats.entrySet())
            {
                statNames.add(s.getKey());
                statValues.add(s.getValue());
            }
            return this;
        }


        public PlayerStats build(){
            PlayerStats playerStats = new PlayerStats();
            playerStats.playerId = playerId;
            playerStats.statNames = statNames;
            playerStats.statValues = statValues;
            return playerStats;
        }
    }
}
