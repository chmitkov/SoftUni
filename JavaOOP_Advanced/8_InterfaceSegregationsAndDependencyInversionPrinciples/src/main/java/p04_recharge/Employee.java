package p04_recharge;

public class Employee extends Worker implements Sleeper {

    public Employee(String id) {
        super(id);
    }


    @Override
    public void sleep() {
        System.out.println("Employee is sleeping");
    }
}
