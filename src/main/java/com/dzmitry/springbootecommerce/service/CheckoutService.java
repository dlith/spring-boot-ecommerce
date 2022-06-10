package com.dzmitry.springbootecommerce.service;

import com.dzmitry.springbootecommerce.dto.Purchase;
import com.dzmitry.springbootecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
