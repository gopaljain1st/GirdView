package com.example.girdview;

public class Order {
    int imageid;
    int itemId,sellerId;
    String productname;
    String brandname;
    String productprice;
    String sellingPrice;
    int qty;

    public Order(int itemId, int sellerId, String productname, String sellingPrice, int qty) {
        this.itemId = itemId;
        this.sellerId = sellerId;
        this.productname = productname;
        this.sellingPrice = sellingPrice;
        this.qty = qty;
    }

    public Order(int imageid, String productname, String brandname, String productprice, String sellingPrice, int qty) {
        this.imageid = imageid;
        this.productname = productname;
        this.brandname = brandname;
        this.productprice = productprice;
        this.sellingPrice = sellingPrice;
        this.qty = qty;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
