package lecture03;

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








