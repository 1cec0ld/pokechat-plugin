package com.gmail.ak1cec0ld.plugins.pokestring.modchat.listeners;

import java.util.LinkedHashMap;

import org.bukkit.entity.Player;

import com.gmail.ak1cec0ld.plugins.pokestring.modchat.ModChatFile;

import io.github.jorelali.commandapi.api.CommandAPI;
import io.github.jorelali.commandapi.api.CommandPermission;
import io.github.jorelali.commandapi.api.arguments.Argument;
import io.github.jorelali.commandapi.api.arguments.GreedyStringArgument;

public class CommandListener {
    private static String COMMAND_ALIAS = "modchat";
    private static String[] COMMAND_ALIASES = {"mc"};



    private LinkedHashMap<String, Argument> arguments;
    public CommandListener(){
        
        initializeArguments();
    }
    private void initializeArguments(){
        arguments = new LinkedHashMap<String, Argument>();
        registerCommandAlone();
        arguments.put("rest", new GreedyStringArgument());
        registerCommandGreedy();
    }
    private void registerCommandAlone(){
        CommandAPI.getInstance().register(COMMAND_ALIAS, CommandPermission.NONE, COMMAND_ALIASES, arguments, (sender,args) -> {
            if(sender instanceof Player){
                String uuid = ((Player)sender).getUniqueId().toString();
                if(sender.hasPermission("modchat")){
                    if(ModChatFile.isOn(uuid)){
                        ModChatFile.remove(uuid);
                    } else {
                        ModChatFile.turnOn(uuid);
                    }
                }
            }
        });
    }
    
    private void registerCommandGreedy(){
        CommandAPI.getInstance().register(COMMAND_ALIAS, CommandPermission.NONE, COMMAND_ALIASES, arguments, (sender,args) -> {
            if(sender.hasPermission("modchat")){
                ChatListener.sendAsModchat(sender.getName(), args[0].toString());
            }
        });
    }
}
