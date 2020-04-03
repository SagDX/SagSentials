package me.sagsentials.commands;

import me.sagsentials.*;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import me.sagsentials.utils.*;

public class CommandHat implements CommandExecutor
{
    private MainSentials plugin;
    
    public CommandHat(final MainSentials plugin) {
        this.plugin = plugin;
        plugin.getCommand("hat").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(this.plugin.getConfig().getString("console_error_message")));
            return true;
        }
        final Player player = (Player)sender;
        if (!sender.hasPermission("SagSentials.hat")) {
            return false;
        }

            final ItemStack hand = player.getInventory().getItemInMainHand();
            final ItemStack head = player.getInventory().getHelmet();

            if(hand == null || hand.getType() == Material.AIR) {
                player.sendMessage(Utils.chat(this.plugin.getConfig().getString("hat_air")));
                return true;
            }
            if(hand.getAmount() != 1) {
                player.sendMessage(Utils.chat(this.plugin.getConfig().getString("hat_only_one")));
                return true;
            }
            else if(hand.getType() == Material.CHICKEN) {
            	player.getInventory().setHelmet(hand);
                player.getInventory().remove(hand);
                player.sendMessage(Utils.chat(this.plugin.getConfig().getString("hat_chicken")));
                player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_AMBIENT, 20.0f, 1.0f);
            	
            }
            else {
                player.getInventory().setHelmet(hand);
                player.getInventory().remove(hand);
                player.sendMessage(Utils.chat(this.plugin.getConfig().getString("hat_worked")));
                player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 20.0f, 1.0f);
            }
            if(head != null) {
                player.getInventory().addItem(head);
            }
            return true;
    }
}