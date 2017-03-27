package com.bootcamp.ttn;

public class Product extends TTNCafeBase{

    private int price;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String productId, int price,int quantity) {
        super(productId);
        this.price = price;
        this.quantity = quantity;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




}
