package xyz.k4czp3r.oeloeserver.utils;


import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatsUtils {
    public static List<Statistic> UNIVERSAL = Arrays.asList(
            Statistic.WALK_ONE_CM,
            Statistic.JUMP,
            Statistic.DEATHS,
            Statistic.CROUCH_ONE_CM,
            Statistic.BOAT_ONE_CM,
            Statistic.MOB_KILLS,
            Statistic.PLAYER_KILLS
    );

    public static List<Material> BREAK_MATERIALS = Arrays.asList(
            Material.STONE,
            Material.COAL_ORE,
            Material.DIAMOND_ORE,
            Material.EMERALD_ORE,
            Material.GOLD_ORE,
            Material.IRON_ORE,
            Material.LAPIS_ORE,
            Material.NETHER_GOLD_ORE,
            Material.NETHER_QUARTZ_ORE,
            Material.REDSTONE_ORE,
            Material.ACACIA_WOOD,
            Material.BIRCH_WOOD,
            Material.DARK_OAK_WOOD,
            Material.JUNGLE_WOOD,
            Material.OAK_WOOD,
            Material.SPRUCE_WOOD,
            Material.DIRT,
            Material.GRASS
    );

    public static List<Material> CRAFT_MATERIALS = Arrays.asList(
            Material.STICK,
            Material.TORCH
    );

}
