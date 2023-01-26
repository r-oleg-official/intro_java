/*

 * Classname: seminar02_v2
 *
 * Version: 1.
 *
 * Date: 2023-01-22.
 *
 * Copyright notice: by Oleg Razumov.
 */

package seminar02v2;

import java.util.Arrays;
import java.util.Scanner;


public class seminar02_v2 {
    public static String getString() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите любую строку: ");
        String res = scn.nextLine();
        return res;
    }

    public static String findJewelsInStones(String jewels, String stones) {

        int count = 0;
        String result = "";
        for (int i = 0; i < jewels.length(); i++) {
            result += jewels.charAt(i);
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)) {
                    count++;
                }
            }
            result += Integer.toString(count);
            count = 0;
        }
        return result;
    }

    public static String shuffle(final String s, final int[] index) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int pos = index[i] - 1;
            res += s.charAt(pos);
        }
        return res;
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (max - min) + min);
        }
        return arr;
    }

    public static int scanInput(String msg) {
        while (true) {
            System.out.print(msg);
            Scanner scn = new Scanner(System.in);
            if (!scn.hasNext()) {
                System.out.println("Error! Enter a number again: ");
            } else {
                return Integer.parseInt(scn.next());
            }
        }
    }

    public static int checkPositive(String msg) {
        int positiveInt;
        while (true) {
            positiveInt = scanInput(msg);
            if (positiveInt < 0 || positiveInt % 2 != 0) {
                System.out.println("Error! Enter a number again: ");
            } else {
                return positiveInt;
            }
        }
    }

    private static String task03(String msg, int min, int max) {
        // A random numbers in range [-5; 5]
        int[] arr = generateRandomArray(checkPositive(msg), min, max);
        System.out.println(Arrays.toString(arr));

        int separator = arr.length / 2;
        int summa1 = 0, summa2 = 0;
        for (int i = 0; i < separator; i++) {
            summa1 += Math.abs(arr[i]);
            summa2 += Math.abs(arr[separator + i]);
        }
        if (summa1 > summa2) {
            return "Left > right.";
        }
        if (summa2 > summa1) {
            return "Right > Left.";
        } else {
            return "Left = right.";
        }
    }

    public static void main(String[] args) {
        /* Task-01
        Посчитайте сколько драгоценных камней в куче обычных камней.
        Пример:
        jewels = “aB”,stones = “aaaAbbbB”
        Результат в консоль ”a3B1”
        public static void main (String[]args){
        }
        public String findJewelsInStones (String jewels, String stones){
            return "";
        }
         */
//        String jewels = "aB", stones = "aaaAbbbB";
//        String jewels = getString(), stones = getString();
//        System.out.println(findJewelsInStones(jewels, stones));
        System.out.println();

        /* Task-02
        Вам дается строка S и целочисленный массив индексов int index[s.length]. Напишите программу,
        которая перетасует символы в S таким образом, что символ c i-й позиции переместится на индекс index[i]
        в результирующей строке.
        Пример: s = “cba”, index = [3,2,1] result “abc”
        */
//        String s = "cba";
//        int[] index = new int[]{3, 2, 1};
//        System.out.println(shuffle(s, index));
//        System.out.println();

        /* Task-03
        Пользователь должен указать с клавиатуры чётное положительное число, а программа должна создать массив
        указанного размера из случайных целых чисел из [-5;5] и вывести его на экран в строку. После этого программа
        должна определить и сообщить пользователю о том, сумма модулей какой половины массива больше: левой или
        правой, либо сообщить, что эти суммы модулей равны. Если пользователь введёт неподходящее число, то программа
        должна требовать повторного ввода до тех пор, пока не будет указано корректное значение.
         */
        System.out.println(task03("Enter a even positive number: ", -5, 5));

        /* Task-04

         */
    }
}

