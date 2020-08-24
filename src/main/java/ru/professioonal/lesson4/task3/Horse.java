package ru.professioonal.lesson4.task3;

public class Horse extends Animal {
    public Horse(String name, int age, float weight) {
        super(name, age, weight);
    }

    public void run() {
        System.out.printf("Игого, я %s и я поскакал(а)\n", this.getName());
    }
}
