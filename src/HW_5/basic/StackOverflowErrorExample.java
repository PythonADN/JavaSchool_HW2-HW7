package HW_5.examples.basic;

public class StackOverflowErrorExample {

    private static void doSomething() {
        doSomething();
    }

    public static void main(String[] args) {
        doSomething();
    }

}
