package com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.listeners;

import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.DeathMessageToggleFile;

public class CommandListener implements CommandExecutor {
    private static String COMMAND_ALIAS = "toggledeath";
    public CommandListener(){
        Pokestring.instance().getCommand(COMMAND_ALIAS).setExecutor(this);
    }

    private void messageSenderStatus(Player target, Boolean hiding){
        target.sendMessage("§eTurned " +(hiding?"off":"on")+ " death messages");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player))return false;
        Player player = (Player)sender;
        if(DeathMessageToggleFile.contains(player.getUniqueId().toString())){
            DeathMessageToggleFile.removePlayer(player.getUniqueId().toString());
            messageSenderStatus(player, false);
        } else {
            DeathMessageToggleFile.setPlayer(player.getUniqueId().toString());
            messageSenderStatus(player,true);
        }
        return true;
    }
}
