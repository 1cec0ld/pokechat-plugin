package com.gmail.ak1cec0ld.plugins.pokestring;

import com.gmail.ak1cec0ld.plugins.pokestring.mobdeath.Mobdeath;
import com.gmail.ak1cec0ld.plugins.pokestring.pokechat.Pokechat;
import org.bukkit.plugin.java.JavaPlugin;

public class Pokestring extends JavaPlugin {

    private static Pokestring plugin;

    public void onEnable(){
        this.plugin = this;
        enableModules();
    }

    public static Pokestring instance(){
        return plugin;
    }

    private void enableModules(){
        new Pokechat();
        new Mobdeath();
    }

}
