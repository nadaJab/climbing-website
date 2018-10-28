package org.climbing.model.exception;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

    public NotFoundException() {
    }

    public NotFoundException(String pMessage) {
        super(pMessage);
    }

    public NotFoundException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }

}
