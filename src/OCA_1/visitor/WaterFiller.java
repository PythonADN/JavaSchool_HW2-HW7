package OCA_1.visitor;

import OCA_1.aquarium.jellies.Water;

public class WaterFiller {
    Water water;

    public void WaterFiller(Water water) {
        this.water = water;
    }

    public static void main(String... name) {
        System.out.println(name[1]);
        byte i = 0xE;
        System.out.println(i);
        WaterFiller waterFiller = new WaterFiller();
        waterFiller.WaterFiller(new Water());
//        double d = 1_2.0;
    }

}
