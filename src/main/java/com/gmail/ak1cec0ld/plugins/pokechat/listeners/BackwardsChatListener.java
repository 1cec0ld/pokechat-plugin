package com.gmail.ak1cec0ld.plugins.pokechat.listeners;

import com.gmail.ak1cec0ld.plugins.pokechat.Pokechat;
import com.gmail.ak1cec0ld.plugins.pokechat.Mutator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BackwardsChatListener implements Listener {

    public BackwardsChatListener(Pokechat pokechat){
        pokechat.getServer().getPluginManager().registerEvents(this,pokechat);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        if(wantsBackwards(event.getPlayer())){
            event.setMessage(Mutator.backwards(event.getMessage()));
        }
    }


    private boolean wantsBackwards(Player sender){
        if(sender.hasMetadata("backwardschat")) {
            return Boolean.TRUE.equals(sender.getMetadata("backwardschat").get(0).asBoolean());
        }
        return false;
    }
}
