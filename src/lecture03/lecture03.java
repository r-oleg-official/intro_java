package lecture03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.*;

public class lecture03 {

}

class Ex01_object {
    public static void main(String[] args) {
        Object o = 1; GetType(o);   // java.lang.Integer
        o = 1.2; GetType(o);        // java.lang.Double
    }

    static void GetType(Object obj) {
        System.out.println(obj.getClass().getName());
    }
}

class Ex02_object {
    public static void main(String[] args) {
        System.out.println(Sum(1, 2));      // 1.
        System.out.println(Sum(1.0, 2));    // 2.
        System.out.println(Sum(1, 2.0));    // 3.
        System.out.println(Sum(1.2, 2.2));  // 4.
    }
    static int Sum(int a, int b){return a + b;}
    static double Sum(double a, double b){return a + b;}
    static String Sum(String a, String b){return a + b;}
    static Object Sum(Object a, Object b) {
        if (a instanceof Double && b instanceof Double) {
            return (Object) ((Double) a + (Double) b);
        } else if (a instanceof Integer && b instanceof  Integer) {
            return (Object) ((Integer) a + (Integer) b);
        } else return 0;
    }
}

class Ex03_object {
    public static void main(String[] args) {
        int[] a = new int[] {1, 9};
        int[] b = new int[3];
        System.arraycopy(a, 0, b, 0, a.length);

        for (int i : a) { System.out.printf("%d ", i); }    // 1 9

        for (int j: b) { System.out.printf("%d ", j); }
        // 0 9 0 0 0 0 0 0 0 0
    }
}

class Ex04_object {
    static int[] AddItem(int[] array, int item) {
        int length = array.length;
        int[] temp = new int[length + 1];
        System.arraycopy(array, 0, temp, 0, length);
        temp[length] = item;
        return temp;
    }
    public static void main(String[] args) {
        int[] a = new int[] {0, 9};
        for (int i : a) { System.out.printf("%d ", i); }    // 0 9
        a = AddItem(a, 2);
        a = AddItem(a, 3);
        for (int j : a) { System.out.printf("%d ", j); }    // 0 9 2 3
    }
}

class  Ex05_ArrayList {
    public static void main(String[] args) {
        // List list = new ArrayList(); // через Object
        // or
        // ArrayList list = new ArrayList();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2809);

        for (Object o: list) {
            System.out.println(o);
        }
    }
}

class  Ex06_Method {
    public static void main(String[] args) {
        int day = 29;
        int month = 9;
        int year = 1990;
        Integer[] date = {day, month, year};
        List<Integer> d = Arrays.asList(date);
        System.out.println(d);  // [29, 9, 1990]
        }
}

class  Ex07_ArraysMethod {
    public static void main(String[] args) {
        StringBuilder day = new StringBuilder("29");
        StringBuilder month = new StringBuilder("9");
        StringBuilder year = new StringBuilder("1990");
        StringBuilder[] date = new StringBuilder[]{day, month, year};
        List<StringBuilder> d = Arrays.asList(date);
        System.out.println(d);  // [29, 9, 1990]
        date[1] = new StringBuilder("09");
        System.out.println(d);  // [29, 09, 1990]
    }
}

class  Ex08_ListOf {
    public static void main(String[] args) {
        Character value = null;
        List<Character> list1 = List.of('S', 'e', 'r', 'g', 'e', 'y');
        System.out.println(list1);
        // list1.remove(1);     // java.lang.UnsupportedOperationException
        List<Character> list2 = List.copyOf(list1);
        System.out.println(list2);
    }
}

class  Ex09_ListOf {
    public static void main(String[] args) {
        Character value = null;
        List<Character> list1 = new ArrayList<Character>();
        list1.add('S');
        list1.add('e');
        list1.add('r');
        System.out.println(list1);
        list1.remove(1);
        List<Character> list2 = List.copyOf(list1);
        System.out.println(list2);
    }
}

class  Ex10_Iterator {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 12, 123, 1234, 12345);

        for (int item: list) {
            System.out.println(item);
        }

        Iterator<Integer> col = list.iterator();
        System.out.println();

        while (col.hasNext()) {
            System.out.println(col.next());
            //col.next();   // java.util.NoSuchElementException
            //col.remove();   // java.lang.UnsupportedOperationException
        }
    }
}




