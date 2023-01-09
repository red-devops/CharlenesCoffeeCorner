package service;

import constant.Constant;
import model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    CalculatePayment calculatePayment = new CalculatePayment();

    public void processOrder(String[] args) {
        List<String> orderList = filterOrder(new ArrayList<String>(Arrays.asList(args)));
        if(!orderList.isEmpty()) {
        List<Product> productList = convertStringToProduct(new ArrayList<String>(orderList));
        calculatePayment.calculatePayment(productList);
        }
        else System.out.println("No valid arguments!");
    }

    private List<String> filterOrder(ArrayList<String> args) {
        return args.stream().filter(i -> Constant.availableProducts.contains(i.toString())).collect(Collectors.toList());
    }

    private List<Product> convertStringToProduct(ArrayList<String> orderList) {
        return orderList.stream().map(ConvertToProduct::convert).collect(Collectors.toList());
    }


}
