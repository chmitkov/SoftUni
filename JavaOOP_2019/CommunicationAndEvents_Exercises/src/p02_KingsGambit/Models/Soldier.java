package p02_KingsGambit.Models;

import p02_KingsGambit.Interfaces.UnderAttackListener;

public abstract class Soldier implements UnderAttackListener {
    private String name;

    protected Soldier(String name){
        this.setName(name);
    }

    private void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
