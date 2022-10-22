package team.one.hhuz.exceptions;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class AlreadyExistException extends RuntimeException {
    private String message;


    public AlreadyExistException(String message) {
        super(message);
    }

    public AlreadyExistException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
