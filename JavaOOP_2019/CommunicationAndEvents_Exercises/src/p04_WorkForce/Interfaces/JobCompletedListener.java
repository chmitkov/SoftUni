package p04_WorkForce.Interfaces;


import p04_WorkForce.Models.Events.JobCompletedEvent;

public interface JobCompletedListener {
    void handleJobCompleted(JobCompletedEvent event);
}
