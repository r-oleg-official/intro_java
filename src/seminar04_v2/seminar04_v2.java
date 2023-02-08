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
import java.util.List;

public class seminar04_v2 {
    public static void main(String[] args) {
        System.out.println("--Task 01.");
        task01();
        System.out.println();
        System.out.println("--Task 02.");
        task02();
        System.out.println();
        System.out.println("--Task 03.");
        task03();
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
//         result [1,4,7,0] - версия Леонида
//         result [0,7,4,1] - моя версия

        System.out.printf("%s\n%s\n", d1, d2);
        Deque<Integer> d3 = new ArrayDeque<>();

        int size;
        if (d1.size() > d2.size()) size = d1.size();
        else size = d2.size();

        int sum, tmp = 0;
        while (size > 0) {
            int a = d1.pollFirst();
            int b = d2.pollFirst();

            sum = a + b + tmp;
            if (sum < 9) {
                d3.addFirst(sum);
                tmp = 0;
            }
            if (sum > 9) {
                d3.addFirst(sum % 10);
                tmp = sum /= 10;
                //sum /= 10;
            }
            size--;
            if (size == 0) d3.addFirst(sum);
        }

        System.out.println(d3);
    }

    public static void task03(){
    //Дана строка содержащая только символы '(', ')', '{', '}', '[' и ']', определите,
    // является ли входная строка логически правильной.
    // Входная строка логически правильная, если:
    // 1) Открытые скобки должны быть закрыты скобками того же типа.
    // 2) Открытые скобки должны быть закрыты в правильном порядке. Каждая закрывающая скобка имеет соответствующую
    // открытую скобку того же типа.
    // ()[] = true
    // () = true
    // {[()]} = true
    // ()() = true
    // )()( = false

        String str1 = "()[]";
        String str2 = "()";
        String str3 = "{[()]}";
        String str4 = "()()";
        String str5 = ")()(";
        String str6 = "([])(})";

        Deque<Character> ch1 = StringToCharacter(str1);
        Deque<Character> ch2 = StringToCharacter(str2);
        Deque<Character> ch3 = StringToCharacter(str3);
        Deque<Character> ch4 = StringToCharacter(str4);
        Deque<Character> ch5 = StringToCharacter(str5);
        Deque<Character> ch6 = StringToCharacter(str6);

        System.out.printf("%s = %b\n", str1, validate(ch1));
        System.out.printf("%s = %b\n", str2, validate(ch2));
        System.out.printf("%s = %b\n", str3, validate(ch3));
        System.out.printf("%s = %b\n", str4, validate(ch4));
        System.out.printf("%s = %b\n", str5, validate(ch5));
        System.out.printf("%s = %b\n", str6, validate(ch6));
    }

    static Deque<Character> StringToCharacter(String s) {
        ArrayDeque<Character> ch = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            ch.add(s.charAt(i));
        }

        return ch;
    }

    public static boolean validate(Deque<Character> deque){
        List<Character> li_1 = List.of('(', '[', '{');
        List<Character> li_2 = List.of(')', ']', '}');
        Deque<Character> check = new ArrayDeque<>();

        for (Character sym: li_2) {
            if (sym == deque.getFirst()) return false;
        }

        for (Character sym: li_1) {
            if (sym == deque.getLast()) return false;
        }

        while (deque.size() > 1) {
            Character symOpen = deque.poll();
            Character symClose = deque.poll();

            for (int i = 0; i < li_1.size(); i++) {
                if (li_1.get(i) == symOpen || li_2.get(i) == symClose)
                    check.add(symOpen);
                check.add(symClose);
            }
        }

        if (deque.size() == 0) return true;
        return false;
    }
}

