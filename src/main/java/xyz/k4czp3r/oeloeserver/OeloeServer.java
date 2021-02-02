package xyz.k4czp3r.oeloeserver;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.k4czp3r.oeloeserver.events.PlayerEventsListener;
import xyz.k4czp3r.oeloeserver.models.ConfigEntry;
import xyz.k4czp3r.oeloeserver.repository.PlayerStatRepository;
import xyz.k4czp3r.oeloeserver.repository.PlayerStatusRepository;
import xyz.k4czp3r.oeloeserver.tasks.PlayerStatsTask;
import xyz.k4czp3r.oeloeserver.utils.ConfigUtils;
import xyz.k4czp3r.oeloeserver.utils.LoggerUtils;

public class OeloeServer extends JavaPlugin {


    PlayerStatusRepository playerStatusRepository;
    PlayerStatRepository playerStatRepository;
    ConfigUtils configUtils;
    LoggerUtils loggerUtils;

    @Override
    public void onEnable(){
        loggerUtils = new LoggerUtils(this.getLogger());
        configUtils = new ConfigUtils(this);
        configUtils.createDefaultConfig();

        playerStatusRepository = new PlayerStatusRepository(configUtils);
        playerStatRepository = new PlayerStatRepository(configUtils);

        loggerUtils.out("Starting OeloeServer!");

        loggerUtils.out("Registering player status event!");
        getServer().getPluginManager().registerEvents(
                new PlayerEventsListener(
                        playerStatusRepository
                ), this);

        loggerUtils.out("Registering player statistics task!");
        getServer()
                .getScheduler()
                .scheduleSyncRepeatingTask(
                        this,
                        new PlayerStatsTask(playerStatRepository, loggerUtils),
                        0,
                        20L * configUtils.getConfigInt(ConfigEntry.STATISTICS_INTERVAL_IN_SECONDS)
                );

    }

    @Override
    public void onDisable(){
        getLogger().info("OeloeServer is shutting down...");

    }
}
