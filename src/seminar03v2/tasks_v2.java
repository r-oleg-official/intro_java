/*

 * Classname: tasks_v2
 *
 * Version: 1.
 *
 * Date: 2023-01-28.
 *
 * Copyright notice: by Oleg Razumov.
 */

package seminar03v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.*;

public class tasks_v2 {

    // Пусть дан произвольный список целых чисел
    public static void main(String[] args) {
        int li_size = 10;
        int min = 1;
        int max = 20;
        List<Integer> li_rand = generateRandomList(li_size, min, max);

        System.out.println("A source random list:");
        System.out.println(li_rand);

        System.out.println();
        System.out.printf("Uneven list:\n%s", removeEvenValue(li_rand).toString());
        System.out.println();

        System.out.println();
        System.out.printf("A minimal element of the list: %s\n", getMin(li_rand).toString());
        System.out.printf("A maximal element of the list: %s\n", getMax(li_rand).toString());
        System.out.printf("A average of the list: %s\n", getAverage(li_rand).toString());
    }

    public static List<Integer> generateRandomList(int size, int min, int max) {
        ArrayList<Integer> li = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            li.add((int) (Math.random() * (max - min) + min));
        }
        return li;
    }

    // Нужно удалить из него четные числа
    public static List<Integer> removeEvenValue(List<Integer> source){
        ArrayList<Integer> li = new ArrayList<>();
        //li.addAll(source);
        //List<Integer> li = List.copyOf(source);

        for (int i = 0; i < source.size(); i++) {
            if (source.get(i) % 2 != 0) {
                li.add(source.get(i));
            }
        }
        return li;
    }

    // Найти минимальное значение
    public static Integer getMin(List<Integer> source){
        int min = source.get(0);

        for (int i = 1; i < source.size(); i++) {
            if (source.get(i) < min) min = source.get(i);
        }
        return min;
    }

    // Найти максимальное значение
    public static Integer getMax(List<Integer> source){
        int max = source.get(0);

        for (int i = 1; i < source.size(); i++) {
            if (source.get(i) > max) max = source.get(i);
        }
        return max;
    }

    // Найти среднее значение
    public static Integer getAverage(List<Integer> source){
        int sum = 0;

        for (int i: source) sum += i;

        return sum / source.size();
    }
}
