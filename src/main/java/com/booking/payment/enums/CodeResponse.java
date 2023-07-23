package com.booking.payment.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CodeResponse {

    SUCCESS(200),
    BAD_REQUEST(400),
    EXISTED(403),
    FAIL(402),
    SYSTEM_ERROR(500),
    TIME_OUT(504),
    NOT_FOUND(404),
    UNAUTHORIZED(401);

    private final int code;

    @JsonValue
    public int getValue() {
        return this.code;
    }

    CodeResponse(int code) {
        this.code = code;
    }
}
