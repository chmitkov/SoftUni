package p02_KingsGambit.Interfaces;


import p02_KingsGambit.Events.UnderAttackEvent;

public interface UnderAttackListener {
    void handleUnitAttacked(UnderAttackEvent event);
}
