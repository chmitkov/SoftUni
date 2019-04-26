package p05_KingsGambitExtended.Models.Units;

import p05_KingsGambitExtended.Events.UnderAttackEvent;

public class Footman extends Soldier {
    private static final int FOOTMAN_HITS = 2;

    public Footman(String name) {
        super(name,FOOTMAN_HITS);
    }

    @Override
    public void handleUnitAttacked(UnderAttackEvent event) {
        System.out.println(String.format("Footman %s is panicking!",this.getName()));
    }
}
