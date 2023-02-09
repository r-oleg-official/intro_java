## Integer.

* Лекция 3: Примитивные типы данных и операторы для работы с ними. 3.3. 
Основные операторы для работы с целочисленными величинами 
[src](https://intuit.ru/studies/professional_skill_improvements/2155/courses/425/lecture/9669?page=2)


## String.

String - ссылочный тип.

Удаление пробелов в начале и в конце строки:

    s.trim()

Удаление пробелов, табуляции и прочего [см](https://russianblogs.com/article/2710607378/):

    public class StringUtils {
 
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
	public static void main(String[] args) {
		System.out.println(StringUtils.replaceBlank("just do it!"));

Удалить последний символ из конца строки в Java [src](https://webcache.googleusercontent.com/search?q=cache:L-ZQFxQZcMoJ:https://www.techiedelight.com/ru/remove-last-character-from-string-end-java/&cd=1&hl=ru&ct=clnk&gl=ru&client=firefox-b-lm):

    public class Main
    {
        public static String removeLastChar(String str) {
            if (str == null || str.length() == 0) {
                return str;
            }
            return str.substring(0, str.length() - 1);
        }
 
        public static void main(String[] args) {
            String str = "Java8";
            System.out.println(removeLastChar((str)));        // Java
        }


## Predefined Character Classes. Предопределенные классы символов.

[src](https://docs.oracle.com/javase/tutorial/essential/regex/pre_char_classes.html).

* . 	Any character (may or may not match line terminators)
* \d 	A digit: [0-9]
* \D 	A non-digit: [^0-9]
* \s 	A whitespace character: [ \t\n\x0B\f\r]
* \S 	A non-whitespace character: [^\s]
* \w 	A word character: [a-zA-Z_0-9]
* \W 	A non-word character: [^\w]

## Circles.
### 1. for. Snippet - `fori`

    for (int i = 0; i < size_iterable_object; i++) {
            block_code;
        }

### 2. for each. Snippet - `foreach`
    
    for (type var: iterable_object) {
        block_code;
    }

Other form:

    for (int i:
         iterable_object) {
        block_code;
    }

## Arrays.
### Одномерные массивы.
#### Объявление массива.

    int[] arr = new int[arr.length];
    int[] arr = new int[3]{1, 2, 3}; // new int[] - так не обязательно
    int[] arr = {1, 2, 3};
    
    
> Означает отсутствие элемента. У массива есть вместимость (capcity) и фактическое кол-во элементов, 
> вы возвращаете второй. Все, что после того, что вы вернули считается мусором.
    
Если нужен символ, то к нему обращаются:
    
    s.charAt(2)

Получение значения эл-та массива в `String` с индексом `2`:

    String.valueOf(array[2])

### Двумерные массивы.
#### Объявление массива.
    
    int[][] arr = new int[3][5];

## Списки. ArrayList.
* [Класс ArrayList](https://javarush.ru/groups/posts/klass-arraylist)
* [Удаление элемента из списка ArrayList](https://javarush.ru/groups/posts/1935-udalenie-ehlementa-iz-spiska-arraylist)

## List.
### Methods.
* **.size()** - размер списка
* **.get(i)** - получить значение i-го эл-та 

### Copy List.
#### 1. Collections.

      List<Integer> destination = Arrays.asList(1, 2, 3, 4, 5);
      List<Integer> source = Arrays.asList(11, 22, 33);
      Collections.copy(destination, source);

#### 2. addAll()

    List<Integer> destination = new ArrayList<>();
    destination.addAll(source);

#### 3. Java 10

    List<Integer> destination = List.copyOf(sourceList);    

## Преобразования.

Для округления числа при выводе, напр., до 0,01:

	String.format("%.2f", number)
	
Немного [см](https://gb.ru/posts/java_round).
	
### Метод valueOf() [см](https://proglang.su/java/numbers-valueof)
    
    Integer x = Integer.valueOf(9);
    Double c = Double.valueOf(5);
    Float a = Float.valueOf("80");               
    Integer b = Integer.valueOf("444",16);

    System.out.println(x); 
    System.out.println(c);
    System.out.println(a);
    System.out.println(b);

### Возвращаемое значение
* valueOf(int i): возвращает целочисленный объект, содержащий значение указанного типа.
* valueOf(String s): возвращает объект Integer, содержащий значение указанного строкового представления.
* valueOf(String s, int radix): возвращает целочисленный объект, содержащий целое значение указанного строкового представления, разобранного со значением системы счисления.


## Files.

Вывод в файл: 

    FileWriter writer = new FileWriter("file.txt", false))
    {
            writer.write("hello");
            writer.flush();
    }

## Map. Карта/словарь.
Пример карты, где ключ - `Integer`, значение - `String`:

    Map<Integer, String> map = new HashMap<>(); // пустая карта
    Map<String, String> map = new HashMap<>(other_collection); // 

Пример. В словарь `counter` добавить ключ = имя, значение = кол-во дубликатов имен в словаре `phonebook`. 
`Collections.frequency(list_for_find, finding_value)`:

    counter.put(name, Collections.frequency(phonebook.values(), name));

Пример, перебор HashMap в цикле. Словарь `example`. Интерфейс `Map.Entry` - обозначает как раз пару “ключ-значение” 
внутри словаря. Метод `entrySet()` возвращает список всех пар в нашей HashMap (поскольку наша мапа состоит как раз из 
таких пар-`entry`, то мы перебираем именно пары, а не отдельно ключи или значения).

    for (Map.Entry entry: example.entrySet()) {
        System.out.println(entry);
    }

Вывод:

    ke1=value1
    ke2=value2

Пример, какие элементы списка `ArrayList<>(example)` дублируются и сколько раз в `map`. `entry` - пара из словаря 
`key=value`. `entry.getKey()` - получить ключ пары. `Collections.frequency(example, entry.getKey())` - счетчик 
совпадений ключа в списке `example`.

    for (Map.Entry entry: map.entrySet()) {
        int count = Collections.frequency(example, entry.getKey());
        if (count > 1) System.out.printf("%s -> %d\n", entry.getKey(), count);
    }

### TreeMap.

#### Sort TreeMap.
Пример упорядочивания значений `map` по убыванию, где `list` - упорядоченный список. 

    import java.util.stream.Collectors;

    List<Map.Entry<String, Integer>> list = map.entrySet().stream()
    .sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
    .collect(Collectors.toList());

Другой пример с приведением типов к `Integer` и `String`.

    TreeMap<Integer, String> names_sort = new TreeMap<>();
    for (Map.Entry entry: counter.entrySet()) {
        names_sort.put((Integer) entry.getValue(), entry.getKey().toString());
    }


#### Sources for Map.
1. [HashMap в Java— что за карта такая?](https://javarush.com/groups/posts/1940-klass-hashmap-)
2. [Сортировка TreeMap по значению (BigDecimal)](https://ru.stackoverflow.com/questions/647402/%d0%a1%d0%be%d1%80%d1%82%d0%b8%d1%80%d0%be%d0%b2%d0%ba%d0%b0-treemap-%d0%bf%d0%be-%d0%b7%d0%bd%d0%b0%d1%87%d0%b5%d0%bd%d0%b8%d1%8e-bigdecimal)
3. [TreeMap sort by value](https://stackoverflow.com/questions/2864840/treemap-sort-by-value)


## Validate data.

* Integer signum() Method in Java. [src](https://www.geeksforgeeks.org/integer-signum-method-in-java/);
* [Математическая функция "сигнум"](https://ru.stackoverflow.com/questions/25872/%D0%9C%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B0%D1%8F-%D1%84%D1%83%D0%BD%D0%BA%D1%86%D0%B8%D1%8F-%D1%81%D0%B8%D0%B3%D0%BD%D1%83%D0%BC);
* [Проверка на ввод только чисел](https://ru.stackoverflow.com/questions/409386/%D0%9F%D1%80%D0%BE%D0%B2%D0%B5%D1%80%D0%BA%D0%B0-%D0%BD%D0%B0-%D0%B2%D0%B2%D0%BE%D0%B4-%D1%82%D0%BE%D0%BB%D1%8C%D0%BA%D0%BE-%D1%87%D0%B8%D1%81%D0%B5%D0%BB);
* [Проверка ввода числа в Scanner](https://www.cyberforum.ru/java-j2se/thread2404821.html);
* [Проверка ввода в Java](https://webcache.googleusercontent.com/search?q=cache:BDf9m8_799gJ:https://www.delftstack.com/ru/howto/java/java-input-validation/&cd=3&hl=ru&ct=clnk&gl=ru&client=firefox-b-lm).

## Материалы.
#### LetCode.
1. [LeetCode(1-50). Answers.](https://russianblogs.com/article/6338350464/)
2. [LeetCode #27 - Remove Element](https://redquark.org/leetcode/0027-remove-element/)
   
### String.
1. [Удаление пробелов из строк в Java](https://overcoder.net/q/1962/%D1%83%D0%B4%D0%B0%D0%BB%D0%B5%D0%BD%D0%B8%D0%B5-%D0%BF%D1%80%D0%BE%D0%B1%D0%B5%D0%BB%D0%BE%D0%B2-%D0%B8%D0%B7-%D1%81%D1%82%D1%80%D0%BE%D0%BA-%D0%B2-java)
2. [Удалить все пробелы в строке в Java](https://russianblogs.com/article/2710607378/)
3. [Поиск, получение, удаление подстроки в String](https://javarush.ru/quests/lectures/questmultithreading.level02.lecture04)
4. 

### Regexet
1. [Регулярные выражения в Java](https://javarush.ru/groups/posts/regulyarnye-vyrazheniya-v-java)


1. [IntelliJ IDEA: стиль и форматирование кода](https://javarush.ru/groups/posts/2009-intellij-idea-stiljh-i-formatirovanie-koda)



[Работа со строками](https://metanit.com/java/tutorial/7.1.php)

[Java: как проверить, содержит ли строка подстроку](https://dev-gang.ru/article/java-kak-proverit-soderzhit-li-stroka-podstroku-0c4hoa1j3h/)

[Пишем поиск подстроки лучше, чем в учебниках](https://habr.com/ru/company/jugru/blog/491750/)

[Найти вхождения подстроки в строку в Java](https://www.techiedelight.com/ru/find-occurrences-of-substring-string-java/)
[Найти последнее вхождение подстроки в строке](https://proglang.su/java-examples/strings-last-occurance)


Code style:

* [Code Conventions for the Java TM Programming Language](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)
* [4.1. Рекомендуемый стиль кода](https://doc.cuba-platform.com/manual-latest-ru/recommended_code_style.html).
