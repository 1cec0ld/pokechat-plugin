package com.gmail.ak1cec0ld.plugins.pokestring.modchat.listeners;

import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.ak1cec0ld.plugins.pokestring.modchat.ModChatFile;

import net.md_5.bungee.api.ChatColor;

public class CommandListener implements CommandExecutor {
    private static final String COMMAND_ALIAS = "mc";

    public CommandListener(){
        Pokestring.instance().getServer().getPluginCommand(COMMAND_ALIAS).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        switch(args.length){
            case 0:
                if(!(sender instanceof Player))return false;
                String uuid = ((Player)sender).getUniqueId().toString();
                if(!sender.hasPermission("modchat"))return false;
                if(ModChatFile.isOn(uuid)){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cTurned Modchat Off"));
                    ModChatFile.remove(uuid);
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cTurned Modchat On"));
                    ModChatFile.turnOn(uuid);
                }
                break;
            default:
                String rest = String.join(" ", args);
                if(!sender.hasPermission("modchat"))return false;
                ChatListener.sendAsModchat(sender.getName(), rest);
        }
        return true;
    }
}
