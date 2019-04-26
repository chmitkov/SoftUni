package p01_EventImplementation.Models;

import p01_EventImplementation.Events.NameChangeEvent;
import p01_EventImplementation.Interfaces.NameChangeListener;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> observers;

    public Dispatcher(){
        this.observers = new ArrayList<>();
        this.setName(null);
    }

    public void setName(String newName){
        this.name = newName;
        this.fireNameChangeEvent();
    }

    public String getName(){
        return this.name;
    }

    public void addNameChangeListener(NameChangeListener observer){
        this.observers.add(observer);
    }

    public void removeNameChangeListener(NameChangeListener observer){
        this.observers.remove(observer);
    }

    private void fireNameChangeEvent(){
        NameChangeEvent event = new NameChangeEvent(this,this.getName());
        for (NameChangeListener observer : observers) {
            observer.handleNameChange(event);
        }
    }
}
