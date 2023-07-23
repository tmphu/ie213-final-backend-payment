package com.booking.payment.exception;

import com.booking.payment.enums.CodeResponse;
import com.booking.payment.enums.MessageResponse;
import org.springframework.http.HttpStatus;

public class ExistedException extends MarkException {

    private static final long serialVersionUID = 641134053034935367L;
    private static final MessageResponse DEFAULT_MESSAGE = MessageResponse.EXISTED;
    private static final CodeResponse STATUS_CODE = CodeResponse.EXISTED;
    private static final HttpStatus HTTP_STATUS = HttpStatus.FOUND;

    public ExistedException() {
        super(DEFAULT_MESSAGE, STATUS_CODE, HTTP_STATUS);
    }

    public ExistedException(MessageResponse messageResponse) {
        super(messageResponse, STATUS_CODE, HTTP_STATUS);
    }

    public ExistedException(CodeResponse code) {
        super(DEFAULT_MESSAGE, code, HTTP_STATUS);
    }
}
