package HW_6.reflection.task_3;

@MyAnnotation
public class TestClass implements TestInterface {
    @Override
    public void method_1(String s, int i) {
        return;
    }
    @Cache
    @Override
    public int method_2(int i, int n) {
        return i+n;
    }

    @Override
    public String method_3() {
        return "Строка";
    }
}
