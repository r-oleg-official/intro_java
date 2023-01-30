/*

 * Classname: seminar03_v2
 *
 * Version: 1.
 *
 * Date: 2023-01-28.
 *
 * Copyright notice: by Oleg Razumov.
 */

package seminar03v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class seminar03_v2 {
    public static void main(String[] args) {
        System.out.println("--Task 01.");
        task01();
        System.out.println();
        System.out.println("--Task 02.");
        task02();
        System.out.println();
        System.out.println("--Task 04.");
    }

    public static void task01() {
    //    Напишите программу на Java для создания нового списка массивов,
    //    добавьте некоторые элементы (строки) и распечатайте коллекцию.
        ArrayList<String> colours = new ArrayList<>();

        colours.add("Red");
        colours.add("Green");
        colours.add("Orange");
        colours.add("White");
        colours.add("Black");
        System.out.println(colours);


//        colours.add(5, "Yellow");
//        System.out.println(colours);
//
//        System.out.println(colours.get(1));
//        System.out.println(colours.get(3));

//        colours.set(0, "Pink");
//        System.out.println(colours);

//        colours.remove(2);
//        System.out.println(colours);

//        if (colours.contains("Green")) {
//            System.out.println("Find!");
//        } else {
//            System.out.println("Not find.");
//        }
//        if (colours.contains("Pink")) {
//            System.out.println("Find!");
//        } else {
//            System.out.println("Not find.");
//        }

        Collections.sort(colours);
        System.out.println(colours);

        ArrayList<String> arr = new ArrayList<>();
        arr.add("Hello");
        arr.add("world");
        arr.add("Earth");
//        arr.add("Mars");
//        arr.add("Jupyter");

        Collections.copy(colours, arr);
        System.out.println(colours);
        System.out.println(arr);
        Collections.reverse(colours);
        System.out.println(colours);

        ArrayList<String> newArr = (ArrayList<String>) colours.clone();
        System.out.println(newArr);
    }

    public static void task02() {
        /*
         Даны следующие строки. Сравнить их с помощью == и метода equals()
         String s1 = "hello";
         String s2 = "hello";
         String s3 = s1;
         String s4 = "h" + "e" + "l" + "l" + "o";
         String s5 = new String("hello");
         String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});
        */
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});

        String[] arr = new String[]{s1, s2, s3, s4, s5, s6};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.printf("s%s == s%s => ", i, j);
                System.out.println(arr[i] == arr[j]);
                System.out.printf("s%s.equals(s%s) => ", i, j);
                System.out.println(arr[i] == arr[j]);
            }
        }
    }

    public static void task04() {
        // Дан список содержащий строки и числа в строковом формате.
        // С помощью итератора пройти по списку и вывести в консоль что является строкой, а что числом.
        List<String> list = new ArrayList<>(Arrays.asList("a", "2", "b", "3", "c", "4"));
        printResultOfCheck(list);
    }

    private static void printResultOfCheck(List<String> list) {
        for (String item: list) {

        }
    }
}
