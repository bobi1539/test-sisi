package tes.sis.testsisi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import tes.sis.testsisi.constant.GlobalMessage;

@Getter
public class AppException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;

    public AppException(GlobalMessage globalMessage) {
        super(globalMessage.message);
        this.httpStatus = globalMessage.httpStatus;
        this.message = globalMessage.message;
    }
}
