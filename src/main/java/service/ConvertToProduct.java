package service;

import model.BaconRoll;
import model.Coffee;
import model.OrangeJuice;
import model.Product;
import model.Addition;
import model.Extras;
import model.Size;

public class ConvertToProduct {
    public static Product convert(String product) {
        if (product.matches("bacon-roll")) { return new BaconRoll(); }
        else if (product.matches("orange-juice")) { return new OrangeJuice(); }
        else if (product.matches("^.*coffee")){ return selectCoffeeSize(product); }
        else if (product.matches("add.*")){ return selectAddition(product); }
        else { return null; }
    }

    private static Product selectCoffeeSize(String product) {
        if (product.matches("s-coffee")) { return new Coffee(Size.SMALL); }
        else if (product.matches("m-coffee")) { return new Coffee(Size.MEDIUM); }
        else { return new Coffee(Size.LARGE); }
    }

    private static Product selectAddition(String product) {
        if (product.matches("add-em")) { return new Addition(Extras.EXTRA_MILK); }
        else if (product.matches("add-fm")) { return new Addition(Extras.FOAMED_MILK); }
        else { return new Addition(Extras.ROAST_COFFEE); }
    }
}