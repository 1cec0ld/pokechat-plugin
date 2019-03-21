package com.gmail.ak1cec0ld.plugins.pokechat.listeners;

import com.gmail.ak1cec0ld.plugins.pokechat.Mutator;
import com.gmail.ak1cec0ld.plugins.pokechat.Pokechat;
import io.github.jorelali.commandapi.api.CommandAPI;
import io.github.jorelali.commandapi.api.CommandPermission;
import io.github.jorelali.commandapi.api.arguments.Argument;
import io.github.jorelali.commandapi.api.arguments.GreedyStringArgument;
import io.github.jorelali.commandapi.api.arguments.LiteralArgument;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class CommandListener{

    private Pokechat plugin;
    private String COMMAND_ALIAS = "chat";
    private String[] COMMAND_ALIASES = {"chattoggle"};



    private LinkedHashMap<String, Argument> arguments;
    private Set<String> arg1s;

    public CommandListener(Pokechat pokechat){
        initializeArguments();
        this.plugin = pokechat;
    }
    private void initializeArguments(){
        arg1s = new HashSet<String>(Arrays.asList("b","backwards","j","japanese","u","upsidedown","s","scrambled"));
        for(String selection : arg1s){
            arguments = new LinkedHashMap<String, Argument>();
            arguments.put("selection", new LiteralArgument(selection));
            arguments.put("rest", new GreedyStringArgument());
            registerChatCommand(selection);
        }
    }

    private void registerChatCommand(String selection){
        CommandAPI.getInstance().register(COMMAND_ALIAS, CommandPermission.NONE, COMMAND_ALIASES, arguments, (sender,args) -> {
            if(selection.startsWith("b")){
                if(args.length == 0){
                    Boolean isBackwards = Boolean.TRUE.equals(((Player)sender).getMetadata("backwardschat").get(0).asBoolean());
                    ((Player)sender).setMetadata("backwardschat",new FixedMetadataValue(plugin, !isBackwards));
                } else {
                    ((Player)sender).chat(Mutator.backwards(args[0].toString()));
                }
            }
        });
    }
}
