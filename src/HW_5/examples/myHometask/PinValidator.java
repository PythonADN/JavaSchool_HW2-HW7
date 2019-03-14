package HW_5.examples.myHometask;

import HW_5.examples.myHometask.Exceptions.ManyInputsExeption;

/**
 * проверка пин-кода
 */
public class PinValidator {
    private int numberOfAttempts = 1; // число попыток

    void newInputAttempt() throws ManyInputsExeption { // новая попытка ввода пина
        if (numberOfAttempts == 3) {
            numberOfAttempts = 1;
            throw new ManyInputsExeption();
        } else numberOfAttempts++;
    }

    void resetNumberOfAttempts() {
        numberOfAttempts = 1;
    }

}
