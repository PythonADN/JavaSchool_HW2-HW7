package HW_4.doc;

import java.util.*;

/**
 * Задание 2
 * Параметризовать методы, используя правило PECS (Producer Extends Consumer Super), и реализовать их.
 */
public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() { // неважно для создания
        return new ArrayList<>();
    }

    public static <T extends List> T newArrayList2() {
        return (T) new ArrayList<>();
    }

    public static <T> int indexOf(List<T> source, T o) { // неважно для наличия
        return source.indexOf(o);
    }

    public static <T> List<? super T> limit(List<? extends T> source, int size) {
        List<? super T> list = new ArrayList<>(size);
        for (T s : source) {
            list.add(s);
        }
        return null;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<T> removeFrom, List<T> c2) { // неважно для удаления
        removeFrom.removeAll(c2);
    }

    // true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<T> c1, List<T> c2) { //  неважно для наличия
        return c1.containsAll(c2);
    }

    // true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<T> c1, List<? extends T> c2) { // неважно для наличия (важно только для прохода по циклу)
        for (T c : c2) {
            if (c1.contains(c)) return true;
        }
        return false;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6,4), 3, 6) вернет {3,4,5,6}
    public static <T> List<? super T> range(List<? extends T> list, T min, T max) {
        List<? super T> array = new ArrayList<>();
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Integer.compare(o1.hashCode(), o2.hashCode());
            }
        };
        for (T x : list) {
            if (comparator.compare(max, x) >= 0 && comparator.compare(min, x) <= 0) array.add(x); // попадение в диапазон определяю по компаратору
        }
        return array;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6,4), 3, 6) вернет {3,4,5,6}
    public static <T> List<? super T> range(List<? extends T> list, T min, T max, Comparator comparator) {
        List<? super T> array = new ArrayList<>();
        for (T x : list) {
            if (comparator.compare(max, x) >= 0 && comparator.compare(min, x) <= 0) array.add(x); // попадение в диапазон определяю по компаратору
        }
        return array;
    }

}
