package com.example.girdview;

public class HairCareModel {

    int HairAndCareImage;
    String HairAndCareName,HairAndCareQuantity,HairAndCarePrice,HairAndCarePriceLeft;

    public HairCareModel(int hairAndCareImage, String hairAndCareName, String hairAndCareQuantity, String hairAndCarePrice, String hairAndCarePriceLeft) {
        HairAndCareImage = hairAndCareImage;
        HairAndCareName = hairAndCareName;
        HairAndCareQuantity = hairAndCareQuantity;
        HairAndCarePrice = hairAndCarePrice;
        HairAndCarePriceLeft = hairAndCarePriceLeft;
    }

    public int getHairAndCareImage() {
        return HairAndCareImage;
    }

    public void setHairAndCareImage(int hairAndCareImage) {
        HairAndCareImage = hairAndCareImage;
    }

    public String getHairAndCareName() {
        return HairAndCareName;
    }

    public void setHairAndCareName(String hairAndCareName) {
        HairAndCareName = hairAndCareName;
    }

    public String getHairAndCareQuantity() {
        return HairAndCareQuantity;
    }

    public void setHairAndCareQuantity(String hairAndCareQuantity) {
        HairAndCareQuantity = hairAndCareQuantity;
    }

    public String getHairAndCarePrice() {
        return HairAndCarePrice;
    }

    public void setHairAndCarePrice(String hairAndCarePrice) {
        HairAndCarePrice = hairAndCarePrice;
    }

    public String getHairAndCarePriceLeft() {
        return HairAndCarePriceLeft;
    }

    public void setHairAndCarePriceLeft(String hairAndCarePriceLeft) {
        HairAndCarePriceLeft = hairAndCarePriceLeft;
    }
}
