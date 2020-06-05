package com.example.girdview;

public class AttaAndOtherModel {

    int itemImage;
    String itemName,itemQuantity,itemLeftPrice,itemPrice;

    public AttaAndOtherModel(int itemImage, String itemName, String itemQuantity, String itemLeftPrice, String itemPrice) {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemLeftPrice = itemLeftPrice;
        this.itemPrice = itemPrice;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemLeftPrice() {
        return itemLeftPrice;
    }

    public void setItemLeftPrice(String itemLeftPrice) {
        this.itemLeftPrice = itemLeftPrice;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
