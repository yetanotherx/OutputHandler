package yetanotherx.bukkitplugin.OutputHandler;

import java.io.File;

import org.bukkit.util.config.Configuration;

public class OutputHandlerSettings {

    /**
     * Settings
     */
    public static boolean debugMode = false;
    public static boolean fastEnabled = true;
    public static boolean slowEnabled = true;
    public static String fastLog = "plugins" + File.separator + "OutputHandler" + File.separator + "too_fast.log";
    public static String slowLog = "plugins" + File.separator + "OutputHandler" + File.separator + "too_slow.log";
    /**
     * Bukkit config class
     */
    public static Configuration config = null;

    /**
     * Load and parse the YAML config file
     */
    public static void load() {

        File dataDirectory = new File("plugins" + File.separator + "OutputHandler" + File.separator);

        dataDirectory.mkdirs();

        File file = new File("plugins" + File.separator + "OutputHandler", "config.yml");

        config = new Configuration(file);
        config.load();

        if (!file.exists()) {
            config.setProperty("outputhandler.debug", debugMode);
            config.setProperty("outputhandler.too_fast.enabled", fastEnabled);
            config.setProperty("outputhandler.too_slow.enabled", slowEnabled);
            config.setProperty("outputhandler.too_fast.log", fastLog);
            config.setProperty("outputhandler.too_slow.log", slowLog);

            config.save();
        }

        setSettings();


    }

    /**
     * Sets the internal variables
     */
    private static void setSettings() {

        debugMode = config.getBoolean("outputhandler.debug", debugMode);
        fastEnabled = config.getBoolean("outputhandler.too_fast.enabled", fastEnabled);
        slowEnabled = config.getBoolean("outputhandler.too_slow.enabled", slowEnabled);
        fastLog = config.getString("outputhandler.too_fast.log", fastLog);
        slowLog = config.getString("outputhandler.too_fast.log", slowLog);

    }
}
