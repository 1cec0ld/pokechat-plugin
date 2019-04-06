package com.gmail.ak1cec0ld.plugins.pokestring.customlogs.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import com.gmail.ak1cec0ld.plugins.pokestring.customlogs.LogFile;

public class JoinListener implements Listener{
    public JoinListener(){
        Pokestring.instance().getServer().getPluginManager().registerEvents(this, Pokestring.instance());
    }
    
    
    
    @EventHandler
    public void onQuit(PlayerJoinEvent event){
        event.setJoinMessage(LogFile.getLogin(event.getPlayer()));
    }
}