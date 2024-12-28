package com.billing.dto;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private Long billId;
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;
    private Double amount;
}
