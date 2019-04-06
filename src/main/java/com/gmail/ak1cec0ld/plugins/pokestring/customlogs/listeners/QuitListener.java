package com.gmail.ak1cec0ld.plugins.pokestring.customlogs.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import com.gmail.ak1cec0ld.plugins.pokestring.customlogs.LogFile;

public class QuitListener implements Listener{
    public QuitListener(){
        Pokestring.instance().getServer().getPluginManager().registerEvents(this, Pokestring.instance());
    }
    
    
    
    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        event.setQuitMessage(LogFile.getLogout(event.getPlayer()));
    }
}
