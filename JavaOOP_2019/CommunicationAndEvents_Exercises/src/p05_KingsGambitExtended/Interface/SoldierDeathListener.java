package p05_KingsGambitExtended.Interface;

import p05_KingsGambitExtended.Events.SoldierDeathEvent;

public interface SoldierDeathListener {
    void handleSoldierDeath(SoldierDeathEvent event);
}
