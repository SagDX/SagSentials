package me.sagsentials;

import org.bukkit.plugin.java.*;
import org.bukkit.*;
import org.bukkit.event.Listener;
import me.sagsentials.utils.*;
import me.sagsentials.commands.*;
import me.sagsentials.recipes.GrapplingRecipe;

public class MainSentials extends JavaPlugin implements Listener
{
    public void onEnable() {
        this.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "SagSentials" + ChatColor.GOLD + " Has been" + ChatColor.GREEN + " enabled" + ChatColor.GOLD + " correctly!" + ChatColor.AQUA + " :D");
        this.saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);
        new CommandRules(this);
        new CommandReglas(this);
        new CommandReload(this);
        new CommandFlyplayer(this);
        new CommandFly(this);
        new CommandCraft(this);
        new CommandSetspawn(this);
        new CommandSpawn(this);
        new CommandSpawnplayer(this);
        new CommandEnderchest(this);
        new CommandHat(this);
        new GrapplingRecipe(this);
        int pluginId = 6914;
        @SuppressWarnings("unused")
		Metrics metrics = new Metrics(this, pluginId);
    }
    
    public void onDisable() {
    	this.saveConfig();
        this.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "SagSentials" + ChatColor.GOLD + " Has been" + ChatColor.RED + " disabled" + ChatColor.GOLD + "!");
    }
}