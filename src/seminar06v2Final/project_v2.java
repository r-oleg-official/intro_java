package seminar06v2Final;

import java.util.*;
import java.util.stream.Collectors;

public class project_v2 {
    public static void main(String[] args) {
        List<Notebook> notebooks = initListNotebooks();
        List<Notebook> listSorted = new ArrayList<>();
        Map<String, String> params = new HashMap<>();
        params.put("manufacturer", "Asus");
        params.put("ssd", "512");
        listSorted = filter(params, notebooks);
        for (Notebook tmp : listSorted) {
            System.out.println(tmp.toString());
        }
    }

    public static List<Notebook> initListNotebooks() {

        List<Notebook> notebooks = new ArrayList<>(Arrays.asList());
        notebooks.add(new Notebook("1645267", "Intel Core i3-1005G1", "4", "256",
                "15.6", "Acer", "Aspire 3 A315-56-38W0", "black", "no OS",
                "29999"));
        notebooks.add(new Notebook("5038340", "Intel Core i3-10110U", "8", "256",
                "15.6", "Lenovo", "IdeaPad 3 15IML05", "blue", "no OS",
                "37999"));
        notebooks.add(new Notebook("5057106", "Intel Core i5-11400H", "16", "512",
                "15.6", "Asus", "TUF Gaming F15 FX506HCB-HN210W", "black",
                "Windows 11 Home Single Language", "84999"));
        notebooks.add(new Notebook("4894763", "Intel Core i5-11300H", "8", "512",
                "16", "Asus", "VivoBook Pro 16X OLED N7600PC-L2085W", "silver",
                "Windows 11 Home Single Language", "104999"));
        return notebooks;
    }

    public static List<Notebook> filter(Map<String, String> params, List<Notebook> notebooks) {
        List<Notebook> listSorted = notebooks.stream().filter(p -> {
            for (String key : params.keySet()) {
                if (!p.getParams(key).equals(params.get(key))) return false;
            }
            return true;
        }).collect(Collectors.toList());
        return listSorted;
    }
}