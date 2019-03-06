package HW_3.presentation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String fileName = "src\\HW_3\\presentation\\file.txt";
        System.out.println(solution.uniqueWordCount(fileName)); // задание 1
        solution.listUniqueWords(fileName); // задание 2
        // задание 3

    }

    /**
     * Задание 1: Подсчитайте количество различных слов в файле.
     */
    public int uniqueWordCount(String fileName) {
        Set<String> set = new HashSet<>();
        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            while (scanner.hasNext()) {
                set.add(scanner.next().toLowerCase()); // без учёта регистра
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set.size();
    }

    /**
     * Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
     */
    public void listUniqueWords(String fileName) {
        Set set = new TreeSet<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int n = Integer.compare(o1.length(), o2.length());
                        return (n != 0) ? n : o1.compareTo(o2);
                    }
                }
        );

        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            while (scanner.hasNext()) {
                set.add(scanner.next());
            }
            scanner.close();
            System.out.println(set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
     */


}
