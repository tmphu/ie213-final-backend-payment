package com.booking.payment.exception;

import com.booking.payment.enums.CodeResponse;
import com.booking.payment.enums.MessageResponse;
import org.springframework.http.HttpStatus;

public class BadRequestException extends MarkException {

    private static final long serialVersionUID = 6164096114975634722L;
    private static final MessageResponse DEFAULT_MESSAGE = MessageResponse.BAD_REQUEST;
    private static final CodeResponse STATUS_CODE = CodeResponse.BAD_REQUEST;
    private static final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public BadRequestException() {
        super(DEFAULT_MESSAGE, STATUS_CODE, HTTP_STATUS);
    }

    public BadRequestException(MessageResponse messageResponse) {
        super(messageResponse, STATUS_CODE, HTTP_STATUS);
    }

    public BadRequestException(CodeResponse code) {
        super(DEFAULT_MESSAGE, code, HTTP_STATUS);
    }
}
