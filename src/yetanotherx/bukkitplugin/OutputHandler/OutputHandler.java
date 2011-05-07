package yetanotherx.bukkitplugin.OutputHandler;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * OutputHandler Version 1.0 - Control the Minecraft Logger
 * Copyright (C) 2011 Yetanotherx <yetanotherx -a--t- gmail -dot- com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class OutputHandler extends JavaPlugin {

    public static final Logger log = Logger.getLogger("Minecraft");

    public static final Logger too_fast_log = Logger.getLogger("yetanotherx.bukkitplugin.OutputHandler.Logger.too_fast");
    public static final Logger too_slow_log = Logger.getLogger("yetanotherx.bukkitplugin.OutputHandler.Logger.too_slow");

    public void onDisable() {
        log.info("[OutputHandler] Plugin disabled. (version " + this.getDescription().getVersion() + ")");
    }

    public void onEnable() {

        OutputHandlerSettings.load();

        try {
            setupLogging();
        } catch (Exception ex) {
            this.getServer().getPluginManager().disablePlugin(this);
        }
        

        log.info("[OutputHandler] Adding listener to Minecraft's logger");
        Logger.getLogger("Minecraft").setFilter(new OutputHandlerFilter());

        //Print that the plugin has been enabled!
        log.info("[OutputHandler] Plugin enabled! (version " + this.getDescription().getVersion() + ")");

    }

    private void setupLogging() throws SecurityException, IOException {

	Handler handler = new FileHandler("plugins" + File.separator + "OutputHandler" + File.separator + "too_fast.log" );
	handler.setFormatter(new SimpleFormatter());
	too_fast_log.addHandler(handler);
        too_fast_log.setUseParentHandlers(false);
	
	handler = new FileHandler("plugins" + File.separator + "OutputHandler" + File.separator + "too_slow.log" );
	handler.setFormatter(new SimpleFormatter());
	too_slow_log.addHandler(handler);
        too_slow_log.setUseParentHandlers(false);

    }

}
