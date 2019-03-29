package com.gmail.ak1cec0ld.plugins.pokestring.mobdeath.listeners;

import com.gmail.ak1cec0ld.plugins.pokestring.CustomYMLStorage;
import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;

public class DeathListener implements Listener {
    private HashMap<String, String> loaded;

    public DeathListener(){
        Pokestring.instance().getServer().getPluginManager().registerEvents(this, Pokestring.instance());
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        EntityDamageEvent damageEvent = event.getEntity().getLastDamageCause();
        String damageType = "";
        String attackerType = "";
        if(damageEvent instanceof EntityDamageByEntityEvent){

        }
        Bukkit.getScheduler().runTaskAsynchronously(Pokestring.instance(), () -> {
            messageDeathToPeople(event.getEntity());
        });
    }
    private void messageDeathToPeople(Player entity){

    }
    private HashMap<String, String> loadMessages(){
        loaded = new HashMap<String,String>();
        CustomYMLStorage yml = new CustomYMLStorage(Pokestring.instance(), "deathMessages.yml",Pokestring.instance().getDataFolder().getName());
        YamlConfiguration storage = yml.getYamlConfiguration();
        for(String damageType : storage.getKeys(false)){
            loaded.put(damageType,storage.getString(damageType));
        }


        return loaded;
    }
}
