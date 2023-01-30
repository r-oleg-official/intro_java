package lecture01;

import java.util.Scanner;
import java.io.*;

public class lecture01 {
    /*
    * comment
    */

    // - Простой комментарий

    // Структура простой программы
    /**
    * Program
    */
    // public class Program {
    //     public static void main(String[] args) {
    //         System.out.println("Goodbye, World");
    //     }
    // }
        
    public static void main(String[] args) {
        typeInt();
        System.out.println();

        typeDouble();
        System.out.println();
        
        typeChar();
        System.out.println();
        
        convIntDouble();
        
        typeBoolean();
        System.out.println();
        
        typeString();
        System.out.println();
        
        typeImplicit();
        System.out.println();
        
        classesWrapper();
        System.out.println();
        
        operationsJava();
        System.out.println();

        toBitOperations();
        System.out.println();

        arrays();
        System.out.println();

        matrixes();
        System.out.println();

        converting();
        System.out.println();

        dataFromTerminal();
        System.out.println();

        formatStrings();
        System.out.println();

        visiblity();
        System.out.println();

        functions();
        System.out.println();

        driveBuilding();
        System.out.println();

        circles();
        System.out.println();

        workFiles();
        System.out.println();
    }
    
    public static void typeInt() {
        short age = 10;
        int salary = 123456;
        int i = 23_123_34;          //2312334
        System.out.println(age);    //10
        System.out.println(salary); //123456
        System.out.println(i);
    }
    
    public static void typeDouble() {
        float e = 2.7f;
        double pi = 3.1415;
        //double pi = 3.1415D;        // - необязательно так
        System.out.println(e);      //2.7
        System.out.println(pi);     //3.1415
    }

    public static void typeChar() {
        char ch = '1';
        System.out.println(Character.isDigit(ch)); // true
        ch = 'a';
        System.out.println(Character.isDigit(ch)); // false
        ch = '{';
        System.out.println(ch); // {
        ch = 123;
        System.out.println(ch); // {
    }

    public static void convIntDouble() {
        int a = 15;
        double d = a;
        //a = d; // - так просто невозможно
    }

    public static void typeBoolean() {
        boolean falg1 = 123 <= 234;
        System.out.println(falg1); // true
        boolean falg2 = 123 >= 234;
        System.out.println(falg2); // false
        boolean falg3 = falg1 ^ falg2;
        System.out.println(falg3); // true
    }
    
    public static void typeString() {
        String s = null; // - так можно, это пустая ссылка
        String msg = "Hello, World!";
        System.out.println(msg);
    }

    public static void typeImplicit() {
        // Неявная типизация
        var a = 123;
        System.out.println(a); // 123
        var d = 123.456;
        System.out.println(d); // 123.456
        System.out.println(getType(a)); // Integer
        System.out.println(getType(d)); // Double

        d = 1022;
        System.out.println(d); // 1022
        // d = "mistake";
        // Type mismatch: cannot convert from String to double
    }

    static String getType(Object o) {
        return o.getClass().getSimpleName(); //  метод получения тип данных
    }

    public static void classesWrapper() {
        // Классы-обертки
        int a = 123;
        System.out.println(Integer.MAX_VALUE);
        char b = '2';
        System.out.println(Character.isDigit(b)); // true
        String s = "qwer";
        System.out.println(s.length());     // 4
        System.out.println(s.charAt(1));    // w
    }

    public static void operationsJava() {
        int a = 123;
        a++;
        System.out.println(a);  // 124

        a = 123;
        System.out.println(a++);    // 123
        System.out.println(a);      // 124

        a = 125;
        System.out.println(++a);
        System.out.println(a);
        System.out.println();

        // недобросовестные интервьюеры спрашивают
        System.out.println("Недобросовестные интервьюеры");
        a = 123;
        a = a-- - --a;
        System.out.println(a); // 2
        a = --a - a--;
        System.out.println(a);  // 0
        a = --a-a--;
        System.out.println(a);  // 0
        System.out.println();
        
        System.out.println("Инкремент в цикле 'for'");
        for(int i = 0; i < 3; i++) {
            System.out.println(i);      // 0 1 2
        }
        System.out.println();

        for(int i = 0; i < 3; ++i) {
            System.out.println(i);      // 0 1 2
        }
        System.out.println();

        for(int i = 0; i < 3;) {
            System.out.println(i++);    // 0 1 2
        }
        System.out.println();

        // Операции сравнения
        System.out.println("Операции сравнения");
        boolean f = 123 > 234;
        System.out.println(f);  // false
        f = 123 <= 234;
        System.out.println(f);  // true
        f = 123 != 234;
        System.out.println(f);  // true
    }

    public static void toBitOperations() {
        // побитовые операции
        int a = 8;      // 1000 - в битах
        // a = a << 1;  // 10000
        // System.out.println(a);   // 16
        System.out.println(a << 1); // 16
        
        a = 18;      // 10010 - в битах
        // a = a >> 1;  // 1001
        // System.out.println(a);   // 9
        System.out.println(a >> 1); // 9
        
        int b = 5;
        int c = 2;
        System.out.println(b | c);  // 7
        // 101 - 5
        // 010 - 2
        // 111 - 7

        System.out.println(b & c);  // 0
        // 101 - 5
        // 010 - 2
        // 000 - 0
        
        System.out.println(b ^ c);  // 0
        // 101 - 5
        // 010 - 2
        // 111 - 7

        boolean d = true;
        boolean e = true;
        System.out.println(d & e);  // true
        System.out.println();

        String s = "qwer"; // длина 4, 0..3
        boolean i = s.length() >= 5 && s.charAt(4) == '1'; // false && false
        System.out.println(i); // false

        s = "qwwe1"; // длина 5, 0..4
        i = s.length() >= 5 && s.charAt(4) == '1'; // true && true
        System.out.println(i); // true
        i = s.length() >= 5 & s.charAt(4) == '1'; // true && true
        System.out.println(i); // true

        //s = "qww1"; // длина 4, 0..3
        //i = s.length() >= 5 & s.charAt(4) == '1'; // false && false
        //System.out.println(i); // Exception
    }

    public static void arrays() {
        // Массивы
        System.out.println("Arrays.");
        int[] arr = new int[10];
        System.out.println(arr.length); // 10

        arr = new int[] {1, 2, 3, 4, 5};
        System.out.println(arr.length); // 5
        System.out.println(arr[3]); // 4

        arr[3] = 12;
        System.out.println(arr[3]); // 12

        // На собеседовании могут спросить, а можно так:
        int brr[];
    }

    public static void matrixes() {
        System.out.println("Matrixes.");
        int[] crr[] = new int[3][5];
        
        for(int[] line : crr) {
            for(int item : line) {
                System.out.printf("%d", item);
            }
            System.out.println();
        }
        
        int[][] arr = new int[3][5];

        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void converting() {
        // Прееобразования
        System.out.println("Преобразования");
        int i = 123; double d = i;
        System.out.println(i); // 123
        System.out.println(d); // 123.0
        
        d = 3.1415; i = (int)d;
        System.out.println(d); // 3.1415
        System.out.println(i); // 3
        
        d = 3.9415; i = (int)d;
        System.out.println(d); // 3.9415
        System.out.println(i); // 3

        byte b = Byte.parseByte("123");
        System.out.println(b); // 123

        // b = Byte.parseByte("1234");
        // System.out.println(b); // NumberFormatException: Value out of range - переполнение

        // Ковариантность и контравариантность
        // int[] a = new int[10];
        // double[] e = a;     // Изучаем
    }

    public static void dataFromTerminal() {
        // Получение данных из терминала
        System.out.println("Получение данных из терминала");
        
        // Scanner iScanner = new Scanner(System.in);  // достаточно 1 раз определить
        // System.out.printf("name: ");
        // String name = iScanner.nextLine();
        // System.out.printf("Привет, %s!", name); // без перехода на нов строку
        // System.out.printf("Привет, %s!\n", name);
        // iScanner.close();
        
        // Scanner iScanner = new Scanner(System.in);
        // System.out.printf("int a: ");
        // int x = iScanner.nextInt();
        // System.out.printf("double a: ");
        // double y = iScanner.nextDouble();
        // System.out.printf("%d + %f = %f", x, y, x + y);
        // iScanner.close();

        // Scanner iScanner = new Scanner(System.in);
        // System.out.printf("int a: ");
        // boolean flag = iScanner.hasNextInt();
        // System.out.println(flag);
        // int i = iScanner.nextInt();
        // System.out.println(i);
        // iScanner.close();
    }

    public static void formatStrings() {
        // Форматированный вывод
        System.out.println("Форматированный вывод");
        int a = 1, b = 2;
        int c = a + b;
        
        // Конкратенация
        String res = a + " + " + b + " = " + c;
        System.out.println(res);
        System.out.println();

        // Вопрос на собеседовании
        String s = "qwe";
        int d = 123;
        String q = s + d;
        System.out.println(q);
        System.out.println();

        String res2 = String.format("%d + %d = %d \n", a, b, c);
        System.out.printf("%d + %d = %d \n", a, b, c);
        System.out.println(res2);

        float pi = 3.1415f;
        System.out.printf("%f\n", pi);      // 3,141500
        System.out.printf("%.2f\n", pi);    // 3,14
        System.out.printf("%.3f\n", pi);    // 3,141
        System.out.printf("%e\n", pi);      // 3,141500e+00
        System.out.printf("%.2e\n", pi);    // 3,14e+00
        System.out.printf("%.3e\n", pi);    // 3,141e+00
    }

    public static void visiblity() {
        System.out.println("Область видимости переменных");
        int b = 111;
            {
                int a = 222;
                System.out.println(a+b); // 333
            }
        int a = 123;
        System.out.println(a);  // 123
    }

    public static void functions() {
        System.out.println("Функции (методы)");
        sayHi();    // hi!
        System.out.println(sum(1, 3));  // 4
        System.out.println(factor(5));    // 120.0
    }

    static void sayHi() {
        System.out.println("hi!");
    }

    static int sum(int a, int b) {
        return a + b;
    }
    
    static double factor(int n) {
        if(n == 1) return 1;
        return n * factor(n - 1);
    }

    public static void driveBuilding() {
        System.out.println("Управляющие конструкции");
        int a = 1;
        int b = 2;
        int c;
        if (a > b) {
            c = a;
        } else {
            c = b;
        }

        // Сокр. форма
        if (a > b) c = a;
        if (b > a) c = b;
        System.out.println(c);

        // Тернарный оператор
        int min = a < b ? a : b;
        System.out.println(min);

        // Оператор выбора switch.
        // int mounth = value;
        // String text = "";
        // switch (mounth) {
            // case 1:
                // text = "Autumn";
                // break;
            // ...
            // default:
                // text = "mistake";
                // break;
        // }
        // System.out.println(text);
        // iScanner.close();
        int d = 123;
        switch (d) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("a");
                break;
            case 10: 
                System.out.println("b");
                break;
            default:
                break;
        }
    }
    public static void circles() {
        // Циклы
        System.out.println("Циклы");
        
        // while
        int value = 321;
        int count = 0;
        
        while (value !=0) {
            value /= 10;
            count++;
        }
        System.out.println(count);  // 3

        // do while
        value = 321;
        count = 0;

        do {
            value /= 10;
            count++;
        } while (value != 0);
        System.out.println(count);  // 3

        for (int i = 0; i < 10; i++) {
            if (i % 2  == 0)
                continue;
            System.out.println(i);  // 1 3 5 7 9
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            if (i % 2  != 0) {
                break;
            }
            System.out.println(i);  // 0
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                break;  //  break-1
            }
            break;  // break-2
        }

        int s = 0;
        for (int i = 0; i <= 10; i++) {
            s += 1;
        }
        System.out.println(s);  // 11

        for (int i = 0; i < 5; i++) {
            for ( int j = 0; j < 5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *

        // для коллекций
        int arr[] = new int[10];
        for (int item : arr) {
            System.out.printf("%d ", item);
        }
        System.out.println();

        // foreach
        int[] brr = new int[] {1, 2, 3, 4, 5, 77};
        for (int item : brr) {
            System.out.print(item); // 1234577
        }
        System.out.println();
        

        // почему не изменяются эл-ты массива через item
        int[] crr = new int[] {1, 2, 3, 4, 5, 77};
        for (int item : crr) {
            item = 12;
            System.out.print(item); // 1212121212
        }
        System.out.println();
        for (int item : crr) {
            System.out.print(item); // 1234577
        }
        System.out.println();
    }

    public static void workFiles() {
        System.out.println("Работа с файлами");

        // Record to the new file, don't rewrite
        try (FileWriter fw = new FileWriter("src/lecture01/file.txt", false)){
            fw.write("line 1");
            fw.append('\n');
            fw.append('2');
            fw.append('\n');
            fw.append("line 3");
            fw.flush();
        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println(ex.getMessage());
        }
    }

    public static void readChars() throws Exception {
        // Read from the file, by chars (посимвольно).
        FileReader fr = new FileReader("src/lecture01/file.txt");
        int c;
        while ((c = fr.read()) != -1) {
            char ch = (char) c;
            if (ch == '\n') {
                System.out.print(ch);
            } else {
                System.out.print(ch);
            }
        }
    }

    public static void readLines() throws Exception {
        // Read from th file, by lines. (построчно)
        BufferedReader br = new BufferedReader(new FileReader("src/lecture01/file.txt"));
        String str;
        while ((str = br.readLine()) != null) {
            System.out.printf("== %s ==\n", str);
        }
        br.close();
    }

}
