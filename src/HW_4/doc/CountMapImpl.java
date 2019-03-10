package HW_4.doc;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    private Map<T, Integer> map;

    public CountMapImpl() {
        this.map = new HashMap<>();
    }

    @Override
    public void add(T o) { // добавляет элемент в этот контейнер.
        if (map.containsKey(0)) {
            map.replace(o, map.get(0) + 1);
        } else map.put(o, 1);
    }

    @Override
    public int getCount(T o) { //Возвращает количество добавлений данного элемента
        return map.get(0);
    }

    @Override
    public int remove(T o) { //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
        int count = map.get(o);
        if (count <= 0) return 0;
        if (count==1) map.remove(o);
        else map.replace(o, map.get(o)-1);
        return count;
    }

    @Override
    public int size() { //количество разных элементов
        return map.size();
    }

    @Override
    public void addAll(CountMap source) { //Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения

    }

    @Override
    public Map toMap() {
        return null;
    }

    @Override
    public void toMap(Map destination) {

    }
}
