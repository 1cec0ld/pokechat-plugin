package com.gmail.ak1cec0ld.plugins.pokestring.pokechat;

import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import com.gmail.ak1cec0ld.plugins.pokestring.pokechat.listeners.ChatListener;
import com.gmail.ak1cec0ld.plugins.pokestring.pokechat.listeners.CommandListener;
import org.bukkit.entity.Player;


public class Pokechat {
    private static Pokestring plugin;
    public Pokechat(Pokestring pokestring){
        this.plugin = pokestring;
        enableListeners();
    }



    private void enableListeners(){

        new CommandListener(this);
        new ChatListener();
    }
    public static boolean wants(String metadata, Player sender){
        return sender.hasMetadata(metadata);
    }
    public static Pokestring getPlugin(){
        return plugin;
    }
}
