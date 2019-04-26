package p04_WorkForce.Models.Employees;

public class StandartEmployee extends BasicEmployee{
    private static final int STANDART_EMPLOYEE_WORKHOURS = 40;

    public StandartEmployee(String name){
        super(name,STANDART_EMPLOYEE_WORKHOURS);
    }
}
