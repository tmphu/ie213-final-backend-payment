package com.booking.payment.dto;

import com.booking.payment.enums.PartnerEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentRequest {

    public PartnerEnum partner;
    public String orderNumber;
    public Long paymentAmount;
    public String paymentMethod = "VNPAY";

}
