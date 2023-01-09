package service;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateBonus {

    List<ReceiptRow> calculateBonus(List<Product> productList) {
        List<ReceiptRow> bonusList = getBonusForEveryFifthDrink(productList);
        bonusList.addAll(getBonusForSandwichAndDrink(productList));
        return bonusList;
    }

    private List<ReceiptRow> getBonusForSandwichAndDrink(List<Product> productList) {
        List<ReceiptRow> bonusList = new ArrayList<ReceiptRow>();
        if (getAdditionList(productList).size() == 0)  return bonusList;
        int numberOfBonuses = getNumberOfSandwichAndDrinkSets(productList);

        List<Product> additionList = getAdditionList(productList);
        for (int i = 0; i < numberOfBonuses; i++ ){
            Product chipestAddition = getChipesProduct(additionList);
            additionList.remove(chipestAddition);
            bonusList.add(formatReciptBonus(chipestAddition));
        }
        return bonusList;
    }

    private int getNumberOfSandwichAndDrinkSets(List<Product> productList) {
        int numeberOfSandwich = getSandwichList(productList).size();
        int numberOfDrinks = getDrinkList(productList).size();
        int numberOfSets = 0;
        if (numberOfDrinks > 0 && numeberOfSandwich > 0 ) {
            if (numberOfDrinks > numeberOfSandwich) {
                numberOfSets = numeberOfSandwich;
            }
            else{
                numberOfSets = numberOfDrinks;
            }
        }
        return numberOfSets;
    }

    private List<ReceiptRow> getBonusForEveryFifthDrink(List<Product> productList) {
        List<ReceiptRow> bonusList = new ArrayList<ReceiptRow>();
        List<Product> drinkList = getDrinkList(productList);
        if (drinkList.size() == 0 ) return bonusList;

        int numberOfBonuses = drinkList.size() / 5;
        for (int i = 0; i < numberOfBonuses; i++ ){
            Product chipestDrink = getChipesProduct(drinkList);
            drinkList.remove(chipestDrink);
            bonusList.add(formatReciptBonus(chipestDrink));
        }
        return bonusList;
    }

    private Product getChipesProduct(List<Product> productList) {
        Product chipestProduct = productList.get(0);
        for (Product product : productList) {
            if (product.getPrice() < chipestProduct.getPrice() ){
                chipestProduct = product;
            }
        }
        return chipestProduct;
    }

    private ReceiptRow formatReciptBonus(Product product) {
        return new ReceiptRow("Bonus " + product.getName() + "...." + product.getPrice() * -1, product.getPrice() * -1);
    }

    private List<Product> getDrinkList(List<Product> productList) {
        return productList.stream().filter(i -> i instanceof Coffee || i instanceof OrangeJuice).collect(Collectors.toList());
    }

    private List<Product> getAdditionList(List<Product> productList) {
        return productList.stream().filter(i -> i instanceof Addition).collect(Collectors.toList());
    }

    private List<Product> getSandwichList(List<Product> productList) {
        return productList.stream().filter(i -> i instanceof BaconRoll).collect(Collectors.toList());
    }
}