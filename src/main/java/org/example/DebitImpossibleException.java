package org.example;

public class DebitImpossibleException extends Throwable {
    public DebitImpossibleException(String message) {
        super(message);
    }
}
