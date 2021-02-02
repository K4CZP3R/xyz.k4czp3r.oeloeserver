package xyz.k4czp3r.oeloeserver.domain;

import org.bson.types.ObjectId;

public class PlayerStat {
    private ObjectId id;
    private String playerId;
    private String statType;
    private int statValue;

    public ObjectId getId() {
        return id;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getStatType() {
        return statType;
    }

    public int getStatValue() {
        return statValue;
    }

    public static class Builder {
        private final String playerId;
        private final String statType;
        private int statValue;

        public Builder(String playerId, String statType)
        {
            this.playerId = playerId;
            this.statType = statType;
        }

        public Builder setStatValue(int statValue)
        {
            this.statValue = statValue;
            return this;
        }

        public PlayerStat build(){
            PlayerStat playerStat = new PlayerStat();
            playerStat.playerId = playerId;
            playerStat.statValue = statValue;
            playerStat.statType = statType;
            return playerStat;
        }
    }
}
