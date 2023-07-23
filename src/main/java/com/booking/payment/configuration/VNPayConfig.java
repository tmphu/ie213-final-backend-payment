package com.booking.payment.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("vnpay")
public class VNPayConfig {

    public String url;
    public String secret;
    public String tmnCode;
    public String version;
    public String command;
    public String orderType;
    public String orderInfo;
    public String currCode;
    public String locale;
    public String returnUrl;
}
