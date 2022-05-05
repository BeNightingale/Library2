package com.wsb.library.exception;

public class OperationFailedException extends RuntimeException {

    public OperationFailedException() {
        super("Operation failed");
    }
}
