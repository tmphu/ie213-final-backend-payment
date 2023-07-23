package com.booking.payment.exception;

import com.booking.payment.dto.Response;
import com.booking.payment.enums.CodeResponse;
import com.booking.payment.enums.LanguageEnum;
import com.booking.payment.enums.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Locale;

@Slf4j
public abstract class MarkException extends RuntimeException {

    private static final long serialVersionUID = 7721851563041319555L;

    protected final MessageResponse message;
    protected final Object[] args;
    protected final int code;
    protected final HttpStatus httpStatus;

    protected MarkException(MessageResponse messageResponse, CodeResponse code, HttpStatus httpStatus) {
        this.args = new Object[0];
        this.message = messageResponse;
        this.code = code.getValue();
        this.httpStatus = httpStatus;
    }

    public ResponseEntity<Response> getResponseEntity(LanguageEnum languageEnum, MessageSource messageSource) {
        String body = messageSource.getMessage(message.getMessage(), args, new Locale(languageEnum.name()));
        Response response;
        response = new Response(code, body);
        return new ResponseEntity<>(response, httpStatus);
    }

}
