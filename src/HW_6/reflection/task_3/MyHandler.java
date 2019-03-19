package HW_6.reflection.task_3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyHandler implements InvocationHandler {
    private final Object obj;
    private Map<Object[], Object> map;

    public MyHandler(Object obj) {
        this.obj = obj;
        this.map = new HashMap<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class)) {
            // пробегаемся по ключам (массивам аргументов) для проверки существования в Кеше результата метода по данным значениям аргументов метода
            for (Object[] o : map.keySet()) {
                if (Arrays.equals(args, o)) {
                    System.out.println("Подмена вызова метода "+method.getName()+" из Кеша");
                    return map.get(o);
                }
            }
            // иначе в коллекции данного результата нет
            Object result = method.invoke(obj, args);
            map.put(args, result);
            return result;
        }
        return method.invoke(obj, args);
    }

}
