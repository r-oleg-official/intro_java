/*

 * Classname: task02_v2
 *
 * Version: 1.
 *
 * Date: 2023-01-26.
 *
 * Copyright notice: by Oleg Razumov.
 */

package seminar01_v2;

import java.util.Arrays;

public class task02_v2 {

    public static int[] generateRandomArray(int size, int min, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (max - min) + min);
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr){
        int tmp;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        /*
        Task2
        Реализуйте алгоритм сортировки пузырьком для сортировки массива
        */

        int[] arr_rand = generateRandomArray(10, 0, 100);
        System.out.println(Arrays.toString(arr_rand));
        System.out.println(Arrays.toString(bubbleSort(arr_rand)));
    }
}
