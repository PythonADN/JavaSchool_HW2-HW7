package HW_3.acm;

import java.util.*;

/**
 * 2057. Структуры данных. Множество
 * Ваша задача — реализовать структуру данных, которая умеет хранить мультимножество натуральных чисел, т.е. в этой структуре могут одновременно храниться несколько равных элементов.
 * Эта структура должна поддерживать две операции:
 * добавить элемент x в множество
 * удалить минимальный элемент в множестве и вернуть его значение (если минимальных элементов несколько, то удаляется только один из них)
 * <p>
 * Входные данные
 * Первая строка входных данных содержит число n (1 ≤ n ≤ 106) — количество операций. Далее в n строках даны описания операций над множеством.
 * Описание представляет собой число — тип запроса (1 или 2) и число x (1 ≤ x ≤ 109) если это запрос первого типа.
 * <p>
 * Выходные данные
 * Для каждого запроса второго типа выведите результат на отдельной строке.
 */
public class Solution2057 {
    public static void main(String[] args) {
        MyCollection list = new MyCollection();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int x = scanner.nextInt();
                list.add(x);
            } else if (type == 2) System.out.println(list.popMin());
        }
    }

    static class MyCollection extends ArrayList<Integer> {
        private int minIndex() {
            int min = 0;
            for (int i = 0; i < size(); i++) {
                if (get(i) < get(min))
                    min = i;
            }
            return min;
        }

        public int popMin() {
            int i = minIndex();
            if (size() != 0) return remove(i);
            return 0;
        }

    }

}
