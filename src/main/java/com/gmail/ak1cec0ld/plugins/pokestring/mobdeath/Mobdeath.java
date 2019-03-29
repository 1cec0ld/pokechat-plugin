package com.gmail.ak1cec0ld.plugins.pokestring.mobdeath;

import com.gmail.ak1cec0ld.plugins.pokestring.mobdeath.listeners.DeathListener;

public class Mobdeath {
    public Mobdeath(){
        enableListeners();
    }

    private void enableListeners(){
        new DeathListener();
    }
}
