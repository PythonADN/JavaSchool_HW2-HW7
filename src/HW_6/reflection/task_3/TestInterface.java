package HW_6.reflection.task_3;

public interface TestInterface {
    @Cache
    void method_1(String s, int i);
    @Cache
    int method_2(int i, int n);
    String method_3();
}
