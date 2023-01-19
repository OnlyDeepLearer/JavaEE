package uz.boom.javaee.exceptions;

import javax.servlet.ServletException;

public class IllegalInputException extends ServletException {
    public IllegalInputException(String message) {
        super(message);
    }
}
