package HW_7.task_1;

import java.io.*;
import java.nio.file.Files;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("C:/Users/ADN/IdeaProjects/JavaSchool/src/" + name.replace('.','/') + ".class");
        if (!f.isFile()) throw new ClassNotFoundException("Класс " + name + " не найден");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f))) {
            byte[] b = new byte[bis.available()];
            bis.read(b);
            return this.defineClass(name, b, 0, b.length); // создание самого класса по относительному пути (через .)
        } catch (IOException e) {
            throw new ClassNotFoundException("Проблемы с файлом");
        }
    }
}
