package HW_7.test;

import HW_7.B;

public class A {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        B b1 = new B();
        B b2 = (B) A.class.getClassLoader().loadClass("HW_7.B").newInstance();
        System.out.println(b2);

        Object cl = A.class.getClassLoader();
    }
}
