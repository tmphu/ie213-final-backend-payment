package com.booking.payment.utils;

import com.booking.payment.enums.LanguageEnum;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class MessageUtil {

    private MessageUtil() {
    }

    public static String toMessage(String messageBundle, LanguageEnum language, MessageSource messageSource) {
        return messageSource.getMessage(messageBundle, new Object[0], new Locale(language.name()));
    }

    public static String toMessage(String messageBundle, LanguageEnum language, MessageSource messageSource, Object... args) {
        return messageSource.getMessage(messageBundle, args, new Locale(language.name()));
    }
}
