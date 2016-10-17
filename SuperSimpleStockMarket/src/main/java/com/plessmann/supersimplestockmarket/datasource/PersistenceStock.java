/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.supersimplestockmarket.datasource;

import com.plessmann.supersimplestockmarket.models.Stock;
import com.plessmann.supersimplestockmarket.models.StockData;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Plesse
 */
public class PersistenceStock {
    
    protected static PersistenceStock me = null;
    
    private final List<Stock> stocks;
    private final List<StockData> stockData;

    public PersistenceStock() {
        stocks = new ArrayList<>();
        stockData = new ArrayList<>();
    }
    
    public static synchronized PersistenceStock getInstance() {
        if(me == null){
            me = new PersistenceStock();
        }
        return me;
    }
    
    public StockData getStockData(String type){
        return stockData.stream().filter(sd -> sd.getStockSymbol().equalsIgnoreCase(type)).findFirst().orElse(null);
    }
    
    public void saveStockData(StockData stockData1){
        stockData.add(stockData1);
    }
    
    public List<Stock> getStockByTime(StockData stockData, long timeReference){
        return stocks.stream().filter(sd -> sd.getStockData().getType().equalsIgnoreCase(stockData.getType()) && sd.getTimestamp() > timeReference).collect(Collectors.toList());
    }
    
    public void saveStock(Stock stock){
        stocks.add(stock);
    }
    
    public boolean isStockDataLoaded(){
        return stockData.isEmpty();
    }
    
    public boolean isStocksEmpty(){
        return stockData.isEmpty();
    }

    public List<StockData> getStockData() {
        return stockData;
    }
    
    
    
}
