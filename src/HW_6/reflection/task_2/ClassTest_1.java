package HW_6.reflection.task_2;

public class ClassTest_1 {
    private Number x;
    private Object o;
    private Integer i2;

    public ClassTest_1(Number x, Object o, Integer i) {
        this.x = x;
        this.o = o;
        this.i2 = i;
    }

    public Number getX() {
        return x;
    }

    public void setX(Number x) {
        this.x = x;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public Integer getI2() {
        return i2;
    }

    public void setI2(Integer i) {
        this.i2 = i;
    }

    @Override
    public String toString() {
        return "ClassTest_1{" +
                "x=" + x +
                ", o=" + o +
                ", i2=" + i2 +
                '}';
    }
}
