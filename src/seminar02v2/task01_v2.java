/*

 * Classname: task01_v2
 *
 * Version: 1.
 *
 * Date: 2023-01-26.
 *
 * Copyright notice: by Oleg Razumov.
 */

package seminar02v2;

import lecture02.Ex005_Logger;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task01_v2 {
    /*
    Напишите программу, которая принимает с консоли число в формате byte и записывает его в файл ”result.txt”.
    Требуется перехватить все возможные ошибки и вывести их в логгер.
    После написания, попробуйте подать на вход числа 100 и 200 и проследите разницу в результате
     */

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        Logger logger = Logger.getLogger(Ex005_Logger.class.getName());
        FileHandler fh = new FileHandler("src/seminar02v2/task01_v2.log");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        byte byte_in = 0;
        try {
            System.out.print("Input in byte: ");
            byte_in = scn.nextByte();
            System.out.println(byte_in);
        } catch (Exception e) {
            System.out.println(e);
            logger.log(Level.WARNING, String.valueOf(e));
        }
    }
}
