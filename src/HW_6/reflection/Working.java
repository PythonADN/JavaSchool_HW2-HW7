package HW_6.reflection;

public class Working extends Person {
    private String position;
    private int salary;

    public Working(int height, int weight, int age, String position, int salary) {
        super(height, weight, age);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
