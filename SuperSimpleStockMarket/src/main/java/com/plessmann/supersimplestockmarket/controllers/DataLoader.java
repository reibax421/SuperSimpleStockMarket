/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.supersimplestockmarket.controllers;

import com.plessmann.supersimplestockmarket.datasource.PersistenceStock;
import com.plessmann.supersimplestockmarket.models.StockData;

/**
 *
 * @author Plesse
 */
public class DataLoader {
    
    public void load(){
        PersistenceStock.getInstance().saveStockData(new StockData("TEA", "Common", 0, 0, 100));
        PersistenceStock.getInstance().saveStockData(new StockData("POP", "Common", 8, 0, 100));
        PersistenceStock.getInstance().saveStockData(new StockData("ALE", "Common", 23, 0, 60));
        PersistenceStock.getInstance().saveStockData(new StockData("GIN", "Preferred", 8, 2, 100));
        PersistenceStock.getInstance().saveStockData(new StockData("JOE", "Common", 13, 0, 250));
    }
    
}
