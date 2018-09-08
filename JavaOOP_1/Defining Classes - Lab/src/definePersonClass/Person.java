package definePersonClass;

import defineBankAccountClass.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<BankAccount> bankAccountList;


    public Person(String name, int age) {
        this(name, age, new ArrayList<>());
    }

    public Person(String name, int age, List<BankAccount> bankAccountList) {
        this.name = name;
        this.age = age;
        this.bankAccountList = bankAccountList;
    }

    public double getBalance(){
        return  this.bankAccountList.stream().mapToDouble(d->d.getBalance()).sum();
    }
}
