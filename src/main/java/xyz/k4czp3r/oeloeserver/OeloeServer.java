package xyz.k4czp3r.oeloeserver;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.k4czp3r.oeloeserver.events.PlayerEventsListener;
import xyz.k4czp3r.oeloeserver.repository.PlayerStatRepository;
import xyz.k4czp3r.oeloeserver.repository.PlayerStatusRepository;
import xyz.k4czp3r.oeloeserver.tasks.PlayerStatsTask;

public class OeloeServer extends JavaPlugin {

    @Override
    public void onEnable(){
        PlayerStatusRepository playerStatusRepository = new PlayerStatusRepository();
        PlayerStatRepository playerStatRepository = new PlayerStatRepository();

        getLogger().info("OeloeServer is starting...");
        getServer().getPluginManager().registerEvents(
                new PlayerEventsListener(
                        playerStatusRepository
                ), this);

        getServer().getScheduler().scheduleSyncRepeatingTask(this, new PlayerStatsTask(playerStatRepository), 0, 20 * 10);
    }

    @Override
    public void onDisable(){
        getLogger().info("OeloeServer is shutting down...");

    }
}
