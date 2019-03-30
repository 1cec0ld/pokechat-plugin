package com.gmail.ak1cec0ld.plugins.pokestring.deathmessages;

import com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.listeners.DeathListener;

public class DeathMessages {
    public DeathMessages(){
        enableListeners();
        cleanToggleFile();
    }

    private void enableListeners(){
        new DeathListener();
    }
    
    private void cleanToggleFile(){
        new DeathMessageToggleFile();
    }
}
