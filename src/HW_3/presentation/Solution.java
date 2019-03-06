package HW_3.presentation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String fileName = "src\\HW_3\\presentation\\file.txt";

        System.out.println("\nЗадание 1");
        System.out.println(solution.uniqueWordCount(fileName)); // задание 1

        System.out.println("\nЗадание 2");
        solution.listUniqueWords(fileName); // задание 2

        System.out.println("\nЗадание 3");
        solution.wordCounterList(fileName); // задание 3

        System.out.println("\nЗадание 4");
        solution.reverseLine(fileName); // задание 4

        System.out.println("\nЗадание 5");
        Iterator<Integer> iterator = new MyCollection<Integer>(new Integer[]{1, 2, 3, 4, 5}).iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\nЗадание 6");


    }

    /**
     * Задание 1: Подсчитайте количество различных слов в файле.
     */
    public int uniqueWordCount(String fileName) {
        Set<String> set = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] str = line.trim().toLowerCase().split("[\\p{IsPunctuation}\\p{IsWhite_Space}\\n]+");
                set.addAll(Arrays.asList(str));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set.size();
    }

    /**
     * Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
     */
    public void listUniqueWords(String fileName) {
        Set<String> set = new TreeSet<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int n = Integer.compare(o1.length(), o2.length());
                        return (n != 0) ? n : o1.compareTo(o2);
                    }
                }
        );

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] str = line.trim().toLowerCase().split("[\\p{IsPunctuation}\\p{IsWhite_Space}\\n]+");
                set.addAll(Arrays.asList(str));
            }
            System.out.println(set);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
     */
    public void wordCounterList(String fileName) {
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] S = line.trim().toLowerCase().split("[\\p{IsPunctuation}\\p{IsWhite_Space}\\n]+");
                for (String word : S) {
                    if (map.containsKey(word)) {
                        map.replace(word, map.get(word) + 1);
                    } else map.put(word, 1);
                }
            }
            System.out.println(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Задание 4: Выведите на экран все строки файла в обратном порядке.
     */
    public void reverseLine(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                list.add(new StringBuilder(reader.readLine()).reverse().toString());
            }
            for (int i = list.size() - 1; i >= 0; i--) System.out.println(list.get(i));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
     */
    public static class MyCollection<T> implements Iterable<T> {
        private T[] arrayList;
        private int currentSize;

        public MyCollection(T[] newArray) {
            this.arrayList = newArray;
            this.currentSize = arrayList.length;
        }

        @Override
        public Iterator<T> iterator() {
            Iterator<T> it = new Iterator<T>() {
                private int currentIndex = currentSize - 1;

                @Override
                public boolean hasNext() {
                    return currentIndex >= 0 && arrayList[currentIndex] != null;
                }

                @Override
                public T next() {
                    return arrayList[currentIndex--];
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
            return it;
        }
    }

    /**
     * Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
     */


}
