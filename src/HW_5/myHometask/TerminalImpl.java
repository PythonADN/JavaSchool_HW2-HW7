package HW_5.myHometask;

import HW_5.myHometask.Exceptions.*;

import java.util.InputMismatchException;
import java.util.Scanner;

class TerminalImpl implements Terminal {
    private final TerminalServer server; // сервер
    private final PinValidator pinValidator; // проверка пин-кода

    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }


    @Override
    public void checkAccount() throws PinInputException, ManyInputsExeption { // проверка акаунта
        // доступ к терминалу по пину
        System.out.println("введите пин-код");
        Scanner scanner = new Scanner(System.in);
        try {
            int pin = scanner.nextInt();
            if (!server.accountVerification(pin, pinValidator)) { // отправляем пин-кода на сервер для проверки пина
                throw new PinInputException();
            }
        } catch (InputMismatchException e) {
            pinValidator.newInputAttempt();
            throw new PinInputException();
        }
    }

    @Override
    public int balance() throws PinInputException, ManyInputsExeption {
        checkAccount(); // доступ к терминалу по пину
        return server.getSum();
    }

    @Override
    public void putMoney() throws PinInputException, ManyInputsExeption, MultiplicityOf100Exception, IncorrectAmountException {
        checkAccount(); // доступ к терминалу по пину
        System.out.println("введите сумму для внесения (вносить можно только суммы кратные 100)");
        Scanner scanner = new Scanner(System.in);
        try {
            int sum = scanner.nextInt();
            if (sum % 100 != 0) throw new MultiplicityOf100Exception();
            server.putMoney(sum);
        } catch (InputMismatchException e) {
            pinValidator.newInputAttempt();
            throw new IncorrectAmountException();
        }
    }

    @Override
    public void getMoney() throws PinInputException, ManyInputsExeption, MultiplicityOf100Exception, ExcessAmountException, IncorrectAmountException {
        checkAccount(); // доступ к терминалу по пину
        System.out.println("введите сумму для снятия (получать можно только суммы кратные 100)");
        Scanner scanner = new Scanner(System.in);
        try {
            int sum = scanner.nextInt();
            if (sum % 100 != 0) throw new MultiplicityOf100Exception();
            if (!server.getMoney(sum)) throw new ExcessAmountException();
        } catch (InputMismatchException e) {
            pinValidator.newInputAttempt();
            throw new IncorrectAmountException();
        }
    }
}
