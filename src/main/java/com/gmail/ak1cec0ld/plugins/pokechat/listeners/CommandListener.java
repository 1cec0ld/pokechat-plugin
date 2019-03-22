package com.gmail.ak1cec0ld.plugins.pokechat.listeners;

import com.gmail.ak1cec0ld.plugins.pokechat.Mutators.JapanMutator;
import com.gmail.ak1cec0ld.plugins.pokechat.Mutators.PlainTextMutator;
import com.gmail.ak1cec0ld.plugins.pokechat.Mutators.UpsidedownMutator;
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
    private static String COMMAND_ALIAS = "chat";
    private static String[] COMMAND_ALIASES = {"chattoggle"};



    private LinkedHashMap<String, Argument> arguments;

    public CommandListener(Pokechat pokechat){
        initializeArguments();
        this.plugin = pokechat;
    }
    private void initializeArguments(){
        Set<String> arg1s = new HashSet<String>(Arrays.asList("b", "backwards", "j", "japanese", "u", "upsidedown", "s", "scrambled"));
        for(String selection : arg1s){
            arguments = new LinkedHashMap<String, Argument>();
            arguments.put("selection", new LiteralArgument(selection));
            registerChatCommand(selection);
            arguments.put("rest", new GreedyStringArgument());
            registerChatCommand(selection);
        }
    }

    private void registerChatCommand(String selection){
        CommandAPI.getInstance().register(COMMAND_ALIAS, CommandPermission.NONE, COMMAND_ALIASES, arguments, (sender,args) -> {
            if(selection.startsWith("b")){
                if(args.length == 0){
                    toggleMetadata((Player)sender, "backwardschat");
                } else {
                    ((Player)sender).chat(PlainTextMutator.backwards(args[0].toString()));
                }
            } else if(selection.startsWith("s")){
                if(args.length == 0){
                    toggleMetadata((Player)sender, "scramblechat");
                } else {
                    ((Player)sender).chat(PlainTextMutator.scramble(args[0].toString()));
                }
            } else if(selection.startsWith("j")){
                if(args.length == 0){
                    toggleMetadata((Player)sender, "japanesechat");
                } else {
                    ((Player)sender).chat(JapanMutator.toJapanese(args[0].toString()));
                }
            } else if(selection.startsWith("u")){
                if(args.length == 0){
                    toggleMetadata((Player)sender, "upsidedownchat");
                } else {
                    ((Player)sender).chat(UpsidedownMutator.toUpsidedown(args[0].toString()));
                }
            }
        });
    }
    private void toggleMetadata(Player player, String metadataName){
        if(player.hasMetadata(metadataName)){
            player.removeMetadata(metadataName,plugin);
        } else {
            player.setMetadata(metadataName, new FixedMetadataValue(plugin, true));
        }
    }
}
