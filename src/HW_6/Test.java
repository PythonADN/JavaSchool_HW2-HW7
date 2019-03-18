package HW_6;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Test {
    public static void main(String[] args) throws Exception {
        Class<?> cl = String.class;
        for(Field field : cl.getDeclaredFields()) {
            System.out.println(field.getName()+" - type: "+ Modifier.toString(field.getModifiers()));
        }
    }
}
