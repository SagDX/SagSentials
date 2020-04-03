package me.sagsentials.commands;

import me.sagsentials.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.sagsentials.utils.*;
import org.bukkit.*;

public class CommandCraft implements CommandExecutor
{
    private MainSentials plugin;
    
    public CommandCraft(final MainSentials plugin) {
        this.plugin = plugin;
        plugin.getCommand("craft").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(this.plugin.getConfig().getString("console_error_message")));
            return true;
        }
        final Player player = (Player)sender;
        if (sender.hasPermission("SagSentials.craft")) {
            player.openWorkbench((Location)null, true);
            player.sendMessage(Utils.chat(this.plugin.getConfig().getString("open_workbench")));
            player.playSound(player.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 20.0f, 1.0f);
            return true;
        }
        return true;
    }
}