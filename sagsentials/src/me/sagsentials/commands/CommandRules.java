package me.sagsentials.commands;

import me.sagsentials.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.sagsentials.utils.*;
import org.bukkit.*;

public class CommandRules implements CommandExecutor
{
    private MainSentials plugin;
    
    public CommandRules(final MainSentials plugin) {
        this.plugin = plugin;
        plugin.getCommand("rules").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(this.plugin.getConfig().getString("console_error_message")));
            return true;
        }
        final Player player = (Player)sender;
        if (sender.hasPermission("SagSentials.rules")) {
            for (final String rules : this.plugin.getConfig().getStringList("rules")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', rules));
            }
            return true;
        }
        return true;
    }
}