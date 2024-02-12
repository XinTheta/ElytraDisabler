package dev.xin.elytradisabler.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static dev.xin.elytradisabler.ElytraDisabler.config;

public class ElytraWearListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        if (config.getBoolean("disable-elytra", true)) {
            if (config.getBoolean("disable-elytra-interaction",  true)) {
                if (e.getPlayer().isOp()) {
                    return;
                }
                Player player = e.getPlayer();
                ItemStack invChestplate = player.getInventory().getChestplate();
                if (invChestplate != null && invChestplate.getType() == Material.ELYTRA) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
