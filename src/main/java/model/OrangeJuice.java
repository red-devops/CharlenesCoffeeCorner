package model;

import constant.Constant;

import java.util.Objects;

public class OrangeJuice extends Product {

    private double price = Constant.ORANGE_JUICE_PRICE;
    private String name = "Orange juice";

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrangeJuice that = (OrangeJuice) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}
