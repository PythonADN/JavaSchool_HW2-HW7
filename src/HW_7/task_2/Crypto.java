package HW_7.task_2;

import java.io.IOException;
import java.nio.file.*;

public class Crypto {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:/Users/ADN/IdeaProjects/JavaSchool/src/HW_7/task_2", "TestImpl.class");

        byte key = 17;
        byte[] data = Files.readAllBytes(path);

        for (int i = 0; i < data.length; i++) {
            data[i] = (byte)(data[i] ^ key);
        }

        Files.write(path, data, StandardOpenOption.WRITE);
    }
}
