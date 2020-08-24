package ru.professioonal.lesson4.task3;

public abstract class Animal {
    private String name;
    private int age;
    private float weight;

    public Animal(String name, int age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
}
