package xyz.k4czp3r.oeloeserver.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import xyz.k4czp3r.oeloeserver.domain.PlayerStat;
import xyz.k4czp3r.oeloeserver.repository.PlayerStatRepository;
import xyz.k4czp3r.oeloeserver.utils.StatsUtils;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatsTask implements Runnable{
    private final PlayerStatRepository playerStatRepository;

    public PlayerStatsTask(PlayerStatRepository playerStatRepository){
        this.playerStatRepository = playerStatRepository;

    }

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers())
        {
            List<PlayerStat> statsToAdd = new ArrayList<>();

            String playerId = player.getUniqueId().toString();
            for(Statistic statistic : StatsUtils.UNIVERSAL)
            {
                String type = statistic.name();
                int value = player.getStatistic(statistic);

                statsToAdd.add(
                        new PlayerStat.Builder(playerId, type).setStatValue(value).build()
                );
            }

            for(Material material : StatsUtils.BREAK_MATERIALS)
            {
                String type = String.format("BREAK_%s", material.name());
                int value = player.getStatistic(Statistic.BREAK_ITEM, material);
                statsToAdd.add(
                        new PlayerStat.Builder(playerId, type).setStatValue(value).build()
                );

            }

            for(Material material : StatsUtils.CRAFT_MATERIALS)
            {
                String type = String.format("CRAFT_%s", material.name());
                int value = player.getStatistic(Statistic.CRAFT_ITEM, material);
                statsToAdd.add(
                        new PlayerStat.Builder(playerId, type).setStatValue(value).build()
                );
            }

            System.out.printf("Adding %d stats for user %s%n",
                    statsToAdd.size(),
                    player.getName());

            for(PlayerStat toAdd : statsToAdd)
            {
                playerStatRepository.updateOrInsert(toAdd);
            }

        }

    }
}
