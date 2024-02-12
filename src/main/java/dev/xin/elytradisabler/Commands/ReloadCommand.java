package dev.xin.elytradisabler.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import static dev.xin.elytradisabler.ElytraDisabler.config;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String cmd, @NotNull String[] args) {

        if (cmd.equalsIgnoreCase("elytradisabler") && args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            try {
                config.reload();

                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    player.sendMessage("Config has been reloaded");
                } else {
                    sender.sendMessage("Config has been reloaded");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return true;
    }
}
