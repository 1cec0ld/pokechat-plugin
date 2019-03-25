package com.gmail.ak1cec0ld.plugins.pokechat.listeners;

import com.gmail.ak1cec0ld.plugins.pokechat.Mutators.JapanMutator;
import com.gmail.ak1cec0ld.plugins.pokechat.Mutators.UpsidedownMutator;
import com.gmail.ak1cec0ld.plugins.pokechat.Pokechat;
import com.gmail.ak1cec0ld.plugins.pokechat.Mutators.PlainTextMutator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    public ChatListener(Pokechat pokechat){
        pokechat.getServer().getPluginManager().registerEvents(this,pokechat);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        if(Pokechat.wants("japanesechat",event.getPlayer())){
            event.setMessage(JapanMutator.toJapanese(event.getMessage()));
        } else if(Pokechat.wants("upsidedownchat",event.getPlayer())){
            event.setMessage(UpsidedownMutator.toUpsidedown(event.getMessage()));
        }
        if(Pokechat.wants("scramblechat",event.getPlayer())){
            event.setMessage(PlainTextMutator.scramble(event.getMessage()));
        } else if(Pokechat.wants("backwardschat",event.getPlayer())){
            event.setMessage(PlainTextMutator.backwards(event.getMessage()));
        }
    }

}
