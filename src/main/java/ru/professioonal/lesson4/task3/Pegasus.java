package ru.professioonal.lesson4.task3;

public class Pegasus extends Horse {
    public Pegasus(String name, int age, float weight) {
        super(name, age, weight);
    }

    public void fly() {
        System.out.printf("Игого, я %s и я полетел(а)\n", this.getName());
    }
}
