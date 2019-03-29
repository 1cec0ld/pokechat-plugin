package com.gmail.ak1cec0ld.plugins.pokestring.mobdeath.listeners;

import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.*;
import org.apache.commons.*;
import java.util.HashMap;

public class DeathListener implements Listener {

    public DeathListener(){
        Pokestring.instance().getServer().getPluginManager().registerEvents(this, Pokestring.instance());
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        EntityDamageEvent damageEvent = event.getEntity().getLastDamageCause();
        Damage
        if(damageEvent instanceof EntityDamageByEntityEvent){

        }
        Bukkit.getScheduler().runTaskAsynchronously(Pokestring.instance(), () -> {
            messageDeathToPeople();
        });
    }
    private void messageDeathToPeople(Player entity){
        String message = getMessage
    }
    private HashMap<String, String> loadMessages(){
        HashMap<String, String> loaded = new HashMap<String,String>();
        File deathFile = new File(Pokestring.instance().getDataFolder()+File.separator+"deathMessages.yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(deathFile);

        if(!deathFile.exists()){
            yml.options().copyDefaults(true);
            try{
                yml.save(deathFile);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        try{
            InputStream in = Pokestring.instance().getResource("deathMessages.yml");
            OutputStream out = new FileOutputStream(deathFile);
            in.transferTo(out);

        }catch(IOException e){

        }

        return loaded;
    }
}
