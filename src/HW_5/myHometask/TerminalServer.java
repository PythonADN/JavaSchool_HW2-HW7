package HW_5.myHometask;


import HW_5.myHometask.Exceptions.ManyInputsExeption;

public class TerminalServer {
    // сервер проверяет введённый пользователем аккаунт и пароль
    private final int PIN = 1234;
    private int sum = 5000;

    boolean accountVerification(int pin, PinValidator validator) throws ManyInputsExeption { // проверка счёта по введённому пин-коду
        if (pin != PIN) {
            validator.newInputAttempt();
            return false;
        }
        validator.resetNumberOfAttempts();
        return true;
    }

    int getSum() {
        return sum;
    }

    void putMoney(int sum)  {
        this.sum += sum;
    }

    boolean getMoney(int sum) {
        if (sum > this.sum) return false;
        else {
            this.sum -= sum;
            return true;
        }
    }

}
