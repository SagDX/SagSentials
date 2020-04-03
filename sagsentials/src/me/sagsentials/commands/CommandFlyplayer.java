package me.sagsentials.commands;

import me.sagsentials.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.sagsentials.utils.*;
import org.bukkit.*;

public class CommandFlyplayer implements CommandExecutor
{
    private MainSentials plugin;
    
    public CommandFlyplayer(final MainSentials plugin) {
        this.plugin = plugin;
        plugin.getCommand("flyplayer").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(this.plugin.getConfig().getString("console_error_message")));
            return true;
        }
        final Player player = (Player)sender;
        final int length = args.length;
        if (length == 1) {
            for (final Player playerToFly : Bukkit.getServer().getOnlinePlayers()) {
                if (playerToFly.getName().equalsIgnoreCase(args[0]) && sender.hasPermission("SagSentials.admin")) {
                    if (!playerToFly.getAllowFlight()) {
                        playerToFly.setAllowFlight(true);
                        final String message1 = Utils.chat(this.plugin.getConfig().getString("ptf_enable_fly")).replace("%staff%", player.getName());
                        final String message2 = Utils.chat(this.plugin.getConfig().getString("staff_enable_fly")).replace("%ptf%", playerToFly.getName());
                        message1.replace("%staff%", player.getName());
                        message2.replace("%ptf%", playerToFly.getName());
                        playerToFly.sendMessage(message1);
                        player.sendMessage(message2);
                        playerToFly.playSound(playerToFly.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 20.0f, 1.0f);
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 20.0f, 1.0f);
                        return true;
                    }
                    if (playerToFly.getAllowFlight()) {
                        final String message3 = Utils.chat(this.plugin.getConfig().getString("ptf_disable_fly")).replace("%staff%", player.getName());
                        final String message4 = Utils.chat(this.plugin.getConfig().getString("staff_disable_fly")).replace("%ptf%", playerToFly.getName());
                        message3.replace("%staff%", player.getName());
                        message4.replace("%ptf%", playerToFly.getName());
                        playerToFly.setAllowFlight(false);
                        playerToFly.setFlying(false);
                        playerToFly.sendMessage(message3);
                        player.sendMessage(message4);
                        playerToFly.playSound(playerToFly.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 20.0f, 1.0f);
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 20.0f, 1.0f);
                    }
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}