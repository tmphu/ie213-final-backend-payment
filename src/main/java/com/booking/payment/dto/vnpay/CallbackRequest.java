package com.booking.payment.dto.vnpay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CallbackRequest {

    public String amount;
    public String bankCode;
    public String bankTranNo;
    public String cardType;
    public String orderInfo;
    public String payDate;
    public String responseCode;
    public String tmnCode;
    public String transactionNo;
    public String transactionStatus;
    public String txnRef;
    public String secureHash;
}
