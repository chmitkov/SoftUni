package p02_KingsGambit.Models;

import p02_KingsGambit.Events.UnderAttackEvent;

public class Footman extends Soldier{

    public Footman(String name) {
        super(name);
    }

    @Override
    public void handleUnitAttacked(UnderAttackEvent event) {
        System.out.println(String.format("Footman %s is panicking!",this.getName()));
    }
}
