package me.sagsentials.commands;

import me.sagsentials.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import me.sagsentials.utils.*;
import org.bukkit.*;

public class CommandSpawnplayer implements CommandExecutor
{
    private MainSentials plugin;
    
    public CommandSpawnplayer(final MainSentials plugin) {
        this.plugin = plugin;
        plugin.getCommand("spawnplayer").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(this.plugin.getConfig().getString("console_error_message")));
            return true;
        }
        final Player player = (Player)sender;
        if (player.hasPermission("SagSentials.admin")) {
            final int length = args.length;
            if (length == 1) {
                for (final Player playerToSpawn : Bukkit.getServer().getOnlinePlayers()) {
                    if (playerToSpawn.getName().equalsIgnoreCase(args[0])) {
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
                        playerToSpawn.teleport(loc);
                        final String message1 = Utils.chat(this.plugin.getConfig().getString("pts_spawn")).replace("%staff%", player.getName());
                        final String message2 = Utils.chat(this.plugin.getConfig().getString("staff_spawn")).replace("%pts%", playerToSpawn.getName());
                        message1.replace("%staff%", player.getName());
                        message2.replace("%pts%", playerToSpawn.getName());
                        playerToSpawn.sendMessage(message1);
                        player.sendMessage(message2);
                        playerToSpawn.playSound(playerToSpawn.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 20.0f, 1.0f);
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 20.0f, 1.0f);
                        return true;
                    }
                }
            }
        }
        return true;
    }
}