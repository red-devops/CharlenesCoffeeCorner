package service;

import model.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OrderServiceTest {

    @ParameterizedTest
    @MethodSource("providePositiveParameterForProcessOrder")
    void testPositiveProcessOrder(String[] orderList, String expectedString){
        OrderService orderService = new OrderService();
        String response = null;
        PrintStream orginalOut = System.out;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(os);
            System.setOut(capture);
            orderService.processOrder(orderList);
            capture.flush();
            response = os.toString();
        } finally {
        }
        assertEquals(response, expectedString);
    }

    private static Stream<Arguments> providePositiveParameterForProcessOrder() {
        return Stream.of(
                Arguments.of(new String[0], "No valid arguments!\r\n"),

                Arguments.of(new String[]{"s-coffee", "m-coffee", "l-coffee", "orange-juice", "add-em", "add-fm", "add-rc"} ,
                        ("Small coffee....2.5 CHF\r\n" +
                                "Medium coffee....3.0 CHF\r\n" +
                                "Large coffee....3.5 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Extra milk....0.3 CHF\r\n" +
                                "Foamed milk....0.5 CHF\r\n" +
                                "Special roast coffee....0.9 CHF\r\n" +
                                "TOTAL: 14.65 CHF\r\n")),

                Arguments.of(new String[]{"s-coffee", "m-coffee", "l-coffee", "orange-juice", "add-em", "add-fm", "add-rc", "orange-juice"} ,
                        ( "Small coffee....2.5 CHF\r\n" +
                                "Medium coffee....3.0 CHF\r\n" +
                                "Large coffee....3.5 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Extra milk....0.3 CHF\r\n" +
                                "Foamed milk....0.5 CHF\r\n" +
                                "Special roast coffee....0.9 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Bonus Small coffee....-2.5 CHF\r\n" +
                                "TOTAL: 16.1 CHF\r\n")),

                Arguments.of(new String[]{"s-coffee", "bacon-roll", "add-em", "add-fm" } ,
                        ( "Small coffee....2.5 CHF\r\n" +
                                "Bacon roll....4.5 CHF\r\n" +
                                "Extra milk....0.3 CHF\r\n" +
                                "Foamed milk....0.5 CHF\r\n" +
                                "Bonus Extra milk....-0.3 CHF\r\n" +
                                "TOTAL: 7.5 CHF\r\n")),

                Arguments.of(new String[]{"s-coffee", "bacon-roll", "m-coffee", "bacon-roll", "add-em", "add-rc"} ,
                        ( "Small coffee....2.5 CHF\r\n" +
                                "Bacon roll....4.5 CHF\r\n" +
                                "Medium coffee....3.0 CHF\r\n" +
                                "Bacon roll....4.5 CHF\r\n" +
                                "Extra milk....0.3 CHF\r\n" +
                                "Special roast coffee....0.9 CHF\r\n" +
                                "Bonus Extra milk....-0.3 CHF\r\n" +
                                "Bonus Special roast coffee....-0.9 CHF\r\n" +
                                "TOTAL: 14.5 CHF\r\n")),

                Arguments.of(new String[]{"orange-juice", "orange-juice", "orange-juice" , "orange-juice", "orange-juice"} ,
                        ( "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Bonus Orange juice....-3.95 CHF\r\n" +
                                "TOTAL: 15.8 CHF\r\n")),

                Arguments.of(new String[]{"orange-juice", "orange-juice", "orange-juice" , "orange-juice", "s-coffee", "bacon-roll", "add-rc"} ,
                        ( "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Small coffee....2.5 CHF\r\n" +
                                "Bacon roll....4.5 CHF\r\n" +
                                "Special roast coffee....0.9 CHF\r\n" +
                                "Bonus Small coffee....-2.5 CHF\r\n" +
                                "Bonus Special roast coffee....-0.9 CHF\r\n" +
                                "TOTAL: 20.3 CHF\r\n"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideNegativeParameterForProcessOrder")
    void testNegativeProcessOrder(String[] orderList, String expectedString){
        OrderService orderService = new OrderService();
        String response = null;
        PrintStream orginalOut = System.out;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(os);
            System.setOut(capture);
            orderService.processOrder(orderList);
            capture.flush();
            response = os.toString();
        } finally {
        }
        assertNotEquals(response, expectedString);
    }

    private static Stream<Arguments> provideNegativeParameterForProcessOrder() {
        return Stream.of(
                Arguments.of(new String[0], ""),

                Arguments.of(new String[]{"s-coffee", "l-coffee", "orange-juice", "add-em", "add-fm", "add-rc"} ,
                        ("Small coffee....2.5 CHF\r\n" +
                                "Large coffee....3.5 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Extra milk....0.3 CHF\r\n" +
                                "Foamed milk....0.5 CHF\r\n" +
                                "Special roast coffee....0.9 CHF\r\n" +
                                "TOTAL: 14.65 CHF\r\n")),

                Arguments.of(new String[]{"s-coffee", "m-coffee", "l-coffee", "orange-juice", "add-em", "add-fm", "add-rc", "orange-juice"} ,
                        ( "Small coffee....2.5 CHF\r\n" +
                                "Medium coffee....3.0 CHF\r\n" +
                                "Large coffee....3.5 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Extra milk....0.3 CHF\r\n" +
                                "Foamed milk....0.5 CHF\r\n" +
                                "Special roast coffee....0.9 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "TOTAL: 18.6 CHF\r\n")),

                Arguments.of(new String[]{"s-coffee", "bacon-roll", "add-em", "add-fm" } ,
                        ( "Small coffee....2.5 CHF\r\n" +
                                "Bacon roll....4.5 CHF\r\n" +
                                "Extra milk....0.3 CHF\r\n" +
                                "Foamed milk....0.5 CHF\r\n" +
                                "TOTAL: 7.8 CHF\r\n")),

                Arguments.of(new String[]{"s-coffee", "bacon-roll", "m-coffee", "bacon-roll", "add-em", "add-rc"} ,
                        ( "Small coffee....2.5 CHF\r\n" +
                                "Bacon roll....4.5 CHF\r\n" +
                                "Medium coffee....3.0 CHF\r\n" +
                                "Bacon roll....4.5 CHF\r\n" +
                                "Extra milk....0.3 CHF\r\n" +
                                "Special roast coffee....0.9 CHF\r\n" +
                                "Bonus Extra milk....-0.3 CHF\r\n" +
                                "TOTAL: 19.4 CHF\r\n")),

                Arguments.of(new String[]{"orange-juice", "orange-juice", "orange-juice" , "orange-juice", "orange-juice"} ,
                        ( "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "TOTAL: 19.75 CHF\r\n")),

                Arguments.of(new String[]{"orange-juice", "orange-juice", "orange-juice" , "orange-juice", "s-coffee", "bacon-roll", "add-rc"} ,
                        ( "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Orange juice....3.95 CHF\r\n" +
                                "Small coffee....2.5 CHF\r\n" +
                                "Bacon roll....4.5 CHF\r\n" +
                                "Special roast coffee....0.9 CHF\r\n" +
                                "Bonus Special roast coffee....-0.9 CHF\r\n" +
                                "TOTAL: 17.8 CHF\r\n"))
        );
    }

    @ParameterizedTest
    @MethodSource("providePositiveParameterForFilterOrder")
    void testPositiveFilterOrder(ArrayList<String> orderList, ArrayList<String> expectedString){
        OrderService orderService = new OrderService();
        try {
            Method filterOrder = OrderService.class.getDeclaredMethod("filterOrder",ArrayList.class );
            filterOrder.setAccessible(true);
            List<String> response = (List<String>)filterOrder.invoke(orderService, orderList);
            assertEquals(response, expectedString);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static Stream<Arguments> providePositiveParameterForFilterOrder() {
        return Stream.of(
                Arguments.of(new ArrayList<String>(Arrays.asList("s-coffee", "super-coffee")),
                        new ArrayList<String>(Arrays.asList("s-coffee"))),
                Arguments.of(new ArrayList<String>(Arrays.asList("bacon-roll", "supper", "orange-juice","add-rc", "add-em",
                                "l-coffee", "m-coffee", "add-fm")),
                        new ArrayList<String>(Arrays.asList("bacon-roll", "orange-juice","add-rc", "add-em",
                                "l-coffee", "m-coffee", "add-fm")))
        );
    }

    @ParameterizedTest
    @MethodSource("provideNegativeParameterForFilterOrder")
    void testNegativeFilterOrder(ArrayList<String> orderList, ArrayList<String> expectedString){
        OrderService orderService = new OrderService();
        try {
            Method filterOrder = OrderService.class.getDeclaredMethod("filterOrder",ArrayList.class );
            filterOrder.setAccessible(true);
            List<String> response = (List<String>)filterOrder.invoke(orderService, orderList);
            assertNotEquals(response, expectedString);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static Stream<Arguments> provideNegativeParameterForFilterOrder() {
        return Stream.of(
                Arguments.of(new ArrayList<String>(Arrays.asList("s-coffee", "super-coffee")),
                        new ArrayList<String>(Arrays.asList("super-coffee"))),
                Arguments.of(new ArrayList<String>(Arrays.asList("bacon-roll", "supper", "orange-juice","add-rc", "add-em",
                                "l-coffee", "m-coffee", "add-fm")),
                        new ArrayList<String>(Arrays.asList("supper", "orange-juice","add-rc", "add-em",
                                "l-coffee", "m-coffee", "add-fm")))
        );
    }

    @ParameterizedTest
    @MethodSource("providePositiveParameterForConvertStringToProduct")
    void testPositiveConvertStringToProduct(List<String> orderList, ArrayList<Product> expected){
        OrderService orderService = new OrderService();
        try {
            Method convertStringToProduct = OrderService.class.getDeclaredMethod("convertStringToProduct",ArrayList.class );
            convertStringToProduct.setAccessible(true);
            List<Product> response = (List<Product>)convertStringToProduct.invoke(orderService, orderList);
            assertEquals(response, expected);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static Stream<Arguments> providePositiveParameterForConvertStringToProduct() {
        return Stream.of(
                Arguments.of(new ArrayList<String>(Arrays.asList("s-coffee")),
                        new ArrayList<Product>(Arrays.asList(new Coffee(Size.SMALL)))),
                Arguments.of(new ArrayList<String>(Arrays.asList("s-coffee", "s-coffee", "m-coffee", "l-coffee","bacon-roll"
                                ,"add-em", "add-fm", "add-rc", "orange-juice"  )),
                        new ArrayList<Product>(Arrays.asList(new Coffee(Size.SMALL), new Coffee(Size.SMALL), new Coffee(Size.MEDIUM),
                                new Coffee(Size.LARGE), new BaconRoll(), new Addition(Extras.EXTRA_MILK), new Addition(Extras.FOAMED_MILK),
                                new Addition(Extras.ROAST_COFFEE), new OrangeJuice()))
                ));
    }

    @ParameterizedTest
    @MethodSource("provideNegativeParameterForConvertStringToProduct")
    void testNegativeConvertStringToProduct(List<String> orderList, ArrayList<Product> expected){
        OrderService orderService = new OrderService();
        try {
            Method convertStringToProduct = OrderService.class.getDeclaredMethod("convertStringToProduct",ArrayList.class );
            convertStringToProduct.setAccessible(true);
            List<Product> response = (List<Product>)convertStringToProduct.invoke(orderService, orderList);
            assertNotEquals(response, expected);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static Stream<Arguments> provideNegativeParameterForConvertStringToProduct() {
        return Stream.of(
                Arguments.of(new ArrayList<String>(Arrays.asList("s-coffee")),
                        new ArrayList<Product>(Arrays.asList(new OrangeJuice())),
                Arguments.of(new ArrayList<String>(Arrays.asList("s-coffee", "s-coffee", "m-coffee", "l-coffee","bacon-roll"
                                ,"add-em", "add-fm", "add-rc", "orange-juice"  )),
                        new ArrayList<Product>(Arrays.asList(new Coffee(Size.MEDIUM), new Coffee(Size.SMALL), new BaconRoll(),
                                new Coffee(Size.LARGE), new BaconRoll(), new Addition(null), new Addition(Extras.FOAMED_MILK),
                                new Addition(Extras.ROAST_COFFEE), new OrangeJuice()))
                )));
    }
}