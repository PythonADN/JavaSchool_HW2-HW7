package HW_2;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public static void main(String[] args) {
        Person p1 = new Person(true, "Вася");
        Person p2 = new Person(false, "Аня");
        Person p3 = new Person(true, "Олег");
        Person p4 = new Person(false, "Света");
        Person p5 = new Person(false, "Катя");

        // свадьбы
        p1.marry(p2);
        p3.marry(p4);

        // развод
        System.out.format("%s с супругой %s разводятся\n", p1.name, p1.spouse.name);
        System.out.format("%s с супругом %s разводятся\n", p2.name, p2.spouse.name);
        p1.divorce();
        System.out.format("теперь у %s нет жены: %s\n", p1.name, p1.spouse);
        System.out.format("теперь у %s нет мужа: %s\n\n", p2.name, p2.spouse);

        // свадьба с разводом
        System.out.format("%s с супругой %s\n", p3.name, p3.spouse.name);
        System.out.format("%s с супругом %s\n", p4.name, p4.spouse.name);
        System.out.format("%s хочет жиниться на %s\n", p3.name, p5.name);
        p3.marry(p5);
        System.out.format("теперь у %s жена - %s\n", p3.name, p3.spouse.name);
        System.out.format("теперь у %s муж - %s\n", p5.name, p5.spouse.name);
        System.out.format("а у %s теперь мужа нет: %s\n", p4.name, p4.spouse);
    }

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (this.man != person.man) { // пол не равен
            if (this.spouse == person.spouse && this.spouse != null) return false; // они и так муж и жена
            if (this.spouse != null) { // пытаемся развести пары (первую пару)
                this.divorce();
            }
            if (person.spouse != null) { // вторую пару
                person.divorce();
            }
            this.spouse = person; // теперь женим их
            person.spouse = this;
            return true;
        } else return false;
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (this.spouse != null) {
            this.spouse.spouse = null; // разводим вначале супруга(супругу) текущего человека
            this.spouse = null; // разводим текущего человека
            return true;
        } else return false;
    }


}