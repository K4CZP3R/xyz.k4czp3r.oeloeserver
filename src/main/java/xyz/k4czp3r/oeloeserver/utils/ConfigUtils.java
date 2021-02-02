package xyz.k4czp3r.oeloeserver.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.k4czp3r.oeloeserver.models.ConfigEntry;

public class ConfigUtils {


    private JavaPlugin javaPlugin;

    public ConfigUtils(JavaPlugin javaPlugin)
    {
        this.javaPlugin = javaPlugin;
    }


    public void createDefaultConfig(){
        FileConfiguration config = javaPlugin.getConfig();
        for(ConfigEntry configEntry : ConfigEntry.values())
        {
            switch (configEntry){
                case MONGO_URL -> config.addDefault(configEntry.name(), "mongodb://127.0.0.1:27017");
                case STATISTICS_INTERVAL_IN_SECONDS -> config.addDefault(configEntry.name(), 20);
            }
        }

        config.options().copyDefaults(true);
        javaPlugin.saveConfig();
    }

    public String getConfigString(ConfigEntry configEntry)
    {
        return javaPlugin.getConfig().getString(configEntry.name());
    }
    public int getConfigInt(ConfigEntry configEntry)
    {
        return javaPlugin.getConfig().getInt(configEntry.name());
    }
}
