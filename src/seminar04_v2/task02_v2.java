/*

 * Classname: Task-2_v2
 *
 * Version: 1.
 *
 * Date: 2023-01-29.
 *
 * Copyright notice: by Oleg Razumov.
 */

package seminar04_v2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class task02_v2 {
    //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    // Сложите два числа и верните сумму в виде связанного списка.

    public static void main(String[] args) {
//        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1,2,3));
//        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5,4,7));
        // result [6,6,0,1]

        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3, 2, 9));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7, 4, 5));
//        result [1,0,7,4]

        System.out.printf("%s\n%s\n", d1, d2);
        System.out.println(sum(d1, d2));
    }

    public static Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> d3 = new ArrayDeque<>();

        int size;
        if (d1.size() > d2.size()) size = d1.size();
        else size = d2.size();

        int sum, tmp = 0;
        while (size > 0) {
            int a = d1.pollLast();
            int b = d2.pollLast();

            sum = a + b + tmp;
            if (sum < 9) {
                d3.addFirst(sum);
                tmp = 0;
            } else  {
                d3.addFirst(sum % 10);
                tmp = sum /= 10;
            }
            size--;
            if (size == 0) d3.addFirst(sum);
        }
        return d3;
    }
}
