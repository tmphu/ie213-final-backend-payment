package com.booking.payment.exception;

import com.booking.payment.enums.CodeResponse;
import com.booking.payment.enums.MessageResponse;
import org.springframework.http.HttpStatus;

public class NotFoundException extends MarkException {

    private static final long serialVersionUID = -1337104658400191070L;
    private static final MessageResponse DEFAULT_MESSAGE = MessageResponse.NOT_FOUND;
    private static final CodeResponse STATUS_CODE = CodeResponse.NOT_FOUND;
    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

    public NotFoundException() {
        super(DEFAULT_MESSAGE, STATUS_CODE, HTTP_STATUS);
    }

    public NotFoundException(MessageResponse messageResponse) {
        super(messageResponse, STATUS_CODE, HTTP_STATUS);
    }

    public NotFoundException(CodeResponse code) {
        super(DEFAULT_MESSAGE, code, HTTP_STATUS);
    }

}
