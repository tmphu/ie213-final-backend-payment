package com.booking.payment.service;

import com.booking.payment.configuration.VNPayConfig;
import com.booking.payment.dto.CreatePaymentRequest;
import com.booking.payment.dto.CreatePaymentResponse;
import com.booking.payment.enums.CodeResponse;
import com.booking.payment.enums.PartnerEnum;
import com.booking.payment.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class PaymentService {

    @Autowired
    protected VNPayConfig vnPay;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    private static final String HMAC_SHA512 = "HmacSHA512";

    public void callback(Map<String, String> request) {

    }

    public CreatePaymentResponse createPayment(CreatePaymentRequest request) {
        if (!request.partner.equals(PartnerEnum.VNPAY)) {
            throw new BadRequestException(CodeResponse.BAD_REQUEST);
        }
        Map<String, String> params = new HashMap<>();
        params.put("vnp_Version", vnPay.version);
        params.put("vnp_Command", vnPay.command);
        params.put("vnp_TmnCode", vnPay.tmnCode);
        params.put("vnp_Amount", String.valueOf(request.paymentAmount * 100));
        params.put("vnp_CreateDate", dateFormat.format(new Date()));
        params.put("vnp_CurrCode", vnPay.currCode);
        params.put("vnp_IpAddr", "118.71.69.137");
        params.put("vnp_Locale", vnPay.locale);
        params.put("vnp_OrderInfo", "Payment for order: " + request.orderNumber);
        params.put("vnp_OrderType", "other");
        params.put("vnp_ReturnUrl", vnPay.returnUrl);
        params.put("vnp_TxnRef", String.valueOf(System.currentTimeMillis()));

        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);

        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator<String> iterator = keys.iterator();

        try {
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = params.get(key);

                if (!ObjectUtils.isEmpty(value)) {
                    // Build hashData
                    hashData.append(key);
                    hashData.append('=');
                    hashData.append(URLEncoder.encode(value, StandardCharsets.US_ASCII.toString()));

                    // Build query
                    query.append(URLEncoder.encode(key, StandardCharsets.US_ASCII.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(value, StandardCharsets.US_ASCII.toString()));
                    if (iterator.hasNext()) {
                        query.append('&');
                        hashData.append('&');
                    }
                }
            }

            String vnp_SecureHash = this.hmac(vnPay.secret, hashData.toString());
            String queryURL = query + "&vnp_SecureHash=" + vnp_SecureHash;
            String result = this.vnPay.url + queryURL;
            return CreatePaymentResponse.builder()
                    .url(result)
                    .build();
        } catch (Exception ex) {
            return CreatePaymentResponse.builder()
                    .build();
        }
    }

    public String hmac(String secret, String data) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac hmacSHA512 = Mac.getInstance(HMAC_SHA512);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), HMAC_SHA512);
        hmacSHA512.init(secretKeySpec);

        byte[] digest = hmacSHA512.doFinal(data.getBytes());
        BigInteger hash = new BigInteger(1, digest);
        String result = hash.toString(16);
        if ((result.length() % 2) != 0) {
            result = "0" + result;
        }
        return result;
    }

}
