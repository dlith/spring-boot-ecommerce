package com.dzmitry.springbootecommerce.dto;

import com.dzmitry.springbootecommerce.entity.Address;
import com.dzmitry.springbootecommerce.entity.Customer;
import com.dzmitry.springbootecommerce.entity.Order;
import com.dzmitry.springbootecommerce.entity.OrderItem;
import lombok.Data;
import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
