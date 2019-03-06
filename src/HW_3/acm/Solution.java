package HW_3.acm;

import java.util.*;

/**
 * Дан текст, ваша задача — найти слово, которое встречается в тексте наибольшее количество раз. Текст состоит только из латинских букв, пробелов, переводов строк.
 * Слово — это последовательность подряд идущих латинских букв, регистр не имеет значения.
 * Если искомых слов несколько, ваша задача — найти все такие слова.
 * <p>
 * Входные данные
 * Входные данные состоят только из латинских букв, пробелов и символов перевода строки. Гарантируется, что хотя бы одно слово в текст присутствует.
 * <p>
 * Выходные данные
 * Выведите все слова, которые встречаются наибольшее количество раз, при их следут приводить к нижнему регистру, каждое слово выводите на отдельной строке.
 * Слова выводите в лексикографическом порядке. Размер входного файла не превосходит 100 Кб.
 */
public class Solution {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        int max = 1;
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            if (map.containsKey(word)) {
                int count = map.get(word) + 1;
                map.replace(word, count);
                if (count > max) max = count;
            } else map.put(word, 1);
        }
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (pair.getValue() == max) {
                System.out.println(pair.getKey());
            }
        }
    }
}