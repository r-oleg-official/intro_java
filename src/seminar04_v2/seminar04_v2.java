/*

 * Classname: seminar04_v2
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

public class seminar04_v2 {
    public static void main(String[] args) {
        System.out.println("--Task 01.");
        task01();
        System.out.println();
        System.out.println("--Task 02.");
        task02();
        System.out.println();
    }

    public static void task01() {
        // Дан Deque состоящий из последовательности цифр.
        // Необходимо проверить, что последовательность цифр является палиндромом.
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        System.out.print(deque);
        if (checkOn(deque) == true) System.out.println(" - it's palindrome.");
        else System.out.println(" - it's not palindrome.");
    }

    public static boolean checkOn(Deque<Integer> deque) {

        for (int i = 0; i < deque.size(); i++) {
            //deque.getFirst();
            //deque.removeFirst();
            //deque.getLast();
            //deque.removeLast();

            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }

    public static void task02() {
        //Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
        // и каждый из их узлов содержит одну цифру.
        // Сложите два числа и верните сумму в виде связанного списка.

//        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1,2,3));
//        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5,4,7));
//         result [6,6,0,1]

        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(3, 2, 9));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(7, 4, 5));
//         result [1,0,7,4]

        System.out.printf("%s\n%s\n", d1, d2);
        Deque<Integer> d3 = new ArrayDeque<>();

        int size;
        if (d1.size() > d2.size()) size = d1.size();
        else size = d2.size();

        int sum, tmp = 0;
        while (size > 0) {
            int a = d1.pollFirst();
            int b = d2.pollFirst();
            //System.out.printf("%d, %d.\n", a, b);
            sum = a + b + tmp;
            if (sum < 9) {
                d3.add(sum);
                tmp = 0;
                //sum = 0;
            }
            if (sum > 9) {
                d3.add(sum % 10);
                tmp = sum /= 10;
                //sum /= 10;
            }
            //d3.addFirst(sum);
            //sum = 0;
            size--;
            if (size == 0) d3.addFirst(sum);
        }

        System.out.println(d3);
    }
}

