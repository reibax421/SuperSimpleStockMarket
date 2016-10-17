/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.supersimplestockmarket.controllers;

import com.plessmann.supersimplestockmarket.datasource.PersistenceStock;
import com.plessmann.supersimplestockmarket.models.Stock;
import com.plessmann.supersimplestockmarket.models.StockData;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Plesse
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockControllerTest {
    
    private final StockController controller;
    private final StockData tea = new StockData("TEA", "Common", 0, 0, 100);
    private final StockData pop = new StockData("POP", "Common", 8, 0, 100);
    private final StockData ale = new StockData("ALE", "Common", 23, 0, 60);
    private final StockData gin = new StockData("GIN", "Preferred", 8, 2, 100);
    private final StockData joe = new StockData("JOE", "Common", 13, 0, 250);
    
    public StockControllerTest() {
        controller = new StockController();
        DataLoader dataLoader = new DataLoader();
        dataLoader.load();
    }

    /**
     * Test of getDividendYield method, of class StockController.
     */
    @Test
    public void testAGetDividendYield() {
        float expectedValue = 2.3f;
        float price = 10f;
        float dividendYield = controller.getDividendYield(price, ale);
        assertEquals("Values must match", expectedValue, dividendYield, 0f);
        expectedValue = 20.0f;
        dividendYield = controller.getDividendYield(price, gin);
        assertEquals("Values must match", expectedValue, dividendYield, 0f);
    }

    /**
     * Test of getPERatio method, of class StockController.
     */
    @Test
    public void testBGetPERatio() {
        float expectedValue = 4.347826f;
        float price = 10f;
        float dividendYield = controller.getPERatio(price, ale);
        assertEquals("Values must match", expectedValue, dividendYield, 0f);
        expectedValue = 0.5f;
        dividendYield = controller.getPERatio(price, gin);
        assertEquals("Values must match", expectedValue, dividendYield, 0f);
    }

    /**
     * Test of recordTrade method, of class StockController.
     */
    @Test
    public void testCRecordTrade() {
        Stock stock = new Stock(System.currentTimeMillis(), 1, true, 1, ale);
        controller.recordTrade(stock);
        assertFalse("List must not be empty", PersistenceStock.getInstance().isStocksEmpty());
    }

    /**
     * Test of getVolumeWeightedStockPrice method, of class StockController.
     */
    @Test
    public void testDGetVolumeWeightedStockPrice() {
        for (int i = 0; i < 20; i++) {
            controller.recordTrade(new Stock(System.currentTimeMillis(), i, true, i * 5, ale));
        }
        float expectedValue = 64.664925f;
        float result = controller.getVolumeWeightedStockPrice(ale);
        assertEquals("Values must match", expectedValue, result, 0f);
    }

    /**
     * Test of getGBCE method, of class StockController.
     */
    @Test
    public void testEGetGBCE() {
        for (int i = 0; i < 20; i++) {
            controller.recordTrade(new Stock(System.currentTimeMillis(), i, true, i * 5, tea));
        }
        for (int i = 0; i < 20; i++) {
            controller.recordTrade(new Stock(System.currentTimeMillis(), i, true, i * 5, pop));
        }
        for (int i = 0; i < 20; i++) {
            controller.recordTrade(new Stock(System.currentTimeMillis(), i, true, i * 5, gin));
        }
        for (int i = 0; i < 20; i++) {
            controller.recordTrade(new Stock(System.currentTimeMillis(), i, true, i * 5, joe));
        }
        float expectedValue = 64.93271f;
        float result = controller.getGBCE();
        System.out.println("result " + result);
        assertEquals("Values must match", expectedValue, result, 0f);
    }
    
}
