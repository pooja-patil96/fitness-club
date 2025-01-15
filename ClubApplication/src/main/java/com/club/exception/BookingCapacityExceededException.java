package com.club.exception;

@SuppressWarnings("serial")
public class BookingCapacityExceededException extends RuntimeException {

    public BookingCapacityExceededException(String message) {
        super(message);
    }
}
