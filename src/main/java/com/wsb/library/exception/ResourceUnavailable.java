package com.wsb.library.exception;

public class ResourceUnavailable extends RuntimeException {

    public ResourceUnavailable() {
        super("Resource unavailable");
    }
}
