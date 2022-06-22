package com.dzmitry.springbootecommerce.service;

import com.dzmitry.springbootecommerce.dto.PaymentInfo;
import com.dzmitry.springbootecommerce.dto.Purchase;
import com.dzmitry.springbootecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;

}
