/*

 * Classname: task03_v2
 *
 * Version: 1.
 *
 * Date: 2023-01-26.
 *
 * Copyright notice: by Oleg Razumov.
 */

package seminar01_v2;

public class task03_v2 {

    public static String findSimpleNumber(int min, int max) {
        StringBuilder sb = new StringBuilder();
        int counter;
        int number = min;

        while (number <= max) {
             counter = 0;

            for (int i = min; i <= number; i++) {
                if (number % i == 0) counter++;
            }

            if (counter < 2) sb.append(number + ", ");
            number++;
        }
        return sb.substring(0, sb.length() - 2);
    }

    public static void main(String[] args) {
        /*
        Task3
        Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
        Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.
         */

        int number_min = 2;
        int number_max = 100;

        System.out.println(findSimpleNumber(number_min, number_max));
    }
}
