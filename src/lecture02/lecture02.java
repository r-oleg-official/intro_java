package lecture02;

public class lecture02 {
    public static void main(String[] args) {
        stringBuilder();
        name();
    }

    public static void stringBuilder() {
        var s = System.currentTimeMillis();
        String str = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            str += "+";
            sb.append("+");
        }
        System.out.println(System.currentTimeMillis() - s);
        // System.out.println(str);
        // System.out.println(sb);
    }

    public static void name() {
        String[] name = {"О", "л","е","г"};
        String ok = "ОЛЕГ РА.";
        System.out.println(ok.toLowerCase());   // олег ра.
        System.out.println(String.join("", name));  // Олег
        System.out.println(String.join("", "О", "л","е","г"));  // Олег
        System.out.println(String.join(",", "О", "л","е","г")); // О,л,е,г
    }


}
