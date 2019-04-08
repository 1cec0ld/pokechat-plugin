package com.gmail.ak1cec0ld.plugins.pokestring.customlogs.listeners;

import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import com.gmail.ak1cec0ld.plugins.pokestring.customlogs.LogFile;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener{
    public JoinListener(){
        Pokestring.instance().getServer().getPluginManager().registerEvents(this, Pokestring.instance());
    }
    
    
    
    @EventHandler
    public void onQuit(PlayerJoinEvent event){
        TextComponent message = new TextComponent(LogFile.getLogin(event.getPlayer()));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(event.getPlayer().getName()+" joined the game.").create()));
        event.setJoinMessage(null);
        for(Player each : Bukkit.getServer().getOnlinePlayers()){
            each.spigot().sendMessage(message);
        }
    }
}