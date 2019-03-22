package com.gmail.ak1cec0ld.plugins.pokechat;

import com.gmail.ak1cec0ld.plugins.pokechat.listeners.ChatListener;
import com.gmail.ak1cec0ld.plugins.pokechat.listeners.CommandListener;
import org.bukkit.plugin.java.JavaPlugin;


public class Pokechat extends JavaPlugin {


    private Pokechat plugin;

    public void onEnable(){
        this.plugin = this;
        enableListeners();
    }



    private void enableListeners(){

        new CommandListener(this);
        new ChatListener(this);
    }

}
