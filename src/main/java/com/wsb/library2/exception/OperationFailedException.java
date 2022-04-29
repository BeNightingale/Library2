package com.wsb.library2.exception;

public class OperationFailedException extends RuntimeException {

    public OperationFailedException() {
        super("Operation failed");
    }
}
