package p01_EventImplementation.Models;

import p01_EventImplementation.Events.NameChangeEvent;
import p01_EventImplementation.Interfaces.NameChangeListener;

public class Handler implements NameChangeListener {

    @Override
    public void handleNameChange(NameChangeEvent event) {
        System.out.println(String.format("Dispatcher's name changed to %s.",event.getNewName()));
    }
}
