package com.gmail.ak1cec0ld.plugins.pokestring.pokechat.listeners;

import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import com.gmail.ak1cec0ld.plugins.pokestring.pokechat.Pokechat;
import com.gmail.ak1cec0ld.plugins.pokestring.pokechat.mutators.JapanMutator;
import com.gmail.ak1cec0ld.plugins.pokestring.pokechat.mutators.PlainTextMutator;
import com.gmail.ak1cec0ld.plugins.pokestring.pokechat.mutators.UpsidedownMutator;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Arrays;

public class CommandListener implements CommandExecutor {

    private static final String COMMAND_ALIAS = "chat";


    public CommandListener(){
        Pokestring.instance().getServer().getPluginCommand(COMMAND_ALIAS).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player))return false;
        Player player = (Player)commandSender;
        switch(args.length){
            case 0:
                messagePlayerOptions(player);
                break;
            case 1:
                switch(args[0].toLowerCase()){
                    case "b":
                    case "back":
                    case "backwards":
                        toggleMetadata(player, "backwardschat");
                        messagePlayerOptions(player);
                        break;
                    case "j":
                    case "japan":
                    case "japanese":
                        toggleMetadata(player, "japanesechat");
                        messagePlayerOptions(player);
                        break;
                    case "u":
                    case "upside":
                    case "upsidedown":
                        toggleMetadata(player, "upsidedownchat");
                        messagePlayerOptions(player);
                        break;
                    case "s":
                    case "scramble":
                    case "scrambled":
                        toggleMetadata(player, "scramblechat");
                        messagePlayerOptions(player);
                        break;
                }
            default:
                String rest = String.join(" ", Arrays.copyOfRange(args,1,args.length));
                switch(args[0].toLowerCase()){
                    case "b":
                    case "back":
                    case "backwards":
                        player.chat(PlainTextMutator.backwards(rest));
                        break;
                    case "j":
                    case "japan":
                    case "japanese":
                        player.chat(JapanMutator.toJapanese(rest));
                        break;
                    case "u":
                    case "upside":
                    case "upsidedown":
                        player.chat(UpsidedownMutator.toUpsidedown(rest));
                        break;
                    case "s":
                    case "scramble":
                    case "scrambled":
                        player.chat(PlainTextMutator.scramble(rest));
                        break;
                }
        }
        return true;
    }

    private void toggleMetadata(Player player, String metadataName){
        if(player.hasMetadata(metadataName)){
            player.removeMetadata(metadataName, Pokestring.instance());
        } else {
            player.setMetadata(metadataName, new FixedMetadataValue(Pokestring.instance(), true));
        }
    }

    private void messagePlayerOptions(Player target){
        target.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&aBackwards Text: "+ (Pokechat.wants("backwardschat",target)?"&bOn":"&cOff")));
        target.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&aJapanese Text: "+ (Pokechat.wants("japanesechat",target)?"&bOn":"&cOff")));
        target.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&aScrambled Text: "+ (Pokechat.wants("scramblechat",target)?"&bOn":"&cOff")));
        target.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&aUpsidedown Text: "+ (Pokechat.wants("upsidedownchat",target)?"&bOn":"&cOff")));
    }

}
