package me.sagsentials.commands;

import me.sagsentials.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.sagsentials.utils.*;
import org.bukkit.*;

public class CommandSpawn implements CommandExecutor
{
    private MainSentials plugin;
    
    public CommandSpawn(final MainSentials plugin) {
        this.plugin = plugin;
        plugin.getCommand("spawn").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(this.plugin.getConfig().getString("console_error_message")));
            return true;
        }
        final Player player = (Player)sender;
        if (!sender.hasPermission("SagSentials.spawn")) {
            return true;
        }
        if (this.plugin.getConfig().getConfigurationSection("spawn") == null) {
            player.sendMessage(Utils.chat(this.plugin.getConfig().getString("notspawnyet_message")));
            return false;
        }
        final Location loc = player.getLocation();
        final World w = Bukkit.getServer().getWorld(this.plugin.getConfig().getString("spawn.world"));
        final double x = this.plugin.getConfig().getDouble("spawn.x");
        final double y = this.plugin.getConfig().getDouble("spawn.y");
        final double z = this.plugin.getConfig().getDouble("spawn.z");
        final double pitch = this.plugin.getConfig().getDouble("spawn.pitch");
        final double yaw = this.plugin.getConfig().getDouble("spawn.yaw");
        loc.setWorld(w);
        loc.setX(x);
        loc.setY(y);
        loc.setZ(z);
        loc.setPitch((float)pitch);
        loc.setYaw((float)yaw);
        player.teleport(loc);
        player.sendMessage(Utils.chat(this.plugin.getConfig().getString("spawn_message")));
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 20.0f, 1.0f);
        return true;
    }
}