package HW_6.reflection.task_3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyCache {
    public static void main(String[] args) {
        TestClass object = new TestClass(); // объект класса
        InvocationHandler handler = new MyHandler(object); // обработчик
        TestInterface objectProxy = (TestInterface) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), handler);

        System.out.println(objectProxy.method_2(1, 2));
        System.out.println(objectProxy.method_2(1, 3));
        System.out.println(objectProxy.method_2(1, 2));
        objectProxy.method_1("string", 1);
        objectProxy.method_1("string", 1);
    }

}
