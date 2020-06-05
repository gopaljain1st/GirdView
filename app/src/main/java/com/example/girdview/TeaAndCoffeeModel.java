package com.example.girdview;

public class TeaAndCoffeeModel {

    int TeaAndCoffeeImage;
    String TeaAndCoffeeName,TeaAndCoffeePrice,TeaAndCoffeePriceLeft,TeaAndCoffeeQuantity;

    public TeaAndCoffeeModel(int teaAndCoffeeImage, String teaAndCoffeeName, String teaAndCoffeePrice, String teaAndCoffeePriceLeft, String teaAndCoffeeQuantity) {
        TeaAndCoffeeImage = teaAndCoffeeImage;
        TeaAndCoffeeName = teaAndCoffeeName;
        TeaAndCoffeePrice = teaAndCoffeePrice;
        TeaAndCoffeePriceLeft = teaAndCoffeePriceLeft;
        TeaAndCoffeeQuantity = teaAndCoffeeQuantity;
    }

    public int getTeaAndCoffeeImage() {
        return TeaAndCoffeeImage;
    }

    public void setTeaAndCoffeeImage(int teaAndCoffeeImage) {
        TeaAndCoffeeImage = teaAndCoffeeImage;
    }

    public String getTeaAndCoffeeName() {
        return TeaAndCoffeeName;
    }

    public void setTeaAndCoffeeName(String teaAndCoffeeName) {
        TeaAndCoffeeName = teaAndCoffeeName;
    }

    public String getTeaAndCoffeePrice() {
        return TeaAndCoffeePrice;
    }

    public void setTeaAndCoffeePrice(String teaAndCoffeePrice) {
        TeaAndCoffeePrice = teaAndCoffeePrice;
    }

    public String getTeaAndCoffeePriceLeft() {
        return TeaAndCoffeePriceLeft;
    }

    public void setTeaAndCoffeePriceLeft(String teaAndCoffeePriceLeft) {
        TeaAndCoffeePriceLeft = teaAndCoffeePriceLeft;
    }

    public String getTeaAndCoffeeQuantity() {
        return TeaAndCoffeeQuantity;
    }

    public void setTeaAndCoffeeQuantity(String teaAndCoffeeQuantity) {
        TeaAndCoffeeQuantity = teaAndCoffeeQuantity;
    }
}
