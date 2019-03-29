package com.gmail.ak1cec0ld.plugins.pokestring.pokechat;

import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import com.gmail.ak1cec0ld.plugins.pokestring.pokechat.listeners.ChatListener;
import com.gmail.ak1cec0ld.plugins.pokestring.pokechat.listeners.CommandListener;
import org.bukkit.entity.Player;


public class Pokechat {
    private static Pokestring plugin;
    public Pokechat() {
        enableListeners();
    }

    private void enableListeners(){
        new CommandListener();
        new ChatListener();
    }
    public static boolean wants(String metadata, Player sender){
        return sender.hasMetadata(metadata);
    }
}
