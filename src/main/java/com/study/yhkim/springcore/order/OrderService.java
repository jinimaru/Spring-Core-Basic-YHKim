package com.study.yhkim.springcore.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
