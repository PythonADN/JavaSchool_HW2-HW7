package HW_6.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionMain {
    public static void main(String[] args) {
        Working working = new Working(180, 75, 30, "Аналитик", 120);
//        getAllMethods(working);
//        getAllGetters(working);
        constantCheck(working);
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
     * public static final String MONDAY = "MONDAY";
     */
    public static void constantCheck(Object o) {
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                Class<?> fieldType = field.getType();
                if (fieldType.getName().equals("java.lang.String")) { // если тип поля - Строка
                    int modifiers = field.getModifiers();
                    if (Modifier.isFinal(modifiers) && Modifier.isStatic(modifiers)) { // если поле - константа класса (final static)
                        String fieldName = field.getName();
                        try {
                            field.setAccessible(true); // открываем доступ к полю (даюы избежать исключения при чтении значения c private поля)
                            String value = (String) field.get(o);
                            if (!fieldName.equals(value)) {
                                throw new RuntimeException("строковая константа " + fieldName + " имеет значение ("+value+"), которе не совпадает с её именем");
                            }
                        } catch (IllegalAccessException e) {
                            System.out.println("Исключение при получении значения у поля "+fieldName); // попали бы сюда если private поле и не field.setAccessible(true);
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }
    }


}
