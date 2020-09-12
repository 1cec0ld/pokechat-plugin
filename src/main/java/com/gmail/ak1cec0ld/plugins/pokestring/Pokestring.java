package com.gmail.ak1cec0ld.plugins.pokestring;

import com.gmail.ak1cec0ld.plugins.pokestring.customlogs.CustomLog;
import com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.DeathMessages;
import com.gmail.ak1cec0ld.plugins.pokestring.modchat.Modchat;
import com.gmail.ak1cec0ld.plugins.pokestring.pokechat.Pokechat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Pokestring extends JavaPlugin {

    private static Pokestring plugin;

    public void onEnable(){
        plugin = this;
        enableModules();
    }

    public static Pokestring instance(){
        return plugin;
    }

    private void enableModules(){
        new Pokechat();
        new DeathMessages();
        new Modchat();
        new CustomLog();
    }

    public static void debug(String levelString, String message){
        instance().getLogger().log(Level.parse(levelString.toUpperCase()), message);
    }

    public static Player getPlayerFromString(String string) {
        for(Player p : Bukkit.getOnlinePlayers()){
            if(p.getName().toLowerCase().startsWith(string.toLowerCase())){
                return p;
            }
        }
        return null;
    }
}
