package com.gmail.ak1cec0ld.plugins.pokestring.customlogs.listeners;

import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import com.gmail.ak1cec0ld.plugins.pokestring.customlogs.LogFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class CommandListener implements CommandExecutor {

    private static final String COMMAND_ALIAS = "cm";

    public CommandListener(){
		Pokestring.instance().getServer().getPluginCommand(COMMAND_ALIAS).setExecutor(this);
    }


	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
    	if(!commandSender.hasPermission("custommessage"))return false;
		switch(args.length){
			case 3:
				switch(args[1]){
					case "get":
					case "remove":
						switch(args[2]){
							case "login":
								actOnLogin(args[1],commandSender,args[0], "");
								break;
							case "logout":
								actOnLogout(args[1],commandSender,args[0], "");
								break;
							default:
								commandSender.sendMessage("Error, no log type found");
						}
						break;
					default:
						commandSender.sendMessage("Error, not a valid action");
				}
				break;
			case 0:
				break;
			default:
				switch(args[1]){
					case "set":
						String text = String.join(" ", Arrays.copyOfRange(args, 3, args.length));
						switch(args[2]){
							case "login":
								actOnLogin(args[1],commandSender,args[0], text);
								break;
							case "logout":
								actOnLogout(args[1],commandSender,args[0], text);
								break;
						}
						break;
					default:
						commandSender.sendMessage("Error, not a valid action");
				}
		}
		return true;
	}

	private void actOnLogin(String action, CommandSender sender, String args, String args2) {
    	Player player = Pokestring.getPlayerFromString(args);
    	if(player == null)return;
    	switch(action) {
        	case "get":
        		sender.sendMessage(LogFile.getLogin(player));
        		break;
        	case "set":
        		sender.sendMessage("Message set!");
        		LogFile.setLogin(player, args2);
        		break;
        	case "remove":
        		sender.sendMessage("Message removed!");
        		LogFile.removeLogin(player);
        		break;
        	default:
        		sender.sendMessage("Error, no action found");
    	}
	}
	private void actOnLogout(String action, CommandSender sender, String args, String args2) {
		Player player = Pokestring.getPlayerFromString(args);
		if(player == null)return;
    	switch(action) {
	    	case "get":
	    		sender.sendMessage(LogFile.getLogout(player));
	    		break;
	    	case "set":
        		sender.sendMessage("Message set!");
	    		LogFile.setLogout(player, args2);
	    		break;
	    	case "remove":
        		sender.sendMessage("Message removed!");
	    		LogFile.removeLogout(player);
	    		break;
			default:
				sender.sendMessage("Error, no action found");
    	}
	}

}
