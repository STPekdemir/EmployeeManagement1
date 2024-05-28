package net.javaguides.emsbackend.exception;

public class SeatAlreadyBookedException extends RuntimeException {
    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}
