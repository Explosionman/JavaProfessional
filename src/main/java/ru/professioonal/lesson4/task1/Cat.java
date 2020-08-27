package ru.professioonal.lesson4.task1;

/*
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true либо false, но должно выполняться условие:
если cat1.fight(cat2) возвращает true,
то cat2.fight(cat1) должен возвращать false.
Требования:
•	Класс Cat должен содержать конструктор без параметров.
•	Класс Cat должен содержать всего три поля: age, weight и strength. Поля должны быть публичные.
•	В классе Cat должен быть метод fight.
•	В методе fight реализовать механизм драки котов в зависимости от их веса, возраста и силы согласно условию.
•	Метод должен возвращать одно и тоже значение, если мы деремся с одним и тем же котом.
•	Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
*/

import java.io.FileWriter;

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        if (this.age == anotherCat.age && this.strength == anotherCat.strength && this.weight == anotherCat.weight) {
            return this.hashCode() > anotherCat.hashCode();
        }
        if (this.age > anotherCat.age && this.strength > anotherCat.strength) {
            return true;
        } else if (this.weight > anotherCat.weight && this.strength > anotherCat.strength) {
            return true;
        } else if (this.weight > anotherCat.weight && this.age > anotherCat.age) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age = 8;
        cat1.weight = 5;
        cat1.strength = 8;

        Cat cat2 = new Cat();
        cat2.age = 8;
        cat2.weight = 5;
        cat2.strength = 8;

        Cat cat3 = new Cat();
        cat3.age = 10;
        cat3.weight = 5;
        cat3.strength = 12;

        System.out.println("cat1 напал на cat2, результат: " + ((cat1.fight(cat2) == true) ? "Победа" : "Поражение "));
        System.out.println("cat2 отдышался и решил отомстить, результат: " + ((cat2.fight(cat1) == true) ? "Победа" : "Поражение "));
        System.out.println("cat1 снова напал на cat2, результат: " + ((cat1.fight(cat2) == true) ? "Победа" : "Поражение "));
        System.out.println("cat3 снова напал на cat1, результат: " + ((cat1.fight(cat2) == true) ? "Победа" : "Поражение "));

    }
}
