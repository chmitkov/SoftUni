package p04_WorkForce.Models;


import p04_WorkForce.Interfaces.JobCompletedListener;
import p04_WorkForce.Models.Events.JobCompletedEvent;

import java.util.ArrayList;

public class ModifiedList<T> extends ArrayList<T> implements JobCompletedListener{

    @Override
    public void handleJobCompleted(JobCompletedEvent event) {
        this.remove(event.getSource());
    }
}
