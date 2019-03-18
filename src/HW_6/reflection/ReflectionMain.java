package HW_6.reflection;

import java.lang.reflect.Method;

public class ReflectionMain {
    public static void main(String[] args) {
        Working working = new Working(180, 75, 30, "Аналитик", 120);
//        getAllMethods(working);
        getAllGetters(working);
    }


    /**
     * Вывести на консоль все методы класса, включая все родительские методы (включая приватные)
     */
    public static void getAllMethods(Object o) {
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            System.out.println("Класс: " + clazz.getSimpleName());
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(method.getName());
            }
            clazz = clazz.getSuperclass();
            System.out.println();
        }

    }

    /**
     * Вывести все геттеры класса
     */
    public static void getAllGetters(Object o) {
        Class<?> clazz = o.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().matches("get.+")) {
                System.out.println(method.getName());
            }
        }
    }

    /**
     * Проверить что все String константы имеют значение = их имени
     */
    public static void constantCheck(Object o) {

    }


}
