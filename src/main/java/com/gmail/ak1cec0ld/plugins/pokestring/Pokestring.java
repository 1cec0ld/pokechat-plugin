package com.gmail.ak1cec0ld.plugins.pokestring;

import com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.DeathMessages;
import com.gmail.ak1cec0ld.plugins.pokestring.modchat.Modchat;
import com.gmail.ak1cec0ld.plugins.pokestring.pokechat.Pokechat;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

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
    }

    public static void debug(String levelString, String message){
        instance().getLogger().log(Level.parse(levelString.toUpperCase()), message);
    }
}
