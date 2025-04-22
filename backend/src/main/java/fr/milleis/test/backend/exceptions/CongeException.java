package fr.milleis.test.backend.exceptions;

public class CongeException extends RuntimeException {
    private final String code;

    public CongeException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

