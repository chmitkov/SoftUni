package singleInheritance;

public class Main {
    public static void main(String[] args) {
       Dog dog = new Dog();
       Cat cat = new Cat();

       dog.eat();
       dog.bark();

       cat.eat();
       cat.meow();

    }
}
