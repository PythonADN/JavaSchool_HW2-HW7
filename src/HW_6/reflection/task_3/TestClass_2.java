package HW_6.reflection.task_3;

import java.lang.reflect.Method;

public class TestClass_2 extends TestClass {
    public static void main(String[] args) throws NoSuchMethodException {
        // @Inherited для класса а не для метода (методы автоматически наследуют аннотации, если их не переопределять)
        Method method_2 = TestClass_2.class.getMethod("method_2", int.class, int.class);
        System.out.println(method_2.isAnnotationPresent(Cache.class));

        System.out.println(TestClass_2.class.isAnnotationPresent(MyAnnotation.class));

        // Даже при типе интерфейса он смотри анннотации метода именно у класса (Однако это не касается Proxy - он смотрит аннотации методов интерфейса)
        TestInterface test = new TestClass_2();
        System.out.println(test.getClass().getMethod("method_2", int.class, int.class).isAnnotationPresent(Cache.class));
    }

}
