package model;

import constant.Constant;

import java.util.Objects;

public class Addition extends Product {
    private Extras extras;
    private String name;

    public Addition (Extras extras) {
        this.extras = extras;
    }

    @Override
    public double getPrice() {
        switch (extras){
            case EXTRA_MILK:
                return Constant.EXTRA_MILK_PRICE;
            case FOAMED_MILK:
                return Constant.FOAMED_MILK_PRICE;
            case ROAST_COFFEE:
                return Constant.SPECIAL_ROAST_COFFEE_PRICE;
            default:
                return 0;
        }
    }

    @Override
    public String getName() {
        switch (extras){
            case EXTRA_MILK:
                return "Extra milk";
            case FOAMED_MILK:
                return "Foamed milk";
            case ROAST_COFFEE:
                return "Special roast coffee";
            default:
                return "";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Addition addition = (Addition) o;
        return extras == addition.extras && Objects.equals(name, addition.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extras, name);
    }
}
