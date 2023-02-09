/*

 * Classname: Task-1_v2
 *
 * Version: 1.
 *
 * Date: 2023-02-04.
 *
 * Copyright notice: by Oleg Razumov.
 */

package seminar05;


import java.util.*;
import java.util.stream.Collectors;

public class task01_v2 {

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Пусть дан список сотрудников:Иван Иванов (и остальные)
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

    public static void main(String[] args) {

        String[] listPhones = new String[]{
                "Иван Иванов 88001122333",
                "Иван Курицин 88001662333",
                "Иван Курицин 88001112333",
                "Иван Незлобин 88001122432",
                "Сергей Потапов 88001112453",
                "Сергей Потапов 8800163214",
                "Сергей Курицин 8800142421",
                "Михаил Незлобин 880012343"};

        // Phonebook's map.
        Map<String, String> phonebook = new HashMap<>();
        // counter - map of the name=counter.
        Map<String, Integer> counter = new HashMap<>();
        String name, phone = "";

        for (int i = 0; i < listPhones.length; i++) {
            String[] line = (listPhones[i].split(" "));

            StringBuilder sb = new StringBuilder();
            name = String.valueOf(sb.append(line[0] + " " + line[1]));
            phone = String.valueOf(line[2]);
            phonebook.putIfAbsent(phone, name);
            counter.put(name, Collections.frequency(phonebook.values(), name));
        }

        System.out.println(phonebook);
        System.out.println();

        // Finding duplicates and printing them out with the number of matches.
        List<String> names = new ArrayList<>(phonebook.values());

        for (Map.Entry entry: counter.entrySet()) {
            int count = Collections.frequency(names, entry.getKey());
            if (count > 1) System.out.printf("%s -> %d\n", entry.getKey(), count);
        }
        System.out.println();

        // Sort the map in descending order of names.
        List<Map.Entry<String, Integer>> list = counter.entrySet().stream()
                .sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
