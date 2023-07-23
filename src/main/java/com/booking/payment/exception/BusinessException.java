package com.booking.payment.exception;

import com.booking.payment.enums.CodeResponse;
import com.booking.payment.enums.MessageResponse;
import org.springframework.http.HttpStatus;

public class BusinessException extends MarkException {

    private static final long serialVersionUID = 4247528897808870696L;

    private static final MessageResponse DEFAULT_MESSAGE = MessageResponse.FAIL;
    private static final CodeResponse STATUS_CODE = CodeResponse.FAIL;
    private static final HttpStatus HTTP_STATUS = HttpStatus.OK;

    public BusinessException() {
        super(DEFAULT_MESSAGE, STATUS_CODE, HTTP_STATUS);
    }

    public BusinessException(MessageResponse messageResponse) {
        super(messageResponse, STATUS_CODE, HTTP_STATUS);
    }

    public BusinessException(CodeResponse code) {
        super(DEFAULT_MESSAGE, code, HTTP_STATUS);
    }

}
