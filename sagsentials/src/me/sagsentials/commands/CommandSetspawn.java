package me.sagsentials.commands;

import me.sagsentials.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.sagsentials.utils.*;

public class CommandSetspawn implements CommandExecutor
{
    private MainSentials plugin;
    
    public CommandSetspawn(final MainSentials plugin) {
        this.plugin = plugin;
        plugin.getCommand("setspawn").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(this.plugin.getConfig().getString("console_error_message")));
            return true;
        }
        final Player player = (Player)sender;
        if (sender.hasPermission("SagSentials.admin")) {
            this.plugin.getConfig().set("spawn.world", (Object)player.getLocation().getWorld().getName());
            this.plugin.getConfig().set("spawn.x", (Object)player.getLocation().getX());
            this.plugin.getConfig().set("spawn.y", (Object)player.getLocation().getY());
            this.plugin.getConfig().set("spawn.z", (Object)player.getLocation().getZ());
            this.plugin.getConfig().set("spawn.pitch", (Object)player.getEyeLocation().getPitch());
            this.plugin.getConfig().set("spawn.yaw", (Object)player.getEyeLocation().getYaw());
            this.plugin.saveConfig();
            player.sendMessage(Utils.chat(this.plugin.getConfig().getString("setspawn_message")));
            return true;
        }
        return true;
    }
}