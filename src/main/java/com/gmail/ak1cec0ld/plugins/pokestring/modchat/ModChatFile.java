package com.gmail.ak1cec0ld.plugins.pokestring.modchat;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.ak1cec0ld.plugins.pokestring.CustomYMLStorage;
import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;

public class ModChatFile {
    private static CustomYMLStorage yml;
    private static YamlConfiguration storage;
    

    public ModChatFile(){
        yml = new CustomYMLStorage(Pokestring.instance(), "modChatOn.yml", Pokestring.instance().getDataFolder().getName());
        storage = yml.getYamlConfiguration();
        yml.save();
        clean(24*60*60*1000L);
    }


    public void clean(long timeout) {
        final long current = System.currentTimeMillis();
        for(String uuid : storage.getKeys(false)){
            if(current - storage.getLong(uuid) > timeout){
                storage.set(uuid, null);
            }
        }
        yml.save();
    }
    
    public static Boolean isOn(String uuid){
        return storage.contains(uuid);
    }
    
    public static void remove(String uuid){
        storage.set(uuid, null);
        yml.save();
    }
    public static void turnOn(String uuid){
        storage.set(uuid, System.currentTimeMillis());
        yml.save();
    }
    
}
