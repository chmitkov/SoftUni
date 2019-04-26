package p05_KingsGambitExtended.Interface;

import p05_KingsGambitExtended.Events.UnderAttackEvent;

public interface UnderAttackListener {
    void handleUnitAttacked(UnderAttackEvent event);
}
