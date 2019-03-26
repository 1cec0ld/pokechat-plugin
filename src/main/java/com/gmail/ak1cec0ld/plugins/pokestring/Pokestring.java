package com.gmail.ak1cec0ld.plugins.pokestring;

import com.gmail.ak1cec0ld.plugins.pokestring.pokechat.Pokechat;
import org.bukkit.plugin.java.JavaPlugin;

public class Pokestring extends JavaPlugin {

    private Pokestring plugin;

    public void onEnable(){
        this.plugin = this;
        enableModules();
    }



    private void enableModules(){

        new Pokechat(this);
    }
}
