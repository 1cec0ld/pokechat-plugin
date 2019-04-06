package com.gmail.ak1cec0ld.plugins.pokestring.customlogs.listeners;

import com.gmail.ak1cec0ld.plugins.pokestring.customlogs.LogFile;
import io.github.jorelali.commandapi.api.CommandAPI;
import io.github.jorelali.commandapi.api.CommandPermission;
import io.github.jorelali.commandapi.api.arguments.Argument;
import io.github.jorelali.commandapi.api.arguments.GreedyStringArgument;
import io.github.jorelali.commandapi.api.arguments.LiteralArgument;
import io.github.jorelali.commandapi.api.arguments.PlayerArgument;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class CommandListener{

    private static String COMMAND_ALIAS = "cm";
    private static String[] COMMAND_ALIASES = {"custommessage"};


    private LinkedHashMap<String, Argument> arguments;

    public CommandListener(){
        initializeArguments();
    }
    private void initializeArguments(){
    	Set<String> literal1s = new HashSet<String>(Arrays.asList("get","remove"));
    	Set<String> literal2s = new HashSet<String>(Arrays.asList("login","logout"));
        for(String getremove : literal1s){
        	for(String loginlogout : literal2s) {
                arguments = new LinkedHashMap<String, Argument>();
                arguments.put("who", new PlayerArgument());
        		arguments.put("action", new LiteralArgument(getremove));
        		arguments.put("log", new LiteralArgument(loginlogout));
        		registerShortCommand(getremove,loginlogout);
        	}
        }

    	for(String loginlogout : literal2s) {
            arguments = new LinkedHashMap<String, Argument>();
            arguments.put("who", new PlayerArgument());
    		arguments.put("action", new LiteralArgument("set"));
    		arguments.put("log", new LiteralArgument(loginlogout));
    		arguments.put("msg", new GreedyStringArgument());
    		registerLongCommand("set",loginlogout);
    	}
    }

    private void registerLongCommand(String action, String log){
        CommandAPI.getInstance().register(COMMAND_ALIAS, CommandPermission.fromString("custommessage"), COMMAND_ALIASES, arguments, (sender,args) -> {
        	switch(log) {
	        	case "login":
	        		actOnLogin(action,sender,args[0], args[1]);
	        		break;
	        	case "logout":
	        		actOnLogout(action,sender,args[0], args[1]);
	        		break;
	        	default:
	        		sender.sendMessage("Error, no log type found");
        	}
        });
    }
    private void registerShortCommand(String action, String log) {
        CommandAPI.getInstance().register(COMMAND_ALIAS, CommandPermission.fromString("custommessage"), COMMAND_ALIASES, arguments, (sender,args) -> {
        	switch(log) {
	        	case "login":
	        		actOnLogin(action,sender,args[0], "");
	        		break;
	        	case "logout":
	        		actOnLogout(action,sender,args[0], "");
	        		break;
	        	default:
	        		sender.sendMessage("Error, no log type found");
        	}
        });
    }
	private void actOnLogin(String action, CommandSender sender, Object args, Object args2) {
    	switch(action) {
        	case "get":
        		sender.sendMessage(LogFile.getLogin((Player)args));
        		break;
        	case "set":
        		sender.sendMessage("Message set!");
        		LogFile.setLogin((Player)args, args2.toString());
        		break;
        	case "remove":
        		sender.sendMessage("Message removed!");
        		LogFile.removeLogin((Player)args);
        		break;
        	default:
        		sender.sendMessage("Error, no action found");
    	}
	}
	private void actOnLogout(String action, CommandSender sender, Object args, Object args2) {
    	switch(action) {
	    	case "get":
	    		sender.sendMessage(LogFile.getLogout((Player)args));
	    		break;
	    	case "set":
        		sender.sendMessage("Message set!");
	    		LogFile.setLogout((Player)args, args2.toString());
	    		break;
	    	case "remove":
        		sender.sendMessage("Message removed!");
	    		LogFile.removeLogout((Player)args);
	    		break;
    	}
	}
}
