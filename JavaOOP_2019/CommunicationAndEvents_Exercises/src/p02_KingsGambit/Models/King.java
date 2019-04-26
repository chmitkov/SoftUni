package p02_KingsGambit.Models;

import p02_KingsGambit.Events.UnderAttackEvent;
import p02_KingsGambit.Interfaces.UnderAttackListener;
import java.util.ArrayList;
import java.util.List;

public class King{
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
}
