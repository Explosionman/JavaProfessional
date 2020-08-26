package ru.professional.lesson6;

/*
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static List<Integer> digits = new ArrayList<>();
    private static BufferedReader reader;

    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь к файлу:");
        String path = null;
        try {
            path = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printSortedList(getDigitsFromFile(path));
    }

    /**
     * Метод читает из файла числа и добавляет их в коллекцию
     *
     * @return коллекция с числами (несортированная)
     */
    public static List<Integer> getDigitsFromFile(String path) {
        //Очищаем на случай, если потребуется читать больше 1 файла
        digits.clear();
        try {
            File file = new File(path);
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                if (line != null && !line.equals("")) {
                    //Фильтр, чтобы не пропустить буквы
                    char[] chars = line.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        if (Character.isLetter(chars[i])) {
                            throw new RuntimeException("В файле обнаружен неккорретный символ: " + chars[i]);
                        }
                    }
                    //добавляем числа в список
                    digits.add(Integer.parseInt(line));
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return digits;
    }

    /**
     * Метод выводит на печать только четные, отсортированные по возрастанию числа из списка
     */
    public static void printSortedList(List<Integer> list) {
        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                System.out.println(list.get(i));
            }
        }
    }
}
