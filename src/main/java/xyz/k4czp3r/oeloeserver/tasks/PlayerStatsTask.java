package xyz.k4czp3r.oeloeserver.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import xyz.k4czp3r.oeloeserver.domain.PlayerStats;
import xyz.k4czp3r.oeloeserver.repository.PlayerStatRepository;
import xyz.k4czp3r.oeloeserver.utils.LoggerUtils;
import xyz.k4czp3r.oeloeserver.utils.StatsUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerStatsTask implements Runnable {
    private final PlayerStatRepository playerStatRepository;
    private final LoggerUtils loggerUtils;

    public PlayerStatsTask(PlayerStatRepository playerStatRepository,
                           LoggerUtils loggerUtils) {
        this.playerStatRepository = playerStatRepository;
        this.loggerUtils = loggerUtils;

    }

    private HashMap<String, Integer> getCommonStatistics(Player player) {
        HashMap<String, Integer> stats = new HashMap<>();
        for (Statistic statistic : StatsUtils.COMMON_STATISTICS) {
            int value = player.getStatistic(statistic);

            stats.put(statistic.name(), value);


        }
        return stats;
    }

    private HashMap<String, Integer> getBrokenPlacedItems(Player player) {
        HashMap<String, Integer> stats = new HashMap<>();
        for (Material material : StatsUtils.BREAKABLE_BLOCKS) {
            int value = player.getStatistic(Statistic.BREAK_ITEM, material);
            stats.put(String.format("%s@%s",Statistic.BREAK_ITEM.name(), material.name()), value);
        }

        return stats;

    }

    private HashMap<String, Integer> getCraftedItemsByPlayer(Player player) {
        HashMap<String, Integer> stats = new HashMap<>();

        for (Material material : StatsUtils.CRAFTABLE_TOOLS) {
            int value = player.getStatistic(Statistic.CRAFT_ITEM, material);
            stats.put(String.format("%s@%s",Statistic.CRAFT_ITEM.name(), material.name()), value);

        }

        return stats;

    }

    private HashMap<String, Integer> getEnemiesKilledPlayer(Player player) {
        List<EntityType> allEntities = new ArrayList<>();
        allEntities.addAll(StatsUtils.NEUTRAL_MOBS);
        allEntities.addAll(StatsUtils.HOSTILE_MOBS);


        HashMap<String, Integer> stats = new HashMap<>();
        for (EntityType entityType : allEntities) {
            int value = player.getStatistic(Statistic.ENTITY_KILLED_BY, entityType);
            stats.put(String.format("%s@%s",Statistic.ENTITY_KILLED_BY.name(), entityType.name()), value);
        }

        return stats;
    }

    private HashMap<String, Integer> getEnemiesKilledByPlayer(Player player) {
        List<EntityType> allEntities = new ArrayList<>();
        allEntities.addAll(StatsUtils.NEUTRAL_MOBS);
        allEntities.addAll(StatsUtils.PASSIVE_MOBS);
        allEntities.addAll(StatsUtils.HOSTILE_MOBS);



        HashMap<String, Integer> stats = new HashMap<>();
        for (EntityType entityType : allEntities) {
            int value = player.getStatistic(Statistic.KILL_ENTITY, entityType);
            stats.put(String.format("%s@%s",Statistic.KILL_ENTITY.name(), entityType.name()), value);
        }

        return stats;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerStats.Builder playerStatsBuilder = new PlayerStats.Builder(player.getUniqueId());

            playerStatsBuilder.addStatsFromHashmap(getEnemiesKilledByPlayer(player));
            playerStatsBuilder.addStatsFromHashmap(getEnemiesKilledPlayer(player));
            playerStatsBuilder.addStatsFromHashmap(getCraftedItemsByPlayer(player));
            playerStatsBuilder.addStatsFromHashmap(getCommonStatistics(player));
            playerStatsBuilder.addStatsFromHashmap(getBrokenPlacedItems(player));

            PlayerStats playerStats = playerStatsBuilder.build();

            loggerUtils.out(String.format("Will add %d statistics from %s",
                    playerStats.getStatNames().size(),
                    player.getName()));

            playerStatRepository.updateOrInsert(playerStats);
        }

    }
}
