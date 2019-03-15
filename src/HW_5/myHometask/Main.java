package HW_5.examples.myHometask;

import HW_5.examples.myHometask.Exceptions.*;

import static HW_5.examples.myHometask.Print.*;
import java.util.Scanner;


public class Main {
    private TerminalImpl terminal;

    public Main(TerminalImpl terminal) {
        this.terminal = terminal;
    }

    public static void main(String[] args) throws PinInputException, ManyInputsExeption {
        TerminalServer server = new TerminalServer();
        PinValidator pinValidator = new PinValidator();
        TerminalImpl terminal = new TerminalImpl(server, pinValidator);
        Main main = new Main(terminal);

        Scanner scanner = new Scanner(System.in);
        printStart();
        while(true) {
            String line = scanner.nextLine().toLowerCase();
            if (line.equals("balance")) main.balance();
            else if (line.equals("put")) main.put();
            else if (line.equals("get")) main.get();
            else if (line.equals("exit")) { System.out.println("Удачного дня"); return; }
            else System.out.println("Запрос некорректен");
        }
    }

    public void balance() {
        try {
            int balance = terminal.balance();
            System.out.println("Баланс = "+balance);
            printStart();
        } catch (PinInputException e) {
            printWrongPin();
            balance();
        } catch (ManyInputsExeption manyInputsExeption) {
            printLimitPin();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            printStart();
        }
    }

    public void put() {
        try {
            terminal.putMoney();
            printStart();
        } catch(PinInputException e) {
            printWrongPin();
            put();
        } catch (ManyInputsExeption e) {
            printLimitPin();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            printStart();
        } catch (MultiplicityOf100Exception e) {
            printMultiplicityOf100();
            put();
        } catch (IncorrectAmountException e) {
            printIncorrectAmount();
            put();
        }
    }

    public void get() {
        try {
            terminal.getMoney();
            printStart();
        } catch(PinInputException e) {
            printWrongPin();
            get();
        } catch (ManyInputsExeption e) {
            printLimitPin();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            printStart();
        } catch (ExcessAmountException e) {
            printExcessAmount();
            get();
        } catch (MultiplicityOf100Exception e) {
            printMultiplicityOf100();
            get();
        } catch (IncorrectAmountException e) {
            printIncorrectAmount();
            get();
        }
    }
}
