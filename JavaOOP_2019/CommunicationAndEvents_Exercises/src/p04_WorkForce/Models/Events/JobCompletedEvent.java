package p04_WorkForce.Models.Events;

import java.util.EventObject;

public class JobCompletedEvent extends EventObject {

    public JobCompletedEvent(Object source) {
        super(source);
    }
}
