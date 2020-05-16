package me.sagsentials.recipes;

import me.sagsentials.*;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import me.sagsentials.utils.*;
import org.bukkit.*;
import java.util.ArrayList;

public class GrapplingRecipe implements Listener {
	private MainSentials plugin;

	public GrapplingRecipe(final MainSentials plugin) {
		this.plugin = plugin;
	}

	ItemStack GHook = new ItemStack(Material.FISHING_ROD,
			this.plugin.getConfig().getInt("Items.GrapplingHook.Amount"));
	private ItemMeta meta = GHook.getItemMeta();

	public void giveItems(Player player) {
		meta.setDisplayName(Utils.chat(this.plugin.getConfig().getString("Items.GrapplingHook.ItemName")));
		ArrayList<String> lore = new ArrayList<String>();
		for(String s : plugin.getConfig().getStringList("Items.GrapplingHook.ItemLore")) {
		lore.addAll(this.plugin.getConfig().getStringList("Items.GrapplingHook.ItemLore"));
		lore.add(ChatColor.translateAlternateColorCodes('&', s));
		meta.setLore(lore);
		GHook.setItemMeta(meta);
		player.getInventory().addItem(GHook);
		}
	}
		public void GHookRecipe() {
			
			NamespacedKey nsKey = new NamespacedKey(plugin, "ghook");
			ShapedRecipe r = new ShapedRecipe(nsKey, GHook);
			String basePath = "Items.GrapplingHook.Recipe.";
			String wordToDescribeNothing = "NOTHING";
			String[] ingredientNames = {
			
					this.plugin.getConfig().getString(basePath + "TopLeft"),
					this.plugin.getConfig().getString(basePath + "TopMid"),
					this.plugin.getConfig().getString(basePath + "TopRight"),
					this.plugin.getConfig().getString(basePath + "MidLeft"),
					this.plugin.getConfig().getString(basePath + "Mid"),
					this.plugin.getConfig().getString(basePath + "MidRight"),
					this.plugin.getConfig().getString(basePath + "BottomLeft"),
					this.plugin.getConfig().getString(basePath + "BottomMid"),
					this.plugin.getConfig().getString(basePath + "BottomRight"),
				};
			
			char[] recipeLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
			for (int x = 0; x < ingredientNames.length; x++) {
				if (ingredientNames[x].equals(wordToDescribeNothing)) {
					recipeLetters[x] = ' ';
				}
		
		}

	}

		

