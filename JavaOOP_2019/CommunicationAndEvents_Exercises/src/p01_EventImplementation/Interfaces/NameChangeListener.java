package p01_EventImplementation.Interfaces;


import p01_EventImplementation.Events.NameChangeEvent;

public interface NameChangeListener {
    void handleNameChange(NameChangeEvent event);
}
