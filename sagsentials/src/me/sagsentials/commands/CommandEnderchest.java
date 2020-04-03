package me.sagsentials.commands;

import me.sagsentials.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.sagsentials.utils.*;
import org.bukkit.*;

public class CommandEnderchest implements CommandExecutor
{
    private MainSentials plugin;
    
    public CommandEnderchest(final MainSentials plugin) {
        this.plugin = plugin;
        plugin.getCommand("enderchest").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(this.plugin.getConfig().getString("console_error_message")));
            return true;
        }
        final Player player = (Player)sender;
        if (sender.hasPermission("SagSentials.enderchest")) {
            player.openInventory(player.getEnderChest());
            player.sendMessage(Utils.chat(this.plugin.getConfig().getString("open_enderchest")));
            player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 20.0f, 1.0f);
            return true;
        }
        return true;
    }
}