package com.example.girdview;

public class OilsAndGheeModel {

    int OilsAndGheeImage;
    String OilsAndGheeName,OilsAndGheeQuantity,OilsAndGheePrice,OilsAndGheePriceLeft;

    public OilsAndGheeModel(int oilsAndGheeImage, String oilsAndGheeName, String oilsAndGheeQuantity, String oilsAndGheePrice, String oilsAndGheePriceLeft) {
        OilsAndGheeImage = oilsAndGheeImage;
        OilsAndGheeName = oilsAndGheeName;
        OilsAndGheeQuantity = oilsAndGheeQuantity;
        OilsAndGheePrice = oilsAndGheePrice;
        OilsAndGheePriceLeft = oilsAndGheePriceLeft;
    }

    public int getOilsAndGheeImage() {
        return OilsAndGheeImage;
    }

    public void setOilsAndGheeImage(int oilsAndGheeImage) {
        OilsAndGheeImage = oilsAndGheeImage;
    }

    public String getOilsAndGheeName() {
        return OilsAndGheeName;
    }

    public void setOilsAndGheeName(String oilsAndGheeName) {
        OilsAndGheeName = oilsAndGheeName;
    }

    public String getOilsAndGheeQuantity() {
        return OilsAndGheeQuantity;
    }

    public void setOilsAndGheeQuantity(String oilsAndGheeQuantity) {
        OilsAndGheeQuantity = oilsAndGheeQuantity;
    }

    public String getOilsAndGheePrice() {
        return OilsAndGheePrice;
    }

    public void setOilsAndGheePrice(String oilsAndGheePrice) {
        OilsAndGheePrice = oilsAndGheePrice;
    }

    public String getOilsAndGheePriceLeft() {
        return OilsAndGheePriceLeft;
    }

    public void setOilsAndGheePriceLeft(String oilsAndGheePriceLeft) {
        OilsAndGheePriceLeft = oilsAndGheePriceLeft;
    }
}
