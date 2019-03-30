package com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.listeners;

import java.util.LinkedHashMap;

import org.bukkit.entity.Player;

import com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.DeathMessageToggleFile;

import io.github.jorelali.commandapi.api.CommandAPI;
import io.github.jorelali.commandapi.api.CommandPermission;
import io.github.jorelali.commandapi.api.arguments.Argument;

public class CommandListener {
    private static String COMMAND_ALIAS = "toggledeath";
    private static String[] COMMAND_ALIASES = {"deathtoggle"};
    
    private LinkedHashMap<String, Argument> arguments;
    
    public CommandListener(){
        registerCommand();
    }
    
    private void registerCommand(){
        CommandAPI.getInstance().register(COMMAND_ALIAS, CommandPermission.NONE, COMMAND_ALIASES,arguments, (sender,args) -> {
            if(!(sender instanceof Player))return;
            Player player = (Player)sender;
            if(DeathMessageToggleFile.contains(player.getUniqueId().toString())){
                DeathMessageToggleFile.removePlayer(player.getUniqueId().toString());
                messageSenderStatus(player, false);
            } else {
                DeathMessageToggleFile.setPlayer(player.getUniqueId().toString());
                messageSenderStatus(player,true);
            }
        });
    }
    private void messageSenderStatus(Player target, Boolean hiding){
        target.sendMessage("§eTurned " +(hiding?"off":"on")+ " death messages");
    }
}
