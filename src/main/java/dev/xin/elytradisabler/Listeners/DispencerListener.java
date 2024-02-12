package dev.xin.elytradisabler.Listeners;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

import static dev.xin.elytradisabler.ElytraDisabler.config;

public class DispencerListener implements Listener {

    public void onDispense(BlockDispenseEvent e) {

        if (config.getBoolean("dispenser-fix", true)) {
            if (e.getItem().getType() == Material.ELYTRA) {
                e.setCancelled(true);
            }
        }
    }
}
