import OCA_1.aquarium.jellies.Water;

public class OCA_2 {
    public static void main(String[] args) {
        byte x = 1;
        byte y = 2;
        float b = x + 3f;

        int i = 0;

        while (i++ < 10) {
        }
        System.out.println(i); // будет 11

        // ошибка компиляции
//        String s = (i>10) ? "Да" : false;
        float a = (i > 10) ? 3 : b;

        System.out.println(i > 5 ? i < 10 ? 1 : 2 : 3);

        boolean f = true;
        System.out.println(true ^ (f = false)); // исключающее ИЛИ, даёт true на несовпадении + в скобках в выражении можно написать присвоение

//        for(; ; ) {
//            System.out.println("for"); // зациклится
//        }

        String s = "string";
        Double x_integer = 1.1;
        int x_int = 1;
        //OCA_2 cl = new OCA_2();
        Water w = new Water();
        //System.out.println(cl == (Object) w);

        x_int += ++x_int;
        System.out.println(x_int);

        int ii = 1;
        do {
            System.out.print(ii++ + " ");
        }
        while (ii<=10);
        System.out.println();

        switch(ii) {
            case 1:
            case 11:
                System.out.println("21");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3"); break;
        }

    }

}
