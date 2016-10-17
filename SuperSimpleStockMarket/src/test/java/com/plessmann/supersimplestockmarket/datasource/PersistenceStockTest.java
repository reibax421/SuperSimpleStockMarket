/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.supersimplestockmarket.datasource;

import com.plessmann.supersimplestockmarket.models.Stock;
import com.plessmann.supersimplestockmarket.models.StockData;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Plesse
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersistenceStockTest {
    
    /**
     * Test of getInstance method, of class PersintenceStock.
     */
    @Test
    public void testAGetInstance() {
        System.out.println("getInstance");
        PersistenceStock result = PersistenceStock.getInstance();
        assertNotNull("Instance should not be null", result);
    }
    
    /**
     * Test of saveStockData method, of class PersintenceStock.
     */
    @Test
    public void testBSaveStockData() {
        System.out.println("saveStockData");
        StockData stockData = new StockData("TEA", "Common", 0, 0, 100);
        PersistenceStock.getInstance().saveStockData(new StockData("TEA", "Common", 0, 0, 100));
        PersistenceStock.getInstance().saveStockData(new StockData("POP", "Common", 8, 0, 100));
        PersistenceStock.getInstance().saveStockData(new StockData("ALE", "Common", 23, 0, 60));
        PersistenceStock.getInstance().saveStockData(new StockData("GIN", "Preferred", 8, 2, 100));
        PersistenceStock.getInstance().saveStockData(new StockData("JOE", "Common", 13, 0, 250));
        StockData result = PersistenceStock.getInstance().getStockData("TEA");
        System.out.println((result == null));
        assertEquals(stockData, result);
    }

    /**
     * Test of getStockData method, of class PersintenceStock.
     */
    @Test
    public void testCGetStockData() {
        System.out.println("getStockData");
        String type = "TEA";
        StockData stockData = new StockData(type, "Common", 0, 0, 100);
        StockData result = PersistenceStock.getInstance().getStockData(type);
        assertEquals(stockData, result);
    }

    /**
     * Test of saveStock method, of class PersistenceStock.
     */
    @Test
    public void testDSaveStock() {
        System.out.println("saveStock");
        StockData stockData = PersistenceStock.getInstance().getStockData("TEA");
        Stock stock = new Stock(System.currentTimeMillis(), 1, true, 122.6f, stockData);
        PersistenceStock.getInstance().saveStock(stock);
        long timeReference = System.currentTimeMillis() - 300000;
        List<Stock> result = PersistenceStock.getInstance().getStockByTime(stockData, timeReference);
        assertFalse("List must not be empty", result.isEmpty());
    }

    

    /**
     * Test of getStockByTime method, of class PersistenceStock.
     */
    @Test
    public void testEGetStockByTime() {
        System.out.println("getStockByTime");
        StockData stockData = PersistenceStock.getInstance().getStockData("TEA");
        long timeReference = System.currentTimeMillis() - 300000;
        List<Stock> result = PersistenceStock.getInstance().getStockByTime(stockData, timeReference);
        assertFalse("List must not be empty", result.isEmpty());
    }

    
    
    
    
}
