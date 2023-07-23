package com.booking.payment.dto;

import com.booking.payment.enums.CodeResponse;
import com.booking.payment.enums.LanguageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    public Integer code;
    public String message;
    public Object data;

    public Response(Integer code) {
        this.code = code;
    }

    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Response systemError(LanguageEnum language, MessageSource messageSource) {
        return new Response(CodeResponse.SYSTEM_ERROR.getValue(), messageSource.getMessage("response.system.error",
                new Object[0], new Locale(language.name())));
    }

    public static Response timeOut(LanguageEnum language, MessageSource messageSource) {
        return new Response(CodeResponse.TIME_OUT.getValue(), messageSource.getMessage("response.time.out",
                new Object[0], new Locale(language.name())));
    }

    public static Response badRequest(LanguageEnum language, MessageSource messageSource) {
        return new Response(CodeResponse.BAD_REQUEST.getValue(), messageSource.getMessage("response.bad.request",
                new Object[0], new Locale(language.name())));
    }

}
