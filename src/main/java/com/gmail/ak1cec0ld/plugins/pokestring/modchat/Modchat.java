package com.gmail.ak1cec0ld.plugins.pokestring.modchat;

import com.gmail.ak1cec0ld.plugins.pokestring.modchat.listeners.ChatListener;
import com.gmail.ak1cec0ld.plugins.pokestring.modchat.listeners.CommandListener;

public class Modchat {
    
    public Modchat(){
        initialize();
    }
    
    private void initialize(){
        new ModChatFile();
        new ChatListener();
        new CommandListener();
    }

}
