package com.booking.payment.enums;

public enum LanguageEnum {
    vi, en;

    public static LanguageEnum getValue(String languageString) {
        for (LanguageEnum languageEnum : LanguageEnum.values()) {
            if (languageEnum.name().equalsIgnoreCase(languageString))
                return languageEnum;
        }
        return LanguageEnum.vi;
    }
}
