package com.example.girdview;

public class MasalaModel {
    int MasalasImage;
    String MasalasName,MasalasQuantity,MasalasPrice,MasalasPriceLeft;

    public MasalaModel(int masalasImage, String masalasName, String masalasQuantity, String masalasPrice, String masalasPriceLeft) {
        MasalasImage = masalasImage;
        MasalasName = masalasName;
        MasalasQuantity = masalasQuantity;
        MasalasPrice = masalasPrice;
        MasalasPriceLeft = masalasPriceLeft;
    }

    public int getMasalasImage() {
        return MasalasImage;
    }

    public void setMasalasImage(int masalasImage) {
        MasalasImage = masalasImage;
    }

    public String getMasalasName() {
        return MasalasName;
    }

    public void setMasalasName(String masalasName) {
        MasalasName = masalasName;
    }

    public String getMasalasQuantity() {
        return MasalasQuantity;
    }

    public void setMasalasQuantity(String masalasQuantity) {
        MasalasQuantity = masalasQuantity;
    }

    public String getMasalasPrice() {
        return MasalasPrice;
    }

    public void setMasalasPrice(String masalasPrice) {
        MasalasPrice = masalasPrice;
    }

    public String getMasalasPriceLeft() {
        return MasalasPriceLeft;
    }

    public void setMasalasPriceLeft(String masalasPriceLeft) {
        MasalasPriceLeft = masalasPriceLeft;
    }
}
