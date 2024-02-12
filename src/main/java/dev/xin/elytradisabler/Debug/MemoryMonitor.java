package dev.xin.elytradisabler.Debug;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class MemoryMonitor extends BukkitRunnable {

    private final JavaPlugin plugin;

    public MemoryMonitor(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        // Get current memory usage
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
        long usedMemory = heapMemoryUsage.getUsed();
        long maxMemory = heapMemoryUsage.getMax();

        // Log memory usage
        plugin.getLogger().info("Memory Usage - Used: " + usedMemory / 1024 + " KB, Max: " + maxMemory / 1024 + " KB");

        // Check for abnormal memory usage increase
        if (usedMemory > maxMemory * 0.8) {
            plugin.getLogger().warning("Possible memory leak detected! Used memory exceeds 80% of maximum memory.");
        }
    }

    public void startMonitoring(long intervalTicks) {
        // Run the monitoring task asynchronously with the specified interval
        this.runTaskTimerAsynchronously(plugin, 0L, intervalTicks);
    }
}
