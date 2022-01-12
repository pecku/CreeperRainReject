package hu.pecku.creeperrainreject;

import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class CreeperRainReject extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void asd(ExplosionPrimeEvent event){
        Entity ent = event.getEntity();
        if(event.getEntityType() == EntityType.CREEPER){
            Biome biome = ent.getWorld().getBiome(ent.getLocation());
            if(!ent.getWorld().isClearWeather() && !(biome == Biome.SAVANNA || biome == Biome.DESERT)){
                event.setCancelled(true);
            }
        }
    }
}
