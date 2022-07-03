package main.java;

import service.OrderService;

public class Main {
    public static void main(String[] args){
        OrderService orderService = new OrderService();
        orderService.processOrder(args);
    }
}