package HW_6.reflection.task_2;

public class ClassTest_2 {
    private Integer x;
    private String o;
    private Integer i;

    public ClassTest_2(Integer x, String o, Integer i) {
        this.x = x;
        this.o = o;
        this.i = i;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "ClassTest_2{" +
                "x=" + x +
                ", o='" + o + '\'' +
                ", i=" + i +
                '}';
    }
}
