package com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.DeathMessageToggleFile;

public class PlayerJoinListener implements Listener{
    
    public PlayerJoinListener(){
        Pokestring.instance().getServer().getPluginManager().registerEvents(this, Pokestring.instance());
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Pokestring.instance().getServer().getScheduler().runTaskAsynchronously(Pokestring.instance(), () -> {
            if(DeathMessageToggleFile.contains(event.getPlayer().getUniqueId().toString())){
                DeathMessageToggleFile.setPlayer(event.getPlayer().getUniqueId().toString());
            }
        });
    }
}
