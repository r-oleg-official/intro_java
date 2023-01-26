 
1. Создать файл `program.java`. Создастся класс `public class program`:

    public class program {
        } 

 Это минимальная ед-ца в контексте ЯП Джава.

Нужно определить место, с которого буде стартовать программа - это наз точка входа. 
Она определяется функцией/методом `main()`:

    static public void main(String[] args) {       
    }

`String[] args` - обязательная часть метода `main()`.

Это минимальная программа джава:

    public class program {
        static public void main(String[] args) {
        
        }
    }

#### Сниппеты. 
Начинаешь писать `class`, а VSC подскажет выбор, выбрать 2-й. Далее на 2-й строке 
написать `main`, выбрать 1-й пункт и сформируется метод `main(String[] args)` самостоятельно.

    System.out.println("bye world"); - простой код вывода в терминал

Через сниппет. Начать писать `sysout` + `Enter`, в VSC и получится сразу `System.out.println();`.

Способы запуска кода:

1. Кнопка "треугольник" в верхнем правом углу VSC.
2. В терминале:

    java program.java - MacOS

    javac program.java  - linux: create class
    java program        - linux: run program

Комментарии:

    /*
    * comment
    */

Простой комментарий

    //

Структура простой программы:

    /**
    * Program
    */
    public class Program {
        public static void main(String[] args) {
            System.out.println("Goodbye, World");
        }
    }

## Типы данных и переменные
Основы Java и C# - +- одинаковые.
Типы данных:
1. примитивные:
    a) boolean - логический;<br>
    b) int, short, long - целочисленные;<br> 
    c) float, double - вещественные;<br>
    d) Char - символьный, который неявно является на самом деле числовым;<br>
     и т.д.. 
2. ссылочные - все что относится к классам и интерфейсам. 
Когда дело касается тонкостей работы со ссылочными типами, то они более детально будут разбираться в контексте ООП. 
Пока из ссылочного типа будут только массивы.

Создание переменной:

    <тип><индентификатор>; - объявление переменной
    <индентификатор> = <значение>; - инициализация переменной

Обычно делается так:

    <тип><индентификатор> = <значение>;

> Без инициализации переменной - программа не скомпелируется!

Пример:

    String s = null; - так можно сделать, это пустая ссылка

Пустая ссылка - особенности хранения данных в памяти. Это будет в ООП.

### Примитивные типы, целочисленные:

    short age = 10;
    int salary = 123456;
    int i = 23_123_34;          // так можно разделять разряды для наглядности
    System.out.println(age);    // 10
    System.out.println(salary); // 123456

### Примитивные типы, вещественные:

    float e = 2.7f;
    double pi = 3.1415;
    double pi = 3.1415D; - необязательно так
    System.out.println(e);    //2.7
    System.out.println(pi);    //3.1415

> Суффикс `f` для `float` использовать обязательно!!! Т.к. неявное преобразование в `float` не работает:

    float e = 123.45; - неявно воспиримется как `double` - неявная конвертация не сработает.
    float e = 123.45f; - только так

> Суффикс `D` для `double` можно не делать, потому-что числовое значение воспринимается как `double`.

### Тип данных `Char`.
 `Char` - определяет отдельный символ:

    char ch = '1';
    System.out.println(Character.isDigit(ch)); //true
    ch = 'a';
    System.out.println(Character.isDigit(ch)); //false

>!!!Внимание. Нужно быть внимательным с `char`.

    ch = '{';
    System.out.println(ch); // {
    ch = 123;
    System.out.println(ch); // {

Если в `char` положить `123`, то произойдет неявное перобразование одного типа `число` в `символ` и в `ch` 
будет не число `123` храниться, а символ `{`.

>
> Неявное преобразование - когда не указывается суффикс!

Преобразование `int` в `double` возможно:

    int a = 15;
    double d = a;
    a = d; - так просто не получится, нужно использовать перобразование.

Потому-что в `int` 4 байта и целый тип, а `double` - это 8 байт и вдобавок вещественный тип.

### Boolean.

        boolean falg1 = 123 <= 234;
        System.out.println(falg1);      // true
        boolean falg2 = 123 >= 234;
        System.out.println(falg2);      // true
        boolean falg3 = falg1 ^ falg2;
        System.out.println(falg3);

Логические операторы: AND (`&&`), OR (`||`). Побитовые: (`&`), (`|`).

Разделяющая ИЛИ-ИЛИ в Java (`^`), или разделительная дизюнкция. Возвращает ИСТИНУ тогда и только тогда, когда 
строго одни из значений ИСТИНА.
    
    true ^ false // true
    true ^ true // false

### String.

Может показаться, что  `String` - примитивный тип данных, но в Java это не так.

### Неявная типизация.
Можно явно указать тип данных, например, `boolean`:

    boolean f = true;
    int a = 123;

Но в тоже время можно:

    var i = 123;

Хорошо ли это, или плохо? Это классический подход, не всегда можно точно определить тип данных. 
Когда будет компиляция, то вместо `var` будет подставлен наиболее вероятный тип данных.

> Внимание! Любой метод в Java должен быть частью класса.

Тип данных можно получить след методом:

    public static void main(String[] args) {
        var a = 123;
        System.out.println(getType(a));
    }

    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }

`static String getType(Object o) { }` - коротко, это статический член класса.

`Object` - тип.

### Классы-обертки.

    Примитив    -   Обертка
    int         -   Integer
    short       -   Short
    long        -   Long
    byte        -   Byte
    float       -   Float
    double      -   Double
    char        -   Character
    boolean     -   Boolean

Если при присвоении указать `int a = 1213;` - то все будет нормально работать. Но если нужны детали работы 
с этой переменной, то возникнут проблемы, например, узнать максимально возможное значение переменной `int`:

    System.out.println(int.);      //  технически можно было бы, но не сработает
    System.out.println(Integer.MAX_VALUE);  // так доступны методы класса

Например, нужно провести проверку символа на принадлежность чего-то: числу, букве, большой букве, превратить 
в большую букву.

> Через точку `.`, например, `Character.` обращение к членам того класса с которым мы работаем.

    char b = '2';
    System.out.println(Character.isDigit(b)); // true

Пример со строкой. Например, получить символ строки:

    String s = "qwer";
    s[1] = ...;         // так обращение к символу в Java  не сработает
    s.length();         // длина строки
    s.charAt(1);        // w

### Операции Java.

* Присваивание: =
* Арифметические: *, /, +, -, %, ++ (инкремент), -- (декремент)
* Операции сравнения: <, >, ==, !=, >=, <=
* Логические операции: ||, &&, ^, !
* Побитовые операции: <<, >>, &, |, ^

[10. Java – Основные операторы языка. Тернарный оператор или условный оператор (?:)](https://proglang.su/java/operators)

> Внимание! Стоит попробовать делить типы данных: `int` и `double`; потренироваться. Как себя ведут эти 
> операции в контексте Java?

    int a = 123;
    a++;
    System.out.println(a);  // 124

А так:

    a = 123;
    System.out.println(a++);    // 123
    System.out.println(a);      // 124

Т.е в строке `System.out.println(a++);` сначала выполняется команда, а потом `a` увеличивается на 1-цу.
Или по другому, приоритет операции инкремента (постфиксного) `a++` ниже приоритета операции вывода на консоль.

Инкремент (префиксный) можно также написать:
    
    a = 125;
    System.out.println(++a);    // 126
    System.out.println(a);      // 126

> Теперь приоритет выполнения операции инкремента выше чем операция вывода в консоль.

#### Недобросовестные интервьюеры.

Спрашивают:

    a = 123;
    a = a-- - --a;
    System.out.println(a);  // 2
    a = --a - a--;
    System.out.println(a);  // 0
    a = --a-a--;
    System.out.println(a);  // 0

[Javarush. Приоритет операторов.](https://javarush.ru/quests/lectures/questmultithreading.level01.lecture01)

> Я не понял, почему `а = 2`? У меня `a = 1`. [Объяснение](https://skillbox.ru/media/base/inkrement_i_dekrement_v_java/).

Объяснение `a = a-- - --a;`. Порядок вычисления операций в Java слева направо.
1. на место уменьшаемого `а--` подставляется 123;
2. а уменьшается на 1-цу;
3. в вычитаемом `--a` сначала вычитается 1-ца: 122 - 1 = 121;
4. теперь выражение перед операцией вычитания имеет вид `a = 123 - 121`, а = 2.

>  Тогда входным значением переменной для вычисления каждого последующего инкремента или декремента будет 
> значение этой переменной после вычисления предыдущего инкремента или декремента.
То есть инкременты/декременты в выражении обрабатываются не одновременно, а по очереди, порядок в которой 
> определяется ассоциативностью и приоритетом этих операторов в Java. 

#### Операции сравнения.
Классические операции сравнения для чисел:

    boolean f = 123 > 234;
    System.out.println(f);  // false

    boolean f = 123 <= 234;
    System.out.println(f);  // true
    
    boolean f = 123 != 234;
    System.out.println(f);  // true

> Для ссылочных типов данных операции сравнения не так очевидны. Не все подряд так можно сравнивать.

#### Логические операции.
[Логические операторы в Java](https://javarush.ru/groups/posts/logicheskie-operacii-v-java)

* ||, OR-  дизъюнкция.
* &&, AND - конъюнкция
* ^, XOR - строгая дизъюнкция, исключающее ИЛИ. Истина тогда, когда строго одно из должно быть истина.

> По простому, если один оператор `&` или `|` - проверяется оба выражения, и левое, и правое. При условных 
> операторах `&&` правое выражение проверяется только если `левое = true` и `||` - правое выражение проверяется 
> только если `левое = false`.

Приоритет логических операторов:
1. !
2. &
3. ^
4. |
5. &&
6. ||

#### Побитовые операции.

Побитовые операции, или побитовые сдвиги используются редко.

    int a = 8;      // 1000 - в битах
    // a = a << 1;  // 10000
    // System.out.println(a);   // 16
    System.out.println(a << 1); // 16
    
    a = 18;      // 10010 - в битах
    // a = a >> 1;  // 1001
    // System.out.println(a);   // 9
    System.out.println(a >> 1); // 9

Задачка на собесе:

    int b = 5;
    int c = 2;
    System.out.println(a | b);  // 7
    // 101 - 5
    // 010 - 2
    // 111 - 7

    System.out.println(b & c);  // 7
    // 101 - 5
    // 010 - 2
    // 000 - 0
    
    System.out.println(b ^ c);  // 7
    // 101 - 5
    // 010 - 2
    // 000 - 0

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
    

    s = "qww1"; // длина 4, 0..3
    i = s.length() >= 5 & s.charAt(4) == '1'; // false && false
    System.out.println(i); // Exception

> Если строка длиной будет меньше, то программа вылетит с ошибкой `Exception`.

### Массивы.

    int[] arr = new int[10];
    System.out.println(arr.length); // 10
    System.out.println(arr[3]); // 0

По умолчанию, все элементы массива присваиваются значения: для чисел `0`, для символов (char) `пустой символ`, 
для строк `null`, для ссылочных типов и классов тоже `null`, для boolean это `false`.
    
    arr = new int[] {1, 2, 3, 4, 5};
    System.out.println(arr.length); // 5
    System.out.println(arr[3]); // 4

Если определить массив, но не инициализировать:

    int[] arr;

> На собеседовании могут спросить, а можно так:

    int brr[];

К сожалению, или к счастью, так можно написать, +/- отличия есть, но это позже. Это отссылки в сторону С++.

Базовый функционал также доступен через точку, например:

    brr.

#### Многомерные массивы.

    int[] crr[] = new int[3][5];
    
    for(int[] line : crr) {
        for(int item : line) {
            System.out.printf("%d", item);
        }
        System.out.println();
    }

Или:

    int[][] arr = new int[3][5];

    for(int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length; j++) {
            System.out.printf("%d", arr[i][j]);
        }
        System.out.println();
    }

Это не совсем двумерные массивы, это массивы массивов.

### Преобразования.

Есть неявное преобразование, как например, `int` положить в `double`. А есть явное - с указанием типов.

Для примитивов:

    byte -> short, short -> int, int -> long, long -> double
    char -> int, int -> float, int -> double, long -> float

    int i = 123; double d = i;      // неявное преобразование
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
    
    b = Byte.parseByte("1234");
    System.out.println(b); // NumberFormatException: Value out of range

Например, явное преобразование `b = Byte.parseByte("1234");`. Сначала пишешь тип данных, класс-обертка `Byte`, 
точка `.` и метод, который доступен для применения. Но, здесь могут ожидать проблемы, если задумать преобразование:

    byte b = Byte.parseByte("1211"); 

> Тип `Byte` может хранить значения до 255. Выйдет ошибка `NumberFormatException: Value out of range. Value:"1234" Radix:10`. Далее это надо обрабатываать исключениями.
По исключениям, вроде должен быть модуль обучения.
Нужно стараться писать код, который чтобы не "валился" на таких тривиальных ошибках.

Сергей говорит, что в 95% случаев программисты используют `int` для целочисленных и `double` для вещественных 
данных, потому-что так меньше вероятности нарваться на такие, так сказать детские ошибки.

Java испоьзуется на серверах, поэтому типа "просто дайте нам сколько-нибудь памяти" - это очень сложно. 
При использовании сервиса многими пользователями: 10-ки, 100-ни, 1000-чи; каждому выделять много памяти невозможно.

#### Ковариантность и контрвариантность.

Есть массивы. Но! Если определить массив целых чисел, например, из 10 чисел типа `integer` - нельзя взять 
массив `double` и в него положить массив `a`. Технически, через определенные преобразования так можно сделать, 
т.е. явно написать метод, который на вход принимает массив `integer`, а на выходе получить массив `double`. 
Так сделать можно. Но, технически может такая ситуация возникнуть в более поздних стадиях работы с ссылочными 
типами. Наперед говоря, тема очень-очень непростая. 

    int[] a = new int[10];
    double[] d = a;     // Изучаем

Можно почитать по теме: инвариаты типов, ковариантность и контравариантность.

В курсе GB "ООП" возможно будет рассмотрена эта тема.

> Важно! Просто так массив целых чисел нельзя положить в массив вещественных чисел.

### Получение данных из терминала

C Java получение данных из строки терминала посложнее, чем с Python


Для получения значения из терминала сначала импортировать `import java.util.Scanner`. Определяем 
объект `iScanner` типа `Scanner`, он также является переменной, он как говорит, Сергей, правильней назвать 
"экземпляр класса `Scanner`", где в качестве аргумента `System.in`.

Пример, для получения строковых данных:

    import java.util.Scanner;

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!", name);
        iScanner.close();
    }


`iScanner.nextLine()` - получение след строки, т.е. данные в ввиде строки, а далее в след строке кода - вывод на экран.

> Если при выводе с кодом `System.out.printf("Привет, %s!", name);` в терминале VSC, в конце строки 
> значок "%" виден - это проблема VSC, а так его не должно быть.
Можно применить Escape-последовательности, напр., `\n`:

    System.out.printf("Привет, %s!\n", name);

Пример, для получения целочисленных и вещественных данных:

    Scanner iScanner = new Scanner(System.in);
    System.out.printf("int a: ");
    int x = iScanner.nextInt();
    System.out.printf("double a: ");
    double y = iScanner.nextDouble();
    System.out.printf("%d + %f = %f", x, y, x + y);
    iScanner.close();

#### Проверка на соответствие получаемого типа.

Что делать, если в строке  получены невалидные данные?

    Scanner jScanner = new Scanner(System.in);
    System.out.printf("int a: ");
    boolean flag = jScanner.hasNextInt();
    System.out.println(flag);
    int i = jScanner.nextInt();
    System.out.println(i);
    jScanner.close();

> Сергей говорит, что при проверке введенных данных `flag` принимает, либо `true` - соответствует типу, 
> либо `false` - не соотвествует типу, но при проверке кода с вводом нецелочисленного типа данных, программа 
> вылетает с ошибкой.

###  Форматированный вывод.

Пример № 1: 

    int a = 1, b = 2;
    int c = a + b;
    String res = a + " + " + b + " = " + c;
    System.out.println(res);

Вопрос, который может быть на собеседовании.

    String s = "qwe";
    int a = 123;
    String q = s + a; // конканценация строк
    System.out.println(q);

Вопрос будет звучать: а что тут со строками? Сколько строк в данном случае получили?

Ответ. В строке `String q = s + a;` будет неявное преобразование `int a` в `string a`, будет где-то в памяти 
размещено. `s + a` - будет 3-я строка, временная. А потом из временной памяти строка `s + a` будет положена 
в строку `q`. Итого: 4-е строки.

Для чего нужен разбор такого случая? 
> Операция конкатенации для строк для строк опасна и може дать невероятную просадку по производительности.
Если где-то в коде есть в цикле такая попытка конкатенации строк - с вероятностью 100% этот код надо переписывать!
Эффект такой операции можно  наблюдать и на других ЯП: Python, C#, или на др. 

Для соответствующих операций есть соотвествующие типы, например, `StringBuilder`, который более шустро будет 
это производить.

    int a = 1, b = 2;
    int c = a + b;
    String res = String.format("%d + %d = %d \n", a, b, c);
    System.out.printf("%d + %d = %d \n", a, b, c);
    System.out.println(res);

В `String res = String.format("%d + %d = %d \n", a, b, c)` переменные: a, b, c подставляются по маскам `%d` 
на соответствующие позиции. Такой вариант форматирования подходит, если нужно положить необходимый формат куда-нибудь, 
напр., в переменную.

Для вывода в консоль использовать строку кода `System.out.printf("%d + %d = %d \n", a, b, c)`.

#### Спецификаторы для форматирования строк.

    %d: целочисленные значения
    %x: для вывода 16-тиричных чисел
    %f: для вывода чисел с плавающей точкой
    %e: для вывода чисел в экспоненциальной форме, напр., 3.1415е+01
    %c: для вывода одиночного символа
    %s: для вывода строковых значений

Если нужно какое-то кол-во знаков после запятой, напр., два то в `"%f\n` доб `.2`:

    System.out.printf("%.2f\n", pi) // 3.14

### Область видимости переменных.

Меньше чем `class` и метод `main` быть не может, тогда программа будет не рабочей.

    public class program {
        public static void main(String[] args) {
            int a = 132;
        }
    }

Переменная `int a = 132;` существует в контексте фигурных скобок `{ }`.

    public static void main(String[] args) {
        int a = 132;
        {
            int a = 222;
            System.out.println(a);
        }
    }

Такой вариант, выше, не сработает, выдаст ошибку `Dublicate local variable a`.

Блок кода:

    {
        int a = 222;
        System.out.println(a);
    }

...называют "сложным оператором".

Такой блок кода сработает:

    public static void main(String[] args) {
        {
            int a = 222;
            System.out.println(a);
        }
        int a = 132;
        System.out.println(a);
    }

Если представить уровни вложенности, напр., 

    {1 
        {2 
            {3 
            }
        }
    }

...то, переменная на 1-м уровне видна в остальных внутренних уровнях: 2, 3. А переменная, объявленная на 
3-м уровне будет видна на 3-м уровне и не видна на 2-м и 1-м.

Т.е. видимость распространяется внутрь, а не наружу.

Также можно определить переменную на уровне класса.

    public class program {
        static int t = 123;
        public static void main(String[] args) {
            int b = 111;
            {
                int a = 222;
                System.out.println(a+b); // 333
            }
            int a = 123;
            System.out.println(a);  // 123
        }
    }

Если переменная объявлена на уровне класса, то она будет доступна через имя класса. В некоторых источниках 
любят называть это глобальными переменными, но Сергей К. не стал бы вводить такое понятие.

> Есть [сервис](replit.com) в интернете, где прямо в браузере можно писать код и там он будет выполняться.

### Функции (методы).

Функции и методы - это технически одно и тоже. Функции могут не принаддежать классам, а методы принадлежат. 
В Java все функции являются методами.

**Описание**

**Вызов**

**Возвращаемое значение**

**Рекурсия**

Для описания какой-либо функции обязательно нужен класс, без класса ничего работать не будет. И пока 
использование ключевого слова `static`.

    public class Program {
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

        static void main(String[] args) {
            sayHi();    // hi!
            System.out.println(sum(1, 3));  // 4
            System.out.println(factor(5));
        }
    }

`public` - это модификатор доступа, технически надо добавлять, но вроде можно не описывать.

Можно поступить след. образом. Создать файл в том же каталоге, напр., `lib.java`, а в него добавлять функции.

    public class lib {
        static void sayHi() {
            System.out.println("hi!");
        }
    }

Теперь в коде можно подтягивать метод из файла `lib.java`:

    public class program {
        public static void main(String[] args) {
            lib.sayHi();
        }
    }

> Но торопиться это делать не надо, статика (static) - это плохо.

### Управляющие конструкции.

    int a = 1;
    int b = 2;
    int c;
    if (a > b) {
        c = a;
    } else {
        c = b;
    }
    System.out.println(c);

Операторы ветвления похожи на C#. Можно использовать сокр. форму:

    if (a > b) c = a;
    if (b > a) c = b;

#### Тернарный оператор

    int min = a < b ? a : b;
    System.out.println(min);

Объяснение. Если `a` меньше `b`, выражение ПРАВДА, то вернется значение после `?` и до `:`, иначе, если выр-е ЛОЖЬ, 
то вернется справа от `:`.

#### Оператор выбора, `switch`.

    int mounth = value;
    String text = "";
    switch (mounth) {
        case 1:
            text = "Autumn";
            break;
        ...
        default:
            text = "mistake";
            break;
    }
    System.out.println(text);
    iScanner.close();

Каждый `case` должен заканчиваться `break`. Есть необязательный блок `default`, он также должен заканчиваться `break`.

Может быть такая конструкция `switch`:

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

Объяснение. Выполнение кода будет проваливаться по `case'ам` с 1-го до 5-го, будут выполняться команды вывода, 
дойдя до `break`, закончит выполнять. Если нужного значения ключа не будет, то выполнится код в `case'е` `default`, 
при наличии. Т.е. при отсутствии `break`, будут выполняться `case'ы` без `break`.

Это может пригодиться, если нужно выполнение кода при определенном диапазоне ключей.

### Циклы.

В Java доступны следующие циклы:
* цикл `while`;
* цикл `do while`;
* цикл `for`, его модификация `for in`.

Циклы: `while`, `do while`, `for` в классическом представлении они взаимозаменяемы. Есть модификация цикла `for`, 
которая определяется сниппетом `foreach`, или его наз. `for in`, который работает для перебора коллекций, или др. 
итерируемых объектов. (Паттерн итератор).

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
    
#### Операторы управления циклами.

* `continue` - выполнение следующей итерации цикла;
* `break` - прерывание текущей итерации цикла.

*ближайшего к оператору.

    for (int i = 0; i < 10; i++) {
        if (i % 2  == 0)
            continue;
        System.out.println(i);  // 1 3 5 7 9
    }

Как работает этот цикл с `continue`? Если число четное `i % 2  == 0`, то вернись в строку `for (...)` 
к инкременту `i++`, проверь условие `i < 10` и делай дальше.

> Скобки `{}` надо писать, но для одного оператора их писать необязательно.

    for (int i = 0; i < 10; i++) {
        if (i % 2  != 0) {
            break;
        }
        System.out.println(i);  // 0
    }

В цикле выше когда `i = 1`, то сработает условие и оператор `break` прервет выполнение цикла.

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 5; j++) {
            break;  //  break-1
        }
        break;  // break-2
    }

Выше, `break-1` прерывает внутренний цикл с `j`, а внешний c `i` не прерывается. Для прерывания внешнего 
цикла `break-2`.

> Важное замечание! В некоторых случаях те, кто будут ревьюрить (проверять) код, могут надавать по голове. 
> Почему? Дело в том, что использование операторов `continue` и `break` - это неявная отсылка к оператору 
> безусловного перехода `goto`. Использование оператора `goto` в своем коде считается `"быдлокодингом"`. 
> И если кто-то увидит в коде этот оператор `goto` дело может дойти до увольнения.

Поэтому там, где можно обходится без `break` и `continue` - лучше обойтись без них. Но бывают ситуации, либо код 
становится сложным, либо необоснованно писать какой-то "непонятный" код, он будет большой, в данном случае можно 
ограничиться простым оператором, чтобы прервать цикл.

В то же время, можно заменить `for` на `while` и делать проверку по условию.

Операторы `break` и `continue` они есть, но за них могут не похвалить.

Цикл `for`:

    int s = 0;
    for (int i = 0; i <= 10; i++) {
        s += 1;
    }
    System.out.println(s);  // 11

Вложенный цикл `for`:

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

Вложенные циклы справедливы также для: `while`, `do while`; их можно комбинировать.

> Вложенные циклы можно делать любой глубины, но нежелательно больше 2-х, а больше - это намек на использование 
> рекурсии.

Для коллекций можно исп. такой цикл `for`:

    int arr[] = new int[10];
    for (int item : arr) {
        System.out.printf("%d ", item);
    }
    System.out.println();
    // 0 0 0 0 0 0 0 0 0 0

#### Цикл `foreach`.

    int[] brr = new int[] {1, 2, 3, 4, 5, 77};
    for (int item : brr) {
        System.out.print(item);
    }
    System.out.println();
    // 1234577

Работа цикла была с коллекцией, в этом случае с массивом.

В цикле `for` обращение к элементам массива происходит через индексы:

    arr[i] = 10;

Цикл `foreach` (`for in`) через `item` не работает с элементами массива.

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

Выше показано, что может быть иллюзия, как будто через `item` идет работа с массивом (эл-ты = 12), но видно, что 
эл-ты исходного массива `crr` не изменились. Получается, что работа в цикле `foreach` идет только с локальной 
переменной `item`. Здесь опять отсылка к области видимости переменных.

> C# такое, в принципе, не дает сделать итерируемыми объектами.

### Работа с файлами.

Будут простые примеры работы с файлами: как записать, как считать. Как работать с файлами в Java, более детально, 
- целые лекции: 
* Каким образом работать с конкретным типом файлов?;
* Как парсить эти файлы? (текстовые), но есть JSON, XML, HTML,... .

Создание/запись/до запись:

    import java.io.FileWriter;
    import java.io.IOException;

    try (FileWriter fw = new FileWriter("file.txt", false)){
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

Содержимое `file.txt`:

    line 1
    2
    line 3

В общем, надо импортировать:
* java.io.FileWriter;
* java.io.IOException.

`try {} catch {}` - для обработки ошибок.

Определяем экземпляр `fw` класса `"FileWriter"`, который нужно идентифицировать при помощи так называемого 
конструктора `new`, где в качестве конструктора передается имя будущего файла `file.txt` и аргумент `true/false` 
в зависимости нужно/(не нужно) дописывать файл. Т.е. если дописывать (`true`), тогда будет попытка найти имеющийся 
файл, то он будет дописываться, а если его не существует, то будет создан новый файл. А если явно не указываем 
дописывать (`false`), тогда если файл существует на диске, куда мы указали, то он будет удален и создан новый, или 
по другому перезаписан.

* `fw.write()`, `fw.append()` - запись, добавление в файл
* `fw.flush()` - метод для записи файла, так можно обойтись в некоторых случаях.

В большинстве случаев надо будет ещё закрывать файл.

Т.к. при записи файлов может повылезать куча ошибок, напр.: запись в каталог с правом только для чтения; кривой файл; 
файл, который нельзя перезаписывать и т.д. Соответственно, надо эти ошибки как-то обрабатывать. В данном примере, 
для отлавливая ошибок исп.-ся `try {} catch (IOException ex){}`. 

С этими тонкими моментами обязательно надо отдельно работать, каждую из этих ошибок, в которых случаях обрабатывают 
отдельно. Для программ существует логирование, почему программа вылетела? 

#### Чтение из файла посимвольно.

    import java.io.*;

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("file.txt");
        int c;
        while ((c = fr.read()) != -1) {
            char ch = (char) c;
            if (ch == '\n') {
                System.out.print(ch);
            } else {
                System.out.print(ch);
            }
    }



#### Чтение файла построчно.
    import java.io.*;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        String str;
        while ((str = br.readLine()) != null) {
            System.out.printf("== %s ==\n", str);
        }
        br.close();
    }

`throws Exception` в описании метода означает, что метод может закончиться с ошибкой. Это упрощает чем 
с `try {} catch{}`. Здесь можно указывать как общую ошибку, так и явные ошибки и дальше в методе без `try {} catch{}`.

### Задачи для самоконтроля.

1. Задана натуральная степень k. Сформировать случайным образом список коэффициентов (значения от 0 до 100) многочлена. 
Многочлен степени k.

\*Пример: k = 2 => 2*x^2 + 4*x + 5 = 0 или x^2 + 5 = 0 или 10*x = 0

2. Даны два файла, в каждом из которых находится запись многочлена. Сформировать файл содержащий сумму многочленов.