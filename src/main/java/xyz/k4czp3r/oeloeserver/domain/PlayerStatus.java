package xyz.k4czp3r.oeloeserver.domain;

import org.bson.types.ObjectId;
import xyz.k4czp3r.oeloeserver.models.PlayerStatusType;
import xyz.k4czp3r.oeloeserver.utils.TimeUtils;

public class PlayerStatus {
    private ObjectId id;
    private String playerId;
    private String playerName;
    private long timeOfEvent;
    private PlayerStatusType type;

    public String getPlayerName() {
        return playerName;
    }

    public ObjectId getId() {
        return id;
    }

    public PlayerStatusType getType() {
        return type;
    }

    public String getPlayerId() {
        return playerId;
    }

    public long getTimeOfEvent() {
        return timeOfEvent;
    }

    public static class Builder {
        private final String playerId;
        private long timeOfEvent;
        private final PlayerStatusType type;
        private final String playerName;

        public Builder(String playerId, String playerName, PlayerStatusType playerStatusType) {
            this.playerId = playerId;
            this.playerName = playerName;
            this.type = playerStatusType;
            this.timeOfEvent = TimeUtils.getCurrentUnix();
        }

        public Builder setTimeOfEvent(long timeOfEvent) {
            this.timeOfEvent = timeOfEvent;
            return this;
        }

        public PlayerStatus build(){
            PlayerStatus playerStatus = new PlayerStatus();
            playerStatus.playerId = playerId;
            playerStatus.type = type;
            playerStatus.timeOfEvent = timeOfEvent;
            playerStatus.playerName = playerName;
            return playerStatus;
        }
    }
}
