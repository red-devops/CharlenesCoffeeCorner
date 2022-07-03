package model;

import constant.Constant;

import java.util.Objects;

public class Coffee extends Product {
    private String name;
    private Size size;
    private double price;

    public Coffee (Size size) {
        this.size = size;
        this.price = getPrice();
    }

    @Override
    public double getPrice() {
        switch (size){
            case SMALL:
                return Constant.SMALL_COFFEE_PRICE;
            case MEDIUM:
                return Constant.MEDIUM_COFFEE_PRICE;
            case LARGE:
                return Constant.LARGE_COFFEE_PRICE;
            default:
                return 0;
        }
    }

    @Override
    public String getName() {
        switch (size){
            case SMALL:
                return "Small coffee";
            case MEDIUM:
                return "Medium coffee";
            case LARGE:
                return "Large coffee";
            default:
                return "";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Double.compare(coffee.price, price) == 0 && Objects.equals(name, coffee.name) && size == coffee.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, price);
    }
}