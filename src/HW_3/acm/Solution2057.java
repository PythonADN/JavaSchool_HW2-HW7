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


    static class MyCollection<T> extends AbstractList<T> {
        T[] values;

        public MyCollection() {
            this.values = (T[]) new Object[0];
        }

        @Override
        public boolean add(T t) {
            try {
                T[] temp = values;
                values = (T[]) new Object[temp.length + 1];
                System.arraycopy(temp, 0, values, 0, temp.length);
                values[temp.length] = t;
                return true;
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            return false;
        }

        public T popMin() {
            if (size() == 0) return null;
            try {
                int minI = 0;
                for (int i = 0; i < size(); i++) {
                    if ((Integer) get(i) < (Integer) get(minI))
                        minI = i;
                }
                T[] temp = values;
                values = (T[]) new Object[temp.length - 1];
                System.arraycopy(temp, 0, values, 0, minI);
                System.arraycopy(temp, minI + 1, values, minI, temp.length - minI - 1);
                return temp[minI];
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public T get(int index) {
            return values[index];
        }

        @Override
        public int size() {
            return values.length;
        }
    }

}
