package com.booking.payment.controller;

import com.booking.payment.dto.CreatePaymentRequest;
import com.booking.payment.dto.Response;
import com.booking.payment.dto.vnpay.CallbackRequest;
import com.booking.payment.enums.CodeResponse;
import com.booking.payment.enums.LanguageEnum;
import com.booking.payment.service.PaymentService;
import com.booking.payment.utils.Constants;
import com.booking.payment.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
public class PaymentController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    protected PaymentService paymentService;

    @PostMapping("/payments")
    public ResponseEntity<Response> createRequestPayment(@RequestParam(defaultValue = Constants.DEFAULT_LANGUAGE) LanguageEnum language,
                                                         @RequestBody CreatePaymentRequest request) {
        String message = MessageUtil.toMessage("response.success", language, this.messageSource);
        Response response = new Response(CodeResponse.SUCCESS.getValue(), message);
        response.data = this.paymentService.createPayment(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/vn-pay/callback")
    public ResponseEntity<Response> returnURL(@RequestParam(defaultValue = Constants.DEFAULT_LANGUAGE) LanguageEnum language,
                                              @RequestParam Map<String, String> request) {
        String message = MessageUtil.toMessage("response.success", language, this.messageSource);
        Response response = new Response(CodeResponse.SUCCESS.getValue(), message);
        this.paymentService.callback(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
