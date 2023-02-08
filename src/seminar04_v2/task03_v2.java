/*

 * Classname: Task-3_v2
 *
 * Version: 1.
 *
 * Date: 2023-01-29.
 *
 * Copyright notice: by Oleg Razumov.
 */

package seminar04_v2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class task03_v2 {
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
    public static void main(String[] args) {
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
