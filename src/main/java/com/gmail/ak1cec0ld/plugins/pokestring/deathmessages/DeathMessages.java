package com.gmail.ak1cec0ld.plugins.pokestring.deathmessages;

import com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.listeners.DeathListener;
import com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.listeners.CommandListener;
import com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.listeners.PlayerJoinListener;

public class DeathMessages {
    public DeathMessages(){
        enableListeners();
        new DeathMessageToggleFile();
    }

    private void enableListeners(){
        new CommandListener();
        new DeathListener();
        new PlayerJoinListener();
    }
}
