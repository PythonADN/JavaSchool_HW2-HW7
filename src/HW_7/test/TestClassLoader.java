package HW_7.test;

public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz_b = A.class.getClassLoader().loadClass("HW_7.test.B");
        Interface_B b = (Interface_B) clazz_b.newInstance();
        b.method();
    }
}
