package HW_4.presentation;

import java.util.*;

/**
 * Необходимо написать свой LinkedList
 * Методы:
 * add(E e)
 * add(int index, E element)
 * E get(int index)
 * E remove(int index)
 * Iterator<E> iterator()
 * <p>
 * с использованием wildcards:
 * boolean addAll(Collection c)
 * boolean copy(Collection c)
 */
public class MyLinkedList<T> extends AbstractList<T> {
    T[] values;

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(1, 2);
        list.remove(0);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);

        list.addAll(list2);

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public MyLinkedList() {
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

    @Override
    public void add(int index, T t) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp, index, values, index + 1, temp.length - index);
            values[index] = t;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public T remove(int index) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp, index + 1, values, index, temp.length - index - 1);
            return temp[index];
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return super.iterator();
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        try {
            T[] temp = values;
            T[] array = (T[]) c.toArray();
            values = (T[]) new Object[temp.length + array.length];
            System.arraycopy(temp, 0, values, 0, temp.length);
            System.arraycopy(array, 0, values, temp.length, array.length);
            return true;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return false;
//        return super.addAll(c);
    }

    public boolean copy(Collection<? super T> c) {
        c.clear();
        c.addAll(Arrays.asList(values));
        return true;
    }
}
