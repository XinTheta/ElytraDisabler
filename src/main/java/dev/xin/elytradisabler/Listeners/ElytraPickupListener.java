package dev.xin.elytradisabler.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import static dev.xin.elytradisabler.ElytraDisabler.config;

public class ElytraPickupListener implements Listener {

    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent e) {
        if (config.getBoolean("disable-elytra", true)) {
            if (config.getBoolean("disable-elytra-pickup", true)) {
                Player player = (Player) e.getEntity();
                if (player.isOp()) {
                    return;
                }
                if (e.getEntity() instanceof Player) {
                    ItemStack item = e.getItem().getItemStack();
                    if (item.getType()  == Material.ELYTRA) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}
