package com.example.girdview;

public class LaundryAndDetergentModel {

    int detergentImage;
    String detergentName,detergentQuantity,detergentLeftPrice,detergentPrice;

    public LaundryAndDetergentModel(int detergentImage, String detergentName, String detergentQuantity, String detergentLeftPrice, String detergentPrice) {
        this.detergentImage = detergentImage;
        this.detergentName = detergentName;
        this.detergentQuantity = detergentQuantity;
        this.detergentLeftPrice = detergentLeftPrice;
        this.detergentPrice = detergentPrice;
    }

    public int getDetergentImage() {
        return detergentImage;
    }

    public void setDetergentImage(int detergentImage) {
        this.detergentImage = detergentImage;
    }

    public String getDetergentName() {
        return detergentName;
    }

    public void setDetergentName(String detergentName) {
        this.detergentName = detergentName;
    }

    public String getDetergentQuantity() {
        return detergentQuantity;
    }

    public void setDetergentQuantity(String detergentQuantity) {
        this.detergentQuantity = detergentQuantity;
    }

    public String getDetergentLeftPrice() {
        return detergentLeftPrice;
    }

    public void setDetergentLeftPrice(String detergentLeftPrice) {
        this.detergentLeftPrice = detergentLeftPrice;
    }

    public String getDetergentPrice() {
        return detergentPrice;
    }

    public void setDetergentPrice(String detergentPrice) {
        this.detergentPrice = detergentPrice;
    }
}
