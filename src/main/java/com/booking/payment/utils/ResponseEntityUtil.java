package com.booking.payment.utils;

import com.booking.payment.dto.Response;
import com.booking.payment.enums.LanguageEnum;
import com.booking.payment.exception.BadRequestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
//import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class ResponseEntityUtil {

    private static final HttpStatus DEFAULT_ERROR_STATUS_CODE = HttpStatus.INTERNAL_SERVER_ERROR;

    private ResponseEntityUtil() {
    }

    public static ResponseEntity<Response> getResponseEntity(Throwable throwable, LanguageEnum languageEnum, MessageSource messageSource, ObjectMapper objectMapper) throws JsonProcessingException {

        //Response System Error
        if (throwable == null
                || throwable instanceof NullPointerException
                || throwable instanceof NumberFormatException) {
            return ResponseEntity.status(DEFAULT_ERROR_STATUS_CODE).body(Response.systemError(languageEnum, messageSource));
        }

        // Response Timeout
        if (throwable instanceof TimeoutException
                || throwable instanceof IOException
                || throwable instanceof InterruptedException) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(Response.timeOut(languageEnum, messageSource));
        }

        //  Response Bad request
        if (throwable instanceof IllegalArgumentException
                || throwable instanceof HttpMessageNotReadableException
//                || throwable instanceof ConstraintViolationException
                || throwable instanceof MethodArgumentTypeMismatchException
                || throwable instanceof BadRequestException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.badRequest(languageEnum, messageSource));
        }

        // Exception when call another service via openfeign.
//        if (throwable instanceof FeignException) {
//            var exception = (FeignException) throwable;
//            var response = objectMapper.readValue(exception.contentUTF8(), Response.class);
//            return ResponseEntity.status(exception.status()).body(response);
//        }

        // For every other Throwable, return an INTERNAL_SERVER_ERROR
        return ResponseEntity.status(DEFAULT_ERROR_STATUS_CODE).body(Response.systemError(languageEnum, messageSource));
    }
}
