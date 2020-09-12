package com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.listeners;

import com.gmail.ak1cec0ld.plugins.pokestring.CustomYMLStorage;
import com.gmail.ak1cec0ld.plugins.pokestring.Pokestring;
import com.gmail.ak1cec0ld.plugins.pokestring.deathmessages.DeathMessageToggleFile;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

public class DeathListener implements Listener {
    private HashMap<String, String> messages;

    public DeathListener(){
        Pokestring.instance().getServer().getPluginManager().registerEvents(this, Pokestring.instance());
        messages = loadMessages();
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        EntityDamageEvent damageEvent = event.getEntity().getLastDamageCause();
        String HPValue = "∞";
        String attackerName = "-";
        String attackerType = "-";
        String damageType = "-";
        String deathMessage = "";
        if(damageEvent instanceof EntityDamageByEntityEvent){
            EntityDamageByEntityEvent event_EE = (EntityDamageByEntityEvent)damageEvent;
            Entity attacker = event_EE.getDamager();
            if(attacker instanceof LivingEntity){
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.CEILING);
                HPValue = df.format(((LivingEntity)attacker).getHealth());
            }
            attackerType = event_EE.getDamager().getType().toString();
            if(event_EE.getDamager() instanceof Player){
                attackerName = ((Player) event_EE.getDamager()).getDisplayName();
            } else {
                attackerName = (event_EE.getDamager().getCustomName() != null ? event_EE.getDamager().getCustomName() : attackerType);
            }
        }
        damageType = damageEvent.getCause().toString();
        if(messages.containsKey(attackerType)){
            deathMessage = messages.get(attackerType);
            deathMessage = replaceSubstitutions(deathMessage, attackerName, HPValue, event.getEntity().getName());
            event.setDeathMessage(null);
        } else if(messages.containsKey(damageType)){ 
            deathMessage = messages.get(damageType);
            deathMessage = replaceSubstitutions(deathMessage, damageType, HPValue, event.getEntity().getName());
            event.setDeathMessage(null);
        } else {
            Pokestring.debug("warning","Unconfigured Damage/Attacker Type: "+ attackerType+ " or " + damageType);
            return;
        }
        
        final String enclosingWorkaround = deathMessage;
        Bukkit.getScheduler().runTaskAsynchronously(Pokestring.instance(), () -> {
            messageDeathToPeople(enclosingWorkaround);
        });
    }
    private void messageDeathToPeople(String message){
        for(Player eachPlayer : Pokestring.instance().getServer().getOnlinePlayers()){
            if(!DeathMessageToggleFile.contains(eachPlayer.getUniqueId().toString())){
                eachPlayer.sendMessage(message);
            }
        }
    }
    private HashMap<String, String> loadMessages(){
        HashMap<String, String> loaded = new HashMap<String,String>();
        CustomYMLStorage yml = new CustomYMLStorage(Pokestring.instance(), "deathMessages.yml",Pokestring.instance().getDataFolder().getName());
        YamlConfiguration storage = yml.getYamlConfiguration();
        for(String damageType : storage.getKeys(false)){
            loaded.put(damageType,storage.getString(damageType));
        }
        return loaded;
    }
    private String replaceSubstitutions(String original, String attackerName, String attackerHealth, String targetName){
        String temp = original;
        temp = temp.replace("%{attacker_customName}", attackerName);
        temp = temp.replace("%{attacker_health}", attackerHealth);
        temp = temp.replace("%{target_name}", targetName);
        return temp;
    }
}
