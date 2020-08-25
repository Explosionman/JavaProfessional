package ru.professional.lesson5.task1;

/*
Перед решением прочтите https://www.codeflow.site/ru/article/java-buffered-reader
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //можно переделать на численное значение, а то вдруг есть человек с фамилией "exit" с маленькой буквы...не верю)
    public static final String EXIT = "exit";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        int counter = 0;

        // Заполняем arrayList (выход возможен только при заполнении и города и фамилии, во избежание сбоя работы)
        while (true) {
            if (counter % 2 == 0) {
                System.out.println("Введите фамилию семьи или напишите "
                        + EXIT + " - для завершения заполнения данных:");
            } else {
                System.out.println("Введите город, в котором проживает семья:");
            }
            String family = reader.readLine();
            if (family.equals(EXIT) && counter == 0) {
                System.out.println("До новых встреч!");
                System.exit(0);
            }
            counter++;
            if (family.isEmpty() || (family.equals(EXIT) && counter % 2 != 0)) {
                break;
            }
            list.add(family);
        }

        // Ищем город по фамилии
        while (true) {
            System.out.println("Введите фамилию для поиска или напишите " + EXIT + " - для выхода: ");
            String townName = reader.readLine();
            if (townName.equals(EXIT)) break;
            if (list.contains(townName)) {
                String familyName = list.get(list.indexOf(townName) - 1);
                System.out.println(familyName);
            }
        }
    }
}
