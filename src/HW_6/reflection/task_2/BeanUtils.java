package HW_6.reflection.task_2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * Scans object "from" for all getters. If object "to"
 * contains correspondent setter, it will invoke it
 * to set property value for "to" which equals to the property
 * of "from".
 * <p>
 * The type in setter should be compatible to the value returned
 * by getter (if not, no invocation performed).
 * Compatible means that parameter type in setter should\
 * be the same or be superclass of the return type of the getter.
 * <p>
 * The method takes care only about public methods.
 *
 * @param "to"    Object which properties will be set.
 * @param "fromm" Object which properties will be used to get values.
 */
public class BeanUtils {
    public static void main(String[] args) {
        ClassTest_1 to = new ClassTest_1(1, "string_1", 3);
        ClassTest_2 from = new ClassTest_2(2, "string_2", 6);

        System.out.println("До вызова метода:\n"+"from > "+from+"\n"+"to > "+to);
        assign(to, from);
        System.out.println("До вызова метода:\n"+"from > "+from+"\n"+"to > "+to);
    }

    public static void assign(Object to, Object from) {
        Map<String, Method> mapFieldsGetters = getAllGetters(from); // из объекта from будем получать поля с геттерами
        Map<String, Method> mapFieldsSetters = getAllSetters(to); // из объекта to будем получать поля с сеттерами
        for (Map.Entry<String, Method> fieldWithSetter : mapFieldsSetters.entrySet()) { // цикл по мэпе сеттеров
            if (mapFieldsGetters.containsKey(fieldWithSetter.getKey())) { // если есть одинаковые ключи - поля (значит есть и getter и setter для одного поля)
                Method setter = fieldWithSetter.getValue(); // получение сеттера
                Method getter = mapFieldsGetters.get(fieldWithSetter.getKey()); // получение геттера по ключу (полю)
                Class<?> setterParamType = setter.getParameterTypes()[0]; // тип аргумента сеттера
                Class<?> getterValueType = getter.getReturnType(); // тип возвращаемого значения геттера
                if (isCompatible(setterParamType, getterValueType)) {
                    try {
                        setter.invoke(to, getter.invoke(from));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException("Exception during reflection access", e);
                    }
                }
            }
        }


    }

    /**
     * проверяем совместимость типов, вплоть до последнего предка типа возвращаемого значения геттера
     * Сеттер в данном случае можеть иметь более общий тип
     */
    private static boolean isCompatible(Class<?> typeSetter, Class<?> typeGetter) {
        while (typeGetter != null) {
            if (typeSetter.equals(typeGetter)) {
                return true;
            }
            typeGetter = typeGetter.getSuperclass();
        }
        return false;
    }

    /**
     * получение полей с Геттерами в мэпу
     */
    private static Map<String, Method> getAllGetters(Object o) {
        Map<String, Method> map = new HashMap<>();
        Class<?> clazz = o.getClass();
        for (Method method : clazz.getMethods()) {
            String methodName = method.getName();
            if (methodName.matches("get[A-Z]+.*") && method.getReturnType() != void.class) {
                map.put(methodName.substring(3), method);
            }
        }
        return map;
    }

    /**
     * получение полей с Сеттерами в мэпу
     */
    private static Map<String, Method> getAllSetters(Object o) {
        Map<String, Method> map = new HashMap<>();
        Class<?> clazz = o.getClass();
        for (Method method : clazz.getMethods()) {
            String methodName = method.getName();
            if (methodName.matches("set[A-Z]+.*") && method.getReturnType() == void.class) {
                map.put(methodName.substring(3), method);
            }
        }
        return map;
    }
}
