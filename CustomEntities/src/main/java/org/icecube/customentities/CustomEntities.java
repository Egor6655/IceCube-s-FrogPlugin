package org.icecube.customentities;

import org.bukkit.plugin.java.JavaPlugin;

public final class CustomEntities extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("spawnfrog").setExecutor(new CommandListener());


    }

    @Override
    public void onDisable() {

    }
}
