/*

 * Classname: task01_v2
 *
 * Version: 1.
 *
 * Date: 2023-01-26.
 *
 * Copyright notice: by Oleg Razumov.
 */

package seminar01;

import java.util.Arrays;

public class task01_v2 {

    public static int[] generateRandomArray(int size, int min, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (max - min) + min);
        }
        return arr;
    }
    public static void main(String[] args) {
        /*
        Task1
        Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
        Для генерации случайного числа используйте метод Math.random(), который возвращает значение
        в промежутке [0, 300].
         */

        int min_rand = 0;
        int max_rand = 300;
        int[] arr_rand = generateRandomArray(10, min_rand, max_rand);

        int max = 0;
        float ave = 0;
        int min = arr_rand[0];
        for (int i = 0; i < arr_rand.length; i++) {
            if (arr_rand[i] < min) min = arr_rand[i];
            if (arr_rand[i] > max) max = arr_rand[i];
            ave += arr_rand[i];
        }
        ave /= arr_rand.length;

        System.out.println(Arrays.toString(arr_rand));
        System.out.printf("Minimum = %d, average = %.2f, maximum = %d", min, ave, max);

    }
}
