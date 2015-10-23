package com.doomphantoom.exception;

/**
 * Created by doomphantom on 23/10/2015.
 */
public class AnnotationInvalidException extends RuntimeException {
    public AnnotationInvalidException() {
        super();
    }

    public AnnotationInvalidException(String message) {
        super(message);
    }

    public AnnotationInvalidException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
