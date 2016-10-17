/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.supersimplestockmarket.models;

/**
 *
 * @author Plesse
 */
public class Stock {
    
    private long timestamp;
    private int quantity;
    private boolean operationType;
    private float price;

    public Stock(long timestamp, int quantity, boolean operationType, float price) {
        this.timestamp = timestamp;
        this.quantity = quantity;
        this.operationType = operationType;
        this.price = price;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isOperationType() {
        return operationType;
    }

    public void setOperationType(boolean operationType) {
        this.operationType = operationType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
}
