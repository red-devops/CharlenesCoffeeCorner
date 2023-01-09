package model;

import constant.Constant;

import java.util.Objects;

public class BaconRoll extends Product {

    private double price = Constant.BACON_ROLL_PRICE;
    private String name = "Bacon roll";

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
        BaconRoll baconRoll = (BaconRoll) o;
        return Double.compare(baconRoll.price, price) == 0 && Objects.equals(name, baconRoll.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }
}
