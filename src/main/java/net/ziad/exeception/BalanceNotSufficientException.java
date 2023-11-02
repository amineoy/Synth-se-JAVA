package net.ziad.exeception;

public class BalanceNotSufficientException extends Exception{

    public BalanceNotSufficientException(String message) {
        super(message);
    }
}
