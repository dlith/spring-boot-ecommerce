package com.dzmitry.springbootecommerce.service;

import com.dzmitry.springbootecommerce.dao.CustomerRepository;
import com.dzmitry.springbootecommerce.dto.Purchase;
import com.dzmitry.springbootecommerce.dto.PurchaseResponse;
import com.dzmitry.springbootecommerce.entity.Customer;
import com.dzmitry.springbootecommerce.entity.Order;
import com.dzmitry.springbootecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();
        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        // populate order with orderitems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        // populate order with billing Addres and shipping address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);
        // save to the DB
        customerRepository.save(customer);
        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
