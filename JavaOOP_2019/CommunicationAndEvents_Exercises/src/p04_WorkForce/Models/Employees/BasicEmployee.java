package p04_WorkForce.Models.Employees;

import p04_WorkForce.Interfaces.Employee;

public abstract class BasicEmployee implements Employee {
    private String name;
    private int weeklyWorkHours;

    protected BasicEmployee(String name, int weeklyWorkHours){
        this.setName(name);
        this.setWeeklyWorkHours(weeklyWorkHours);
    }

    private void setName(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setWeeklyWorkHours(int hours){
        this.weeklyWorkHours = hours;
    }

    @Override
    public int getWeeklyWorkHours() {
        return this.weeklyWorkHours;
    }
}
