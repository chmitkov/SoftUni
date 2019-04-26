package p05_KingsGambitExtended.Models.Units;

import p05_KingsGambitExtended.Events.SoldierDeathEvent;
import p05_KingsGambitExtended.Events.UnderAttackEvent;
import p05_KingsGambitExtended.Interface.Attackable;
import p05_KingsGambitExtended.Interface.SoldierDeathListener;
import p05_KingsGambitExtended.Interface.UnderAttackListener;
import java.util.ArrayList;
import java.util.List;

public class King implements SoldierDeathListener,Attackable{
    private String name;
    private List<UnderAttackListener> observers;

    public King(String name){
        this.setName(name);
        this.observers = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name){
        this.name = name;
    }

    public void respondToAttack(){
        System.out.println(String.format("King %s is under attack!",this.getName()));
        fireUnderAttackEvent();
    }

    public void addUnderAttackListener(UnderAttackListener observer){
        this.observers.add(observer);
    }

    public void removeUnderAttackListener(UnderAttackListener observer){
        this.observers.remove(observer);
    }

    protected void fireUnderAttackEvent(){
        UnderAttackEvent event = new UnderAttackEvent(this);
        for (UnderAttackListener observer : observers) {
            observer.handleUnitAttacked(event);
        }
    }

    @Override
    public void handleSoldierDeath(SoldierDeathEvent event) {
        this.observers.remove(event.getSource());
    }
}