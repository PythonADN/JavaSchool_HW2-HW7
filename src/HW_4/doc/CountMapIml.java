package HW_4.doc;

import java.util.HashMap;
import java.util.Map;

public class CountMapIml<T> implements CountMap<T> {
    private Map<T, Integer> map;

    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapIml<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        System.out.println(map.getCount(5)); // 2
        System.out.println(map.getCount(6)); // 1
        System.out.println(map.getCount(10)); // 3
        System.out.println(map.remove(10));
        System.out.println(map.getCount(10)); // 2

        CountMap<Integer> map2 = new CountMapIml<>();
        map2.add(10);
        map2.add(10);
        map2.add(15);

        map.addAll(map2);
        System.out.println(map.getCount(15));
    }

    public CountMapIml() {
        this.map = new HashMap<>();
    }

    @Override
    public void add(T o) { // добавляет элемент в этот контейнер.
        if (map.containsKey(o)) {
            map.replace(o, map.get(o) + 1);
        } else map.put(o, 1);
    }

    @Override
    public int getCount(T o) { //Возвращает количество добавлений данного элемента
        if (map.containsKey(o)) return map.get(o);
        return 0;
    }

    @Override
    public int remove(T o) { //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
        int count = map.get(o);
        if (count <= 0) return 0;
        if (count == 1) map.remove(o);
        else map.replace(o, map.get(o) - 1);
        return count;
    }

    @Override
    public int size() { //количество разных элементов
        return map.size();
    }

    @Override
    public void addAll(CountMap source) { //Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения
        Map<T, Integer> toMap = source.toMap();
        for (Map.Entry<T, Integer> pair : toMap.entrySet()) {
            if (map.containsKey(pair.getKey())) map.replace(pair.getKey(), map.get(pair.getKey()) + pair.getValue());
            else map.put(pair.getKey(), pair.getValue());
        }
    }

    @Override
    public Map<T, Integer> toMap() { //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) { //Тот же самый контракт как и toMap(), только всю информацию записать в destination
        destination = map;
    }
}
