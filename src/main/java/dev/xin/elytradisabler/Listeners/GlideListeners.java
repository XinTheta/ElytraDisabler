package dev.xin.elytradisabler.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

import static dev.xin.elytradisabler.ElytraDisabler.config;

public class GlideListeners implements Listener {

    @EventHandler
    public void onPlayerGlide(EntityToggleGlideEvent e) {
        if (e.getEntity() instanceof Player) {
            if (config.getBoolean("disable-elytra", true)) {
                Player player = (Player) e.getEntity();
                if (player.isOp()) {
                    return;
                }
                if (config.getBoolean("disable-gliding",  true)) {
                    if (player.isGliding()) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}
