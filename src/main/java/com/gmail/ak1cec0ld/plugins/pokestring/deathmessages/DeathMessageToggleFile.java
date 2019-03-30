package com.gmail.ak1cec0ld.plugins.pokestring.deathmessages;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.ak1cec0ld.plugins.pokestring.CustomYMLStorage;
import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;

public class DeathMessageToggleFile {
    private static CustomYMLStorage yml;
    private static YamlConfiguration storage;
    //private static final long ONE_MONTH = 1000*60*60*24*28; 

    public DeathMessageToggleFile(){
        yml = new CustomYMLStorage(Pokestring.instance(), "deathMessageDisabledPeople.yml", Pokestring.instance().getDataFolder().getName());
        storage = yml.getYamlConfiguration();
        yml.save();
        clean(1000*60*10);
    }

    private void clean(long timeout) {
        final long current = System.currentTimeMillis();
        for(String uuid : storage.getKeys(false)){
            if(current - storage.getLong(uuid) > timeout){
                storage.set(uuid, null);
            }
        }
        yml.save();
    }
    
    public static boolean contains(String uuid){
        return storage.contains(uuid);
    }
    public static void setPlayer(String uuid){
        storage.set(uuid, System.currentTimeMillis());
        yml.save();
    }
    public static void removePlayer(String uuid){
        storage.set(uuid, null);
        yml.save();
    }
}
