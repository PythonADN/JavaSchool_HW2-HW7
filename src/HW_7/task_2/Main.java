package HW_7.task_2;

import java.io.File;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        byte key = 17;
        ClassLoader loader =
                new EncryptedClassLoader(
                        key,
                        "C:/Users/ADN/IdeaProjects/JavaSchool/src/HW_7/task_2",
                        Main.class.getClassLoader());

        Test test =  (Test)loader.loadClass("HW_7.task_2.TestImpl").newInstance();
        test.doSomething();   }
}
