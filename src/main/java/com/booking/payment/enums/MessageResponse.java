package com.booking.payment.enums;

import lombok.Getter;

@Getter
public enum MessageResponse {

    SUCCESS("response.success"),
    BAD_REQUEST("response.bad.request"),
    FAIL("response.fail"),
    UNAUTHORIZED("response.access.denied"),
    TIME_OUT("response.time.out"),
    EXISTED("response.existed"),
    SYSTEM_ERROR("response.system.error"),
    NOT_FOUND("response.not.found");

    private final String message;

    MessageResponse(String message) {
        this.message = message;
    }
}
