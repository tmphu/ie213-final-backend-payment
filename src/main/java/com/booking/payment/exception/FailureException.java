package com.booking.payment.exception;

import com.booking.payment.enums.CodeResponse;
import com.booking.payment.enums.MessageResponse;
import org.springframework.http.HttpStatus;

public class FailureException extends MarkException {

    private static final long serialVersionUID = -3548271790809725362L;
    private static final MessageResponse DEFAULT_MESSAGE = MessageResponse.FAIL;
    private static final CodeResponse STATUS_CODE = CodeResponse.FAIL;
    private static final HttpStatus HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public FailureException() {
        super(DEFAULT_MESSAGE, STATUS_CODE, HTTP_STATUS);
    }

    public FailureException(MessageResponse messageResponse) {
        super(messageResponse, STATUS_CODE, HTTP_STATUS);
    }

    public FailureException(CodeResponse code) {
        super(DEFAULT_MESSAGE, code, HTTP_STATUS);
    }

}
