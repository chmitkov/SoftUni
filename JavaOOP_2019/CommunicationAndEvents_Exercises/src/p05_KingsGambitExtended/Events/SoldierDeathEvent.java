package p05_KingsGambitExtended.Events;

import java.util.EventObject;

public class SoldierDeathEvent extends EventObject{
    private String name;

    public SoldierDeathEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
