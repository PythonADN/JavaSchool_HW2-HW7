package HW_5.myHometask;

public class Print {
    static void printStart() {
        System.out.println("Вам доступны следующие команды\n1. узнать баланс - balance\n2. внесение наличных - put\n3. снятие наличных - get\n4. завершение работы - exit");
    }

    static void printWrongPin() {
        System.out.println("Неверный пин, попробуейте еще раз");
    }

    static void printLimitPin() {
        System.out.println("Превышен лимит введенного пин-кода, терминал будет достпуен через 5 секунд...");
    }

    static void printMultiplicityOf100() {
        System.out.println("Сумма должна быть кратна 100, попробуйте ещё раз");
    }

    static void printExcessAmount() {
        System.out.println("Превышена сумма снятия, попробуйте ещё раз");
    }

    static void printIncorrectAmount() {
        System.out.println("Введена некорректная сумма, попробуйте ещё раз");
    }



}
