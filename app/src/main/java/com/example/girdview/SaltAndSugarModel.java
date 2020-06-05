package com.example.girdview;

public class SaltAndSugarModel {
    int SaltAndSugarImage;
    String SaltAndSugarName,SaltAndSugarQuantity,SaltAndSugarPrice,SaltAndSugarPriceLeft;

    public SaltAndSugarModel(int saltAndSugarImage, String saltAndSugarName, String saltAndSugarQuantity, String saltAndSugarPrice, String saltAndSugarPriceLeft) {
        SaltAndSugarImage = saltAndSugarImage;
        SaltAndSugarName = saltAndSugarName;
        SaltAndSugarQuantity = saltAndSugarQuantity;
        SaltAndSugarPrice = saltAndSugarPrice;
        SaltAndSugarPriceLeft = saltAndSugarPriceLeft;
    }

    public int getSaltAndSugarImage() {
        return SaltAndSugarImage;
    }

    public void setSaltAndSugarImage(int saltAndSugarImage) {
        SaltAndSugarImage = saltAndSugarImage;
    }

    public String getSaltAndSugarName() {
        return SaltAndSugarName;
    }

    public void setSaltAndSugarName(String saltAndSugarName) {
        SaltAndSugarName = saltAndSugarName;
    }

    public String getSaltAndSugarQuantity() {
        return SaltAndSugarQuantity;
    }

    public void setSaltAndSugarQuantity(String saltAndSugarQuantity) {
        SaltAndSugarQuantity = saltAndSugarQuantity;
    }

    public String getSaltAndSugarPrice() {
        return SaltAndSugarPrice;
    }

    public void setSaltAndSugarPrice(String saltAndSugarPrice) {
        SaltAndSugarPrice = saltAndSugarPrice;
    }

    public String getSaltAndSugarPriceLeft() {
        return SaltAndSugarPriceLeft;
    }

    public void setSaltAndSugarPriceLeft(String saltAndSugarPriceLeft) {
        SaltAndSugarPriceLeft = saltAndSugarPriceLeft;
    }
}
