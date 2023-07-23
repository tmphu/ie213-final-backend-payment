package com.booking.payment.exception;

import com.booking.payment.enums.CodeResponse;
import com.booking.payment.enums.MessageResponse;
import org.springframework.http.HttpStatus;

public class SystemError extends MarkException {

    private static final long serialVersionUID = -1313899708642783593L;
    private static final MessageResponse DEFAULT_MESSAGE = MessageResponse.SYSTEM_ERROR;
    private static final CodeResponse STATUS_CODE = CodeResponse.SYSTEM_ERROR;
    private static final HttpStatus HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    public SystemError() {
        super(DEFAULT_MESSAGE, STATUS_CODE, HTTP_STATUS);
    }

    public SystemError(MessageResponse messageResponse) {
        super(messageResponse, STATUS_CODE, HTTP_STATUS);
    }

    public SystemError(CodeResponse code) {
        super(DEFAULT_MESSAGE, code, HTTP_STATUS);
    }
}
