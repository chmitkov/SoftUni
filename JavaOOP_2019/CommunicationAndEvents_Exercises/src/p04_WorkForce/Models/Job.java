package p04_WorkForce.Models;

import p04_WorkForce.Interfaces.Employee;
import p04_WorkForce.Interfaces.JobCompletedListener;
import p04_WorkForce.Models.Events.JobCompletedEvent;

import java.util.ArrayList;
import java.util.List;

public class Job {
    private String name;
    private int workHoursRequired;
    private Employee employee;
    private List<JobCompletedListener> observers;

    public Job(String name, int workHoursRequired, Employee employee){
        this.setName(name);
        this.setWorkHoursRequired(workHoursRequired);
        this.setEmployee(employee);
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getWorkHoursRequired() {
        return workHoursRequired;
    }

    private void setWorkHoursRequired(int workHoursRequired) {
        this.workHoursRequired = workHoursRequired;
    }

    public Employee getEmployee() {
        return employee;
    }

    private void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void update(){
        this.setWorkHoursRequired(this.getWorkHoursRequired() - this.employee.getWeeklyWorkHours());
        if(this.getWorkHoursRequired() <= 0){
            System.out.println(String.format("Job %s done!",this.getName()));
            fireJobCompletedEvent();
        }
    }

    public void addJobCompletedListener(JobCompletedListener listener){
        this.observers.add(listener);
    }

    public void removeJobCompletedListener(JobCompletedListener listener){
        this.observers.remove(listener);
    }

    public void fireJobCompletedEvent(){
        JobCompletedEvent event = new JobCompletedEvent(this);
        for (JobCompletedListener observer : observers) {
            observer.handleJobCompleted(event);
        }
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d",this.getName(),this.getWorkHoursRequired());
    }
}
