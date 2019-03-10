package HW_4.doc;

/**
 * Параметризовать CountMap и реализовать его.
 * <p>
 * пример использования
 * CountMap<Integer> map = new CountMapIml<>();
 * <p>
 * map.add(10);
 * map.add(10);
 * map.add(5);
 * map.add(6);
 * map.add(5);
 * map.add(10);
 * <p>
 * int count = map.getCout(5); // 2
 * int count = map.getCout(6); // 1
 * int count = map.getCout(10); // 3
 */

import java.util.Map;

public interface CountMap<T> {
    void add(T o); // добавляет элемент в этот контейнер.

    int getCount(T o); //Возвращает количество добавлений данного элемента

    int remove(T o); //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)

    int size(); //количество разных элементов

    void addAll(CountMap source); //Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения

    Map toMap(); //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений

    void toMap(Map destination); //Тот же самый контракт как и toMap(), только всю информацию записать в destination
}



