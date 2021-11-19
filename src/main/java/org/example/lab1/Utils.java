package org.example.lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  * @author Kaldina Darya
 *  * @version 1.0
 *  @since 1.0
 * A class with additional functions for the task
 */
public class Utils {

    //Сделать из массива чисел многочлена более понятный для пользователя текст
    /**
     * Makes the array of the polynomial more understandable to the user
     * @param m - Array of numbers of the polynomial
     * @return String
     */
    public static String toString(int[] m) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = m.length - 1; i >= 0; i--) {
            int number = m[i];
            if (number == 0) {
                continue;
            }
            if (number > 0 && i != m.length - 1) {
                stringBuilder.append("+");
            }
            stringBuilder.append(String.format("%dx^%d", number, i));
        }
        return stringBuilder.toString();
    }


    //Получить наибольший общий делитель
    /**
     * Finding a greatest common divisor
     * @param a - first number
     * @param b - second number
     * @return int
     */
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //Получить наименьшее общее кратное
    /**
     * Finding a least common multiple
     * @param a - first number
     * @param b - second number
     * @return int
     */
    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }


    //Конвертирует числа из текста
    /**
     * Parsing numbers from Text
     * @param str - a string consisting of digits
     * @return int[]
     */
    public static int[] parse(String str) {
        String[] split = str.trim().split(" ");
        int[] m = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            m[i] = Integer.parseInt(split[i]);
        }
        return m;
    }

    //Поиск общего знаменателя
    /**
     * Finding a common denominator
     * @param arr - Array of Denominators
     * @return int
     */
    public static int commonDenominator(int[] arr) {
        int max = -1;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 1; j < arr.length ; j++) {
                int max2 = Utils.lcm(arr[i], arr[j]);
                if (max < max2) {
                    max = max2;
                }
            }
        }
        return max;
    }

    //Считывание многочленов из файла
    /**
     * Reading polynomials from a file
     * @param path - File path
     * @return int[][]
     */
    public static int[][] readFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            int[][] massive = new int[lines.size()][];

            for (int i = 0; i < lines.size(); i++) {
                massive[i] = parse(lines.get(i));
            }

            return massive;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
