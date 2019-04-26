package p05_KingsGambitExtended.Models;

import p05_KingsGambitExtended.Events.SoldierDeathEvent;
import p05_KingsGambitExtended.Interface.SoldierDeathListener;
import java.util.LinkedHashMap;

public class ModifiedMap<K,V> extends LinkedHashMap<K,V> implements SoldierDeathListener{

    @Override
    public void handleSoldierDeath(SoldierDeathEvent event) {
        this.remove(event.getName());
    }
}
