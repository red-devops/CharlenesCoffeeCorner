package service;

import model.Product;
import model.ReceiptRow;

import java.util.List;
import java.util.stream.Collectors;

public class CalculatePayment {
    CalculateBonus calculateBonus = new CalculateBonus();

    void calculatePayment(List<Product> productList) {
        List<ReceiptRow> receipt = getRecipt(productList);
        receipt.addAll(getBonus(productList));
        printRecipt(receipt, getTotalCost(receipt));
    }

    private List<ReceiptRow> getRecipt(List<Product> productList) {
        return productList.stream().map(product -> {
            return new ReceiptRow(getReceiptFormatting(product), product.getPrice());
        }).collect(Collectors.toList());
    }

    private String getReceiptFormatting(Product product) {
        return "" + product.getName() + "...." + product.getPrice();
    }

    private List<ReceiptRow> getBonus(List<Product> productList) {
        return calculateBonus.calculateBonus(productList);
    }

    private double getTotalCost(List<ReceiptRow> receipt) {
        return receipt.stream()
                .map(receiptRow -> receiptRow.getRowValue())
                .mapToDouble(f -> f.doubleValue())
                .sum();
    }

    private void printRecipt(List<ReceiptRow> receipt, double totalCost) {
        for (ReceiptRow reciptRow : receipt) {
            System.out.println(reciptRow.getReciptRowDescription() + " CHF");
        }
        System.out.println("TOTAL: " + totalCost + " CHF");
    }
}