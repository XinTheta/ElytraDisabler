package dev.xin.elytradisabler;

import dev.xin.elytradisabler.Commands.ReloadCommand;
import dev.xin.elytradisabler.Debug.MemoryMonitor;
import dev.xin.elytradisabler.Listeners.ElytraPickupListener;
import dev.xin.elytradisabler.Listeners.ElytraWearListener;
import dev.xin.elytradisabler.Listeners.GlideListeners;
import org.bukkit.plugin.java.JavaPlugin;

import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;

import java.io.File;
import java.io.IOException;


public final class ElytraDisabler extends JavaPlugin {

    public static YamlDocument config;
    private MemoryMonitor memoryMonitor;

    @Override
    public void onEnable() {

        try {
            config = YamlDocument.create(new File(getDataFolder(), "config.yml"), getResource("config.yml"),
                    GeneralSettings.DEFAULT, LoaderSettings.builder().setAutoUpdate(true).build(), DumperSettings.DEFAULT, UpdaterSettings.builder().setVersioning(new BasicVersioning("config-version")).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getLogger().info("Config loaded!");

        // Register Events
        getServer().getPluginManager().registerEvents(new ElytraPickupListener(), this);
        getServer().getPluginManager().registerEvents(new GlideListeners(), this);
        getServer().getPluginManager().registerEvents(new ElytraWearListener(), this);

        // Register commands
        getCommand("elytradisabler").setExecutor(new ReloadCommand());


        // Only for debug
        // Will be removed on release

        memoryMonitor = new MemoryMonitor(this);
        memoryMonitor.startMonitoring(20 * 60 * 5); // Check memory usage every 5 minutes (adjust as needed)


        getLogger().info("Listeners and Commands have been loaded!");

    }

    @Override
    public void onDisable() {
        try {
            config.reload();
            getLogger().info("Config saved!");
        } catch (IOException e) {
            getLogger().warning("Something went wrong during saving the config");
            getLogger().warning("Create a issue on github!");
            throw new RuntimeException(e);
        }
    }
}
