package constant;

import java.util.Arrays;
import java.util.List;

public final class Constant {
    public static final double SMALL_COFFEE_PRICE = 2.5;
    public static final double MEDIUM_COFFEE_PRICE = 3.0;
    public static final double LARGE_COFFEE_PRICE = 3.5;
    public static final double ORANGE_JUICE_PRICE = 3.95;
    public static final double BACON_ROLL_PRICE = 4.5;
    public static final double EXTRA_MILK_PRICE = 0.3;
    public static final double FOAMED_MILK_PRICE = 0.5;
    public static final double SPECIAL_ROAST_COFFEE_PRICE = 0.9;

    public static final List<String> availableProducts = Arrays.asList(
            "s-coffee",      // small coffee
            "m-coffee",      // medium coffee
            "l-coffee",      // large coffee
            "add-em",        // extra milk
            "add-fm",        // foamed milk
            "add-rc",        // special roast coffee
            "bacon-roll",    // bacon roll
            "orange-juice"   // orange juice
    );
}