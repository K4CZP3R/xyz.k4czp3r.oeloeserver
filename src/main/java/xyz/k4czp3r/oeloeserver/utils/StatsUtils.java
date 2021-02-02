package xyz.k4czp3r.oeloeserver.utils;


import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatsUtils {
    public static List<Material> BREAKABLE_BLOCKS = Arrays.asList(
            Material.COBBLESTONE,
            Material.STONE,
            Material.DIRT,
            Material.OBSIDIAN,
            Material.DIAMOND_ORE,
            Material.COAL_ORE,
            Material.EMERALD_ORE,
            Material.GOLD_ORE,
            Material.IRON_ORE,
            Material.LAPIS_ORE,
            Material.NETHER_GOLD_ORE,
            Material.NETHER_QUARTZ_ORE,
            Material.REDSTONE_ORE,
            Material.NETHERRACK,
            Material.NETHERITE_BLOCK
    );

    public static List<Statistic> COMMON_STATISTICS = Arrays.asList(
            Statistic.DEATHS,
            Statistic.DAMAGE_DEALT,
            Statistic.DAMAGE_TAKEN,
            Statistic.MOB_KILLS,
            Statistic.PLAYER_KILLS,
            Statistic.JUMP,
            Statistic.ANIMALS_BRED,
            Statistic.WALK_ONE_CM,
            Statistic.SWIM_ONE_CM,
            Statistic.BOAT_ONE_CM,
            Statistic.SPRINT_ONE_CM,
            Statistic.FALL_ONE_CM,
            Statistic.ITEM_ENCHANTED,
            Statistic.TIME_SINCE_REST,
            Statistic.TIME_SINCE_DEATH,
            Statistic.SNEAK_TIME
            );
    public static List<Material> CRAFTABLE_TOOLS = Arrays.asList(
            Material.DIAMOND_PICKAXE,
            Material.GOLDEN_PICKAXE,
            Material.IRON_PICKAXE,
            Material.NETHERITE_PICKAXE,
            Material.STONE_PICKAXE,
            Material.WOODEN_PICKAXE,

            Material.DIAMOND_AXE,
            Material.GOLDEN_AXE,
            Material.IRON_AXE,
            Material.NETHERITE_AXE,
            Material.STONE_AXE,
            Material.WOODEN_AXE,

            Material.DIAMOND_SHOVEL,
            Material.GOLDEN_SHOVEL,
            Material.IRON_SHOVEL,
            Material.NETHERITE_SHOVEL,
            Material.STONE_SHOVEL,
            Material.WOODEN_SHOVEL,

            Material.DIAMOND_SWORD,
            Material.GOLDEN_SWORD,
            Material.IRON_SWORD,
            Material.STONE_SWORD,
            Material.NETHERITE_SWORD,
            Material.WOODEN_SWORD,

            Material.DIAMOND_HOE,
            Material.GOLDEN_HOE,
            Material.IRON_HOE,
            Material.NETHERITE_HOE,
            Material.STONE_HOE,
            Material.WOODEN_HOE
    );
    public static List<EntityType> PASSIVE_MOBS = Arrays.asList(
            EntityType.BAT,
            EntityType.CAT,
            EntityType.CHICKEN,
            EntityType.COD,
            EntityType.COW,
            EntityType.DONKEY,
            EntityType.FOX,
            EntityType.HORSE,
            EntityType.MUSHROOM_COW,
            EntityType.MULE,
            EntityType.OCELOT,
            EntityType.PARROT,
            EntityType.PIG,
            EntityType.PIGLIN,
            EntityType.POLAR_BEAR,
            EntityType.RABBIT,
            EntityType.SALMON,
            EntityType.SHEEP,
            EntityType.SKELETON_HORSE,
            EntityType.SNOWMAN,
            EntityType.SQUID,
            EntityType.STRIDER,
            EntityType.TROPICAL_FISH,
            EntityType.TURTLE,
            EntityType.VILLAGER,
            EntityType.WANDERING_TRADER
    );
    public static List<EntityType> NEUTRAL_MOBS = Arrays.asList(
            EntityType.BEE,
            EntityType.CAVE_SPIDER,
            EntityType.DOLPHIN,
            EntityType.ENDERMAN,
            EntityType.IRON_GOLEM,
            EntityType.LLAMA,
            EntityType.PIGLIN,
            EntityType.PANDA,
            EntityType.POLAR_BEAR,
            EntityType.PUFFERFISH,
            EntityType.SPIDER,
            EntityType.WOLF,
            EntityType.ZOMBIFIED_PIGLIN
    );
    public static List<EntityType> HOSTILE_MOBS = Arrays.asList(
            EntityType.BLAZE,
            EntityType.CREEPER,
            EntityType.DROWNED,
            EntityType.ELDER_GUARDIAN,
            EntityType.ENDERMITE,
            EntityType.EVOKER,
            EntityType.GHAST,
            EntityType.GUARDIAN,
            EntityType.HOGLIN,
            EntityType.HUSK,
            EntityType.MAGMA_CUBE,
            EntityType.PHANTOM,
            EntityType.PIGLIN_BRUTE,
            EntityType.PILLAGER,
            EntityType.RAVAGER,
            EntityType.SHULKER,
            EntityType.SILVERFISH,
            EntityType.SKELETON,
            EntityType.SKELETON_HORSE,
            EntityType.SLIME,
            EntityType.STRAY,
            EntityType.VEX,
            EntityType.VINDICATOR,
            EntityType.WITCH,
            EntityType.WITHER_SKELETON,
            EntityType.ZOGLIN,
            EntityType.ZOMBIE,
            EntityType.ZOMBIE_VILLAGER
    );


}
