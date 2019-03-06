package HW_3.presentation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String fileName = "src\\HW_3\\presentation\\file.txt";
        System.out.println(solution.uniqueWordCount(fileName));

    }

    /**
     * Задание 1: Подсчитайте количество различных слов в файле.
     */
    public int uniqueWordCount(String fileName) {
        Set<String> set = new HashSet<>();
        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            while(scanner.hasNext()) {
                set.add(scanner.next().toLowerCase()); // без учёта регистра
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set.size();
    }
}
