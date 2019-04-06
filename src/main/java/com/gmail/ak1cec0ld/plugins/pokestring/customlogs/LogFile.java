package com.gmail.ak1cec0ld.plugins.pokestring.customlogs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.ak1cec0ld.plugins.pokestring.CustomYMLStorage;
import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;

public class LogFile {

    private static CustomYMLStorage yml;
    private static YamlConfiguration storage;
    
    
    public LogFile(){
        yml = new CustomYMLStorage(Pokestring.instance(), "loginoutFile.yml", Pokestring.instance().getDataFolder().getName());
        storage = yml.getYamlConfiguration();
        yml.save();
    }
    
    public static String getLogin(Player player){
    	String custom = storage.getString(player.getUniqueId().toString()+".login",
    					storage.getString("default."+player.getWorld().getName()+".login",
						"&eSomeone joined the game."));
    	Bukkit.getLogger().info(custom);
        return custom.replace('&', ChatColor.COLOR_CHAR).replace("%player%", player.getName());
    }
    public static String getLogout(Player player){
    	String custom = storage.getString(player.getUniqueId().toString()+".logout",
						storage.getString("default."+player.getWorld().getName()+".logout",
						"&eSomeone left the game."));
    	return custom.replace('&', ChatColor.COLOR_CHAR).replace("%player%", player.getName());     
    }
    public static void setLogin(Player player, String message){
        storage.set(player.getUniqueId().toString()+".login", message);
        yml.save();
    }
    public static void setLogout(Player player, String message){
        storage.set(player.getUniqueId().toString()+".logout", message);
        yml.save();
    }
    public static void removeLogin(Player player){
        storage.set(player.getUniqueId().toString()+".login", null);
    }
    public static void removeLogout(Player player){
        storage.set(player.getUniqueId().toString()+".logout", null);
    }
}
