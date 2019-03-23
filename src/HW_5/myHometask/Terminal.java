package HW_5.myHometask;

import HW_5.myHometask.Exceptions.*;

public interface Terminal {
    void checkAccount() throws PinInputException, ManyInputsExeption; // проверить состояние счёта
    int balance() throws PinInputException, ManyInputsExeption; // баланс счёта
    void putMoney() throws PinInputException, ManyInputsExeption, MultiplicityOf100Exception, IncorrectAmountException; // положить деньги
    void getMoney() throws PinInputException, ManyInputsExeption, MultiplicityOf100Exception, ExcessAmountException, IncorrectAmountException; // снять деньги
}
