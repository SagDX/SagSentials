package me.sagsentials.commands;

import me.sagsentials.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.sagsentials.utils.*;
import org.bukkit.*;

public class CommandReload implements CommandExecutor
{
    private MainSentials plugin;
    
    public CommandReload(final MainSentials plugin) {
        this.plugin = plugin;
        plugin.getCommand("SagSentials").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(this.plugin.getConfig().getString("console_error_message")));
            return true;
        }
        final Player player = (Player)sender;
        final int length = args.length;
        if (player.hasPermission("SagSentials.admin") && length == 1 && args[0].equalsIgnoreCase("reload")) {
            Bukkit.getPluginManager().getPlugin("SagSentials").reloadConfig();
            player.sendMessage(Utils.chat(this.plugin.getConfig().getString("reload_message")));
        }
        return true;
    }
}