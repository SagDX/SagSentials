package me.sagsentials.commands;

import me.sagsentials.*;

import org.bukkit.Sound;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.sagsentials.utils.*;

public class CommandFly implements CommandExecutor
{
    private MainSentials plugin;
    
    public CommandFly(final MainSentials plugin) {
        this.plugin = plugin;
        plugin.getCommand("fly").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(this.plugin.getConfig().getString("console_error_message")));
            return true;
        }
        final Player player = (Player)sender;
        if (!sender.hasPermission("SagSentials.fly")) {
            return false;
        }
        if (!player.getAllowFlight()) {
            player.setAllowFlight(true);
            player.sendMessage(Utils.chat(this.plugin.getConfig().getString("enable_fly")));
            player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 20.0f, 1.0f);
            return true;
        }
        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage(Utils.chat(this.plugin.getConfig().getString("disable_fly")));
            player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 20.0f, 1.0f);
        }
        return true;
    }
}