package com.booking.payment.exception;

import com.booking.payment.enums.CodeResponse;
import com.booking.payment.enums.MessageResponse;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends MarkException {

    private static final long serialVersionUID = -2561939691151488407L;
    private static final MessageResponse DEFAULT_MESSAGE = MessageResponse.UNAUTHORIZED;
    private static final CodeResponse STATUS_CODE = CodeResponse.UNAUTHORIZED;
    private static final HttpStatus HTTP_STATUS = HttpStatus.UNAUTHORIZED;

    public UnauthorizedException() {
        super(DEFAULT_MESSAGE, STATUS_CODE, HTTP_STATUS);
    }

    public UnauthorizedException(MessageResponse messageResponse) {
        super(messageResponse, STATUS_CODE, HTTP_STATUS);
    }

    public UnauthorizedException(CodeResponse code) {
        super(DEFAULT_MESSAGE, code, HTTP_STATUS);
    }
}
