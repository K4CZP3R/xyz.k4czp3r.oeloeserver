package xyz.k4czp3r.oeloeserver.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.k4czp3r.oeloeserver.domain.PlayerStatus;
import xyz.k4czp3r.oeloeserver.models.PlayerStatusType;
import xyz.k4czp3r.oeloeserver.repository.PlayerStatusRepository;

public class PlayerEventsListener implements Listener {

    private final PlayerStatusRepository playerStatusRepository;

    public PlayerEventsListener(PlayerStatusRepository playerStatusRepository)
    {
        this.playerStatusRepository = playerStatusRepository;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        PlayerStatus newPlayerStatus = new PlayerStatus.Builder(
                event.getPlayer().getUniqueId().toString(),
                event.getPlayer().getName(),
                PlayerStatusType.JOINED
        ).build();

        playerStatusRepository.insert(newPlayerStatus);

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        PlayerStatus newPlayerStatus = new PlayerStatus.Builder(
                event.getPlayer().getUniqueId().toString(),
                event.getPlayer().getName(),
                PlayerStatusType.LEFT
        ).build();

        playerStatusRepository.insert(newPlayerStatus);

    }
}
