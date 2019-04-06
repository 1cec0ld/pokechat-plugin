package com.gmail.ak1cec0ld.plugins.pokestring.modchat.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import com.gmail.ak1cec0ld.plugins.pokestring.modchat.ModChatFile;

public class ChatListener implements Listener{
    
    public ChatListener(){
        Pokestring.instance().getServer().getPluginManager().registerEvents(this, Pokestring.instance());
    }
    
    
    @EventHandler
    public void onAsyncChat(AsyncPlayerChatEvent event){
        if(!event.getPlayer().hasPermission("modchat"))return;
        if(!ModChatFile.isOn(event.getPlayer().getUniqueId().toString()))return;
        event.setCancelled(true);

        sendAsModchat(event.getPlayer().getName(), event.getMessage());

    }
    
    public static void sendAsModchat(String senderName, String message){
        String msg = message.replaceAll("&([0-9a-fk-or])","§\\1");
        Pokestring.debug("info", msg);
        for(Player mod : Pokestring.instance().getServer().getOnlinePlayers()){
            if(mod.hasPermission("modchat")){
                mod.sendMessage("§0[§4Mod§cChat§0]§f"+senderName+ ": §d" + msg);
            }
        }
    }
}
