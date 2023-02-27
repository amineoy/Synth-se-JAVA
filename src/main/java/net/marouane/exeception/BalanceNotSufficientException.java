package net.marouane.exeception;

public class BalanceNotSufficientException extends Exception{

    public BalanceNotSufficientException(String message) {
        super(message);
    }
}
