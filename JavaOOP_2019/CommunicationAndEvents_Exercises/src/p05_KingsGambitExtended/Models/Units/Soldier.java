package p05_KingsGambitExtended.Models.Units;

import p05_KingsGambitExtended.Events.SoldierDeathEvent;
import p05_KingsGambitExtended.Interface.Attackable;
import p05_KingsGambitExtended.Interface.SoldierDeathListener;
import p05_KingsGambitExtended.Interface.UnderAttackListener;

import java.util.ArrayList;
import java.util.List;

public abstract class Soldier implements UnderAttackListener, Attackable {
    private String name;
    private int hitsLeft;
    private List<SoldierDeathListener> observers;

    protected Soldier(String name,int hits){
        this.setName(name);
        this.hitsLeft = hits;
        this.observers = new ArrayList<>();
    }

    protected int getHitsLeft(){
        return this.hitsLeft;
    }

    protected void setHitsLeft(int hits){
        this.hitsLeft = hits;
    }

    private void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void respondToAttack() {
        this.setHitsLeft(this.getHitsLeft() - 1);
        if(this.getHitsLeft() == 0){
            this.fireSoldierDeathEvent();
        }
    }

    public void addSoldierDeathListener(SoldierDeathListener observer){
        this.observers.add(observer);
    }

    public void removeSoldierDeathListener(SoldierDeathListener observer){
        this.observers.remove(observer);
    }

    protected void fireSoldierDeathEvent(){
        SoldierDeathEvent event = new SoldierDeathEvent(this,this.getName());
        for (SoldierDeathListener observer : observers) {
            observer.handleSoldierDeath(event);
        }
    }
}