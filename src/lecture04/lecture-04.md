## Lecture 4. Хранение и обработка данных ч1: приоритетные коллекции

### План

1. Разобраться, зачем нужно столько коллекций и JCF
2. LinkedList и особенности работы с ним
3. Узнать о списках, как об абстрактной структуре
4. Проблемы работы со списками и массивами
5. Построение разных Queue и как в этом помогает JCF
6. Deque и логика использования этой коллекции
7. То, что мертво, умереть не может - Stack в контексте JCF

Первая коллекция будет LinkedList. В зависимости от того как данные хранятся в памяти ПК, в одном случае доступ 
осуществляется быстрее, в другом случае медленнее. У разных типов коллекций осуществляется по-разному чтение данных.
Т.е. там где максимально часто будет использоваться получение данных - хранение выгодно в одной структуре, а когда 
добавлять/удалять данные - выгоднее в другой структуре. Примерно для этого коллекции и нужны. 

След. момент: каким образом каким образом будет обработка данных? Напр., нужно чтобы данные шли "паровозиком" друг за 
другом. Возможно потребуется обработка данных с каким-то приоритетом: не важен порядок данных, а извлекать надо строго в
определенном порядке (возрастание/убывание). 

В некоторых случаях может потребоваться извлечение тех данных, которые 
добавлены в последнюю очередь. Такая задача, напр., при использовании теории графов.

### LinkedList
Представляет собой двусвязный список, по теории алгоритмов. Это короткое определение. 

Прежде чем начать разбираться что такое двусвязный список? Нужно разобраться что такое список?

**Список** - гибкая структура данных, позволяющая легко менять свой размер. Элементы доступны для вставки, или удаления в 
любой позиции.
В контексте теории алгоритмов, список - такая структура дял которой точно известно что на текущем этапе, что на след. 
этапе. Каждый след. эл-т знает что после него и т.д. Т.е. сразу обратиться к 10-му эл-ту списка невозможно, надо 
сначала обратиться к 9-му эл-ту, а для 9-го нужно обратиться к 8-му эл-ту и т.д. Другими словами, нужно просмотреть все 
эл-ты до нужного. 

Это может показаться сложным, это может показаться долгим с точки зрения чтения - оно так и есть.
> С точки зрения чтения, это сложная операция.

У структуры "список" есть положительные моменты.

Размещение массива в памяти. В управляемой куче `STACK` определяется имя переменной-ссылки массива, напр., `list`. 
Указали `new int`. В неуправляемой куче `HEAP` данные разместились по порядку, т.е. эл-ты идут стандартно друг за 
другом. Можно работать. 0:06:09.  

В случае со списком. В `STACK` определяется имя переменной-ссылки массива, напр., `list`. Указали `new int`. В `HEAP` 
данные могут разместиться не по порядку. 

##### Добавление элемента в массив
Напр., есть массив из 3-х эл-тов. Данные 3-х эл-тов будут по порядку храниться в `HEAP`, друг за другом: `d1, d2, d3`. 
Нужно добавить еще эл-т `d4`. Допустим, в памяти другое ПО успело добавить свой массив: `v1, v2`. 
1. Сначала после `v2` будет выделена область памяти на 4-е эл-та;
2. будут скопированы эл-ты `d1, d2, d3` в новый участок памяти;
3. ссылка `list` будет заменена на новый участок памяти;
4. добавится `d4`. Вид области памяти на данном этапе получится `d1, d2, d3, v1, v2, d1, d2, d3, d4`; 
5. старый участок памяти до `v1` с `d1, d2, d3` будет очищен.

##### Удаление элемента массива
Есть массив из 6 эл-тов `d1, d2, d3, d4, d5, d6`. Надо удалить `d2`. Классический пример удаления - это паровозиком 
тянуть след эл-т на место предыдущего до хвоста массива.
1. в `d2` положим `d3`;
2. в `d3` положим `d4`;
3. в `d4` положим `d5`;
4. в `d5` положим `d6`.

После этого технически выделяется кусок памяти на 1 эл-т меньше чем есть сейчас. Потом поэлементно из старого участка 
памяти копируются данные в новый участок. Потом заменить ссылку на новый участок памяти.

Для самостоятельного занятия можно написать такой код для копирования/удаления эл-тов массива. Засечь время выполнения. 
Размер массива задавать не 10, а 1 млн, 10 млн эл-тов. Попробовать удалить эл-т не в хвосте, а напр., 4-й. 0:08:47
Попробовать сделать эту операцию не 1 раз, а для 1 млн пользователей. 

После замера времени выполнения с таким функционалом на массиве, попробовать то же самое с `LinkedList`.

Говоря про `LinkedList`, речь будет про абстрактный список, структура данных (список), на основе которого, скорее на 
части строится `LinkedList` - коллекция Java. У нас есть список `list`, он размещен в памяти. Если нам нужен список, то 
знаем, где находится минимум один эл-т. Сам эл-т хранит в себе значение данных и что идет после него, т.е. ссылку на 
след эл-т. Гарантии нет, что след участок памяти свободен, он может быть занят данными другого ПО. В этом случае ОС в 
связке с вирт машиной Java найдут свободный участок памяти и этот участок будет использован для след эл-та. Информация 
о том, где будет размещен след эл-т будет записана в участке памяти предыдущего эл-та. И т.д. Примерно так строится 
структура данных типа "список". 0:10:53.

##### Добавление элемента в список
Напр., есть список `d1, ..., d5`. Надо добавить данные `T` после `d2`. 
`STACK`: `list` <br>
`HEAP`: `d1, T, ..., d2, ..., d5, d3, ..., d4` <br>

В этом случае в `d2` содержится ссылка на `d3`. Надо поменять ссылку на `T`. Потом в `T` записать ссылку на `d3`. 

> Вся операция свелась к простой замене ссылок.

##### Удаление элемента из списка
Удаление эл-та списка аналогичен добавлению эл-та в список, т.е. заменой ссылок.

А далее ВМ Java вычистит эл-т из памяти. Это будет не моментально. Никто на самом деле не знает когда это будет 
происходить. Но это произойдет в очередной сборке мусора. 

> Мусор - это никак не используемые данные в ячейках оперативной памяти.

За сборку мусора отвечают определенные объекты, в частности `Garbage Collector`.

> Собеседование. На тему `Garbage Collector` могут развести большую дискуссию. Нужно помнить про `Garbage Collector` и 
> о его работе тоже нужно иметь представление. В общем случае, теории больше чем достаточно.

##### Достоинства/недостатки

Понимая, как данные добавляются в массив, как в список - можно понять какая структура данных выгоднее.

> Когда будет добавление/удаление данных - список выгоднее.
> 
> Когда постоянно считывать данные - выгоднее массив.

Почему список проблемнее? Когда список из 1 млн эл-тов. Чтобы получить доступ к 1 млн-му эл-ту нужно прийти из 
предыдущего. А в предыдущий прийти из его предыдущего. Таки образом, чтобы дойти до 1 млн-го эл-та - нужно проделать 
1 млн операций. Это сложно, это долго.

> Если нужно вывести эл-ты списка в обратном порядке - эта операция будет долго выполняться.

Но есть определенные хитрости. Есть такая структура данных `Двухсвязный список`.

> Отличие "односвязного" списка от "двухсвязного" - хранится информация о след эл-те и о предыдущем.

Если в "односвязном" списке есть информация что идет после последнего эл-та и этим эл-том является 1-й эл-т - 
`циклический односвязный список`.

Если "двухсвязном" списке есть информация, что после последнего эл-та идет 1-й, а перед 1-м идет последний - 
`двунаправленный циклический список`.

#### LinkedList. Вывод.
LinkedList нужен для небольшого количества элементов, в которых операции добавления/удаления встречаются чаще операций 
чтения.

Таким образом хранятся данные в `LinkedList`, а весь функционал как у классического `List` (`ArrayList`).


    import java.util.LinkedList;

    public class Ex001_LinkedList {
      public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println(ll);
      } }

### Коллекция Queue. 0:15:22
`Queue` работает по принципу `FIFO` (First-In-First-Out), первым пришел - первым уйдет. 

В плане обработки:

    import java.util.Queue;
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
    }

Указываем `Queue`, закрываем обобщение `Integer` и указываем что это будет новый `LinkedList`. Это интересный подход, 
может показаться страшным, основан на `LinkedList`. Добавление эл-та `1` в очередь `queue`:

    queue.add(1);

> Никто не гарантирует что элементы в памяти будут располагаться поочереди друг за другом.

Извлечение эл-та из очереди:

    int item = queue.remove();

Будет извлечен и удален 1-й эл-т в очереди. После извлечения эл-та(ов) из очереди и последующее добавление в очередь 
нового - этот эл-т в памяти может располагаться где угодно.

Здесь отдельного внимания заслуживает, если хотим извлечь эл-т из пустой очереди - в таком случае ждет исключение 
`java.util.NoSuchElementException`. Есть механизмы, позволяющие извлечь данные без получения этой ошибки, или 
посмотреть что будет извлекаться. Этот функционал есть на слайде презентации.

Посмотрев на схему иерархий коллекций можно посмотреть на иерархию, которая справедлива для `queue`:

**Queue**:
1. **Deque** - наследуется от **Queue**
   - **LinkedList** - наследуется от **Deque**
   - **ArrayDeque** - наследуется от **Deque**
2. **AbstractQueue** - наследуется от **Queue**
   - **PriorityQueue** - наследуется от **AbstractQueue**

Можно посмотреть чем отличается классическая `Queue` от `PrioriyQueue`?

### PriorityQueue

Наивысший приоритет имеет "наименьший" элемент. В классической очереди эл-ты извлекаются в порядке добавления, то для 
`PriorityQueue` тот эл-т который меньше, тот и будет извлечен раньше. 

> Но понятие "меньше" оно для всех типов данных достаточно "нестандартное". 

Если взять числа, то известно кто из них меньшее. Если взять два абстрактных объекта, напр., очередь наполняется 
котиками. Вопрос: какой котик будет считаться меньше чем другой? Это все нужно описывать руками, этот раздел будет 
дальше когда будет описание типов.

      import java.util.PriorityQueue;

      class Ex003_PriorityQueue{
         public static void main(String[] args) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(123);
            pq.add(3);
            pq.add(13);
            pq.add(1);
            System.out.println(pq);
            System.out.println(pq.poll());
            System.out.println(pq.poll());
            System.out.println(pq.poll());
            System.out.println(pq.poll());
            System.out.println(pq.poll());
         } }
      // [1, 3, 13, 123]
      // 1
      // 3
      // 13
      // 123
      // null

### Deque 0:19:53

**Deque** - double ended queue.
 
Основной принцип: можно добавлять данные как в начало, так и в конец. Также извлекать.

      import java.util.Deque;
      
      class Ex004_Deque{
         public static void main(String[] args) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.addFirst(1);
            deque.addLast(2);
            deque.removeLast();
            deque.offerFirst(1);
            deque.offerLast(2);
            deque.pollFirst();
            deque.pollLast();
            deque.getFirst();
            deque.getLast();
            deque.peekFirst();
            deque.peekLast();
         } }


### Stack

Кроме предыдущих коллекций есть такая структура данных `Stack`, она занимает свое место в иерархии все коллекций Java.

**List**:
1. **ArrayList** - наследуется от **List**
2. **Vector** - наследуется от **List**
   - **Stack** - наследуется от **Vector**
3. **LinkedList** - наследуется от **List**

`Stack` работает по принципу: те данные которые пришли ранее будут обработаны в последнюю очередь. 
`FILO (First-In-Last-Out)`. Расширяет `Vector` 5-ю операциями, которые позволяют рассматривать вектор как стек.

Альтернативой `Stack` может быть рекурсия за одним исключением. Когда рекурсия начинает погружаться в саму себя то 
требует очень много ресурсов. Для стека такое кол-во ресурсов не требуется. 

Пример решения задачи с помощью `Stack`.
Вычислить значение выражения в постфиксной форме записи.

Здесь не рассматривается как получается матем-е выражение в постфиксной форме записи. Здесь речь о том, что когда есть 
такая форма, попробуем её вычислить.

Можно погрузиться в теорию алгоритмов и посмотреть как можно получить `постфиксную` форму записи из обычной 
(`инфиксной`)? Существует ещё `перфиксная` форма записи и с постфиксной они +- одинаковые.
Есть ещё `обратная польская запись`, `прямая польская запись` - одно и тоже. 0:22:00

Пример: 
* __1 + 2 * 3__ и __(1 + 2) * 3__ - инфиксная запись
* __1 2 3 * +__ и __1 2 + 3 *__ - постфиксная запись.

Не нужно думать, что это не логично, непонятно. Для ПК нужно составить такой алгоритм, который будет просто и быстро 
выполняться.

##### Алгоритм вычисления записи при помощи постфиксной записи и `Stack`
1. __1 2 3 * +__. Stack: null
2. `1` добавляем в `Stack`. __2 3 * +__.   Stack: __1__
3. `2` добавляем в `Stack`. __3 * +__.     Stack: __1 2__
4. `3` добавляем в `Stack`. __* +__.       Stack: __1 2 3__
5. Когда появляется какая-то операция, то нужно извлечь из стека 2 эл-та, применить операцию и обратно положить в 
`Stack`. 
   * извлекаются `3` и `2`
   * операция `*`, получается `6`
   * положить обратно в `Stack`. __+__.   Stack: __1 6__
   * извлекаются `6` и `1`
   * операция `+`, получается `7`
   * положить обратно в `Stack`. Запись пуста. Stack: __7__

По итогу, в `Stack` будет находиться единственный эл-т, который является результатом арифметического выражения.

      class Ex005_Stack{
         public static void main(String[] args) {
           var exp = "1 2 3 * +".split(" ");                     // 1 + 2 * 3
           // var exp = "1 2 3 * 4 * + 10 5 / * 20 -".split(" ");   // (1 + 2 * 3 * 4) * (10 / 5) - 20
           // var exp = "20 30 - 10 *".split(" ");              // (20 -30) * 10

           int res = 0;
        
           Stack<Integer> st = new Stack<>();
           for (int i = 0; i < exp.length; i++) {
               if (isDigit(exp[i])) {
                   st.push(Integer.parseInt(exp[i]));
               } else {
                   switch (exp[i]) {
                       case "+":
                           res = st.pop() + st.pop();
                           st.push(res);
                           break;
                       case "-":
                           res = -st.pop() + st.pop();
                           st.push(res);
                           break;
                       case "*":
                           res = st.pop() * st.pop();
                           st.push(res);
                           break;
                       case "/":
                           res = st.pop() / st.pop();
                           st.push(res);
                           break;
                       default:
                           break;
                   }
               }
           }
           System.out.printf("%d\n", st.pop());
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    } }

В исходниках кода есть небольшая ошибка. Она связана с порядком извлечения данных. Можно потренироваться. Можно 
попробовать добавить дополнительную операцию, напр., возведение в степень. Или добавить унарную операцию: sin(), cos().
Самая основная проблема будет не столько в вычислении арифметического выражения, сколько как красиво разобрать строку, 
чтобы получить саму функцию и то что стоит аргумент этой самой ф-ции. А что будет если `sin(x^2)`? 

### Итоги
Известно достаточно коллекций, чтобы заниматься программированием, используя коллекции.

> Коллекция `Stack` -  является устаревшей, вместо неё лучше использовать `Deque`.

В качестве тренировки можно взять `Stack` заменить на `Deque`.

Почему была рассмотрена коллекция `Stack`? Java - кроссплатформенный ЯП и реализована в нем обратная совместимость всех 
версий. Это тот код, который был написан в 2010-м году он обязан работать и сейчас. В то же время есть достаточно 
большое кол-во сервисов, которые были когда-то написаны и работают сейчас. А как говорится: "если работают - зачем это 
переделывать"? Поэтому в практике можно столкнуться со старым кодом. Напр., если будет задача переписать код, то, зная 
что такое `Stack`, будет известно на что его заменить и как с этим работать.
