/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.supersimplestockmarket.models;

import java.util.Objects;

/**
 *
 * @author Plesse
 */
public class StockData {
    
    private String stockSymbol;
    private String type;
    private float lastDividend;
    private float fixedDividend;
    private float parValue;

    public StockData(String stockSymbol, String type, float lastDividend, float fixedDividend, float parValue) {
        this.stockSymbol = stockSymbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
    }
    
    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(float lastDividend) {
        this.lastDividend = lastDividend;
    }

    public float getFixedDividend() {
        return fixedDividend;
    }

    public void setFixedDividend(float fixedDividend) {
        this.fixedDividend = fixedDividend;
    }

    public float getParValue() {
        return parValue;
    }

    public void setParValue(float parValue) {
        this.parValue = parValue;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.stockSymbol);
        hash = 83 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StockData other = (StockData) obj;
        if (!this.stockSymbol.equalsIgnoreCase(other.stockSymbol)) {
            return false;
        }
        return true;
    }
    
    
    
}
