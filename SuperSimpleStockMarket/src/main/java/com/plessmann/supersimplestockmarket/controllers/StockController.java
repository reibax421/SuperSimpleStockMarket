/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.supersimplestockmarket.controllers;

import com.plessmann.supersimplestockmarket.Constants;
import com.plessmann.supersimplestockmarket.datasource.PersistenceStock;
import com.plessmann.supersimplestockmarket.models.Stock;
import com.plessmann.supersimplestockmarket.models.StockData;
import java.util.List;
import java.util.OptionalDouble;

/**
 *
 * @author Plesse
 */
public class StockController {
    
    public float getDividendYield(float price, StockData stockData) {
        float dividend;
        if(stockData.getType().equalsIgnoreCase(Constants.COMMON)) {
            dividend = stockData.getLastDividend() / price;
        } else {
            dividend = stockData.getFixedDividend() * stockData.getParValue() / price;
        }
        return dividend;
    }
    
    public float getPERatio(float price, StockData stockData) {
        return price / getDividendYield(price, stockData);
    }
    
    public void recordTrade(Stock stock) {
        PersistenceStock.getInstance().saveStock(stock);
    }
    
    public float getVolumeWeightedStockPrice(StockData stockData) {
        List<Stock> stocks = PersistenceStock.getInstance().getStockByTime(stockData, System.currentTimeMillis() - 300000);
        double divisor = stocks.stream().mapToDouble(stock -> stock.getQuantity()).sum();
        return (float) (stocks.stream().mapToDouble(stock -> stock.getPrice() * stock.getQuantity()).sum() / (divisor == 0 ? 1 : divisor));
    }
    
    public float getGBCE() {
        OptionalDouble reduce = PersistenceStock.getInstance().getStockData().stream().mapToDouble(stockData -> getVolumeWeightedStockPrice(stockData)).reduce((double left, double right) -> left * right);
        return (float) Math.pow(reduce.orElse(1), 1.0 / PersistenceStock.getInstance().getStockData().size());
    }
    
}
