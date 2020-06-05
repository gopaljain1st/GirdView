package com.example.girdview;

public class RiceAndOtherGainsModel {

    int RiceAndGainsImage;
    String RiceName,RicePrice,RicePriceLeft,RiceQuantity;

    public RiceAndOtherGainsModel(int riceAndGainsImage, String riceName, String ricePrice, String ricePriceLeft, String riceQuantity) {
        RiceAndGainsImage = riceAndGainsImage;
        RiceName = riceName;
        RicePrice = ricePrice;
        RicePriceLeft = ricePriceLeft;
        RiceQuantity = riceQuantity;
    }

    public int getRiceAndGainsImage() {
        return RiceAndGainsImage;
    }

    public void setRiceAndGainsImage(int riceAndGainsImage) {
        RiceAndGainsImage = riceAndGainsImage;
    }

    public String getRiceName() {
        return RiceName;
    }

    public void setRiceName(String riceName) {
        RiceName = riceName;
    }

    public String getRicePrice() {
        return RicePrice;
    }

    public void setRicePrice(String ricePrice) {
        RicePrice = ricePrice;
    }

    public String getRicePriceLeft() {
        return RicePriceLeft;
    }

    public void setRicePriceLeft(String ricePriceLeft) {
        RicePriceLeft = ricePriceLeft;
    }

    public String getRiceQuantity() {
        return RiceQuantity;
    }

    public void setRiceQuantity(String riceQuantity) {
        RiceQuantity = riceQuantity;
    }
}
