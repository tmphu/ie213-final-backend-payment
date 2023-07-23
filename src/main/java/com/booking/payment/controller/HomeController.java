package com.booking.payment.controller;


import com.booking.payment.dto.Response;
import com.booking.payment.enums.CodeResponse;
import com.booking.payment.enums.LanguageEnum;
import com.booking.payment.utils.Constants;
import com.booking.payment.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class HomeController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/home")
    public ResponseEntity<Response> home(@RequestParam(defaultValue = Constants.DEFAULT_LANGUAGE) LanguageEnum language) {
        String message = MessageUtil.toMessage("response.success", language, messageSource);
        Response response = new Response(CodeResponse.SUCCESS.getValue(), message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
