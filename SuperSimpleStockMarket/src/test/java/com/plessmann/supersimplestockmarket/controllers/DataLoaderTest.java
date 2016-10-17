/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.supersimplestockmarket.controllers;

import com.plessmann.supersimplestockmarket.datasource.PersistenceStock;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Plesse
 */
public class DataLoaderTest {
    
    /**
     * Test of load method, of class DataLoader.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        DataLoader instance = new DataLoader();
        instance.load();
        assertFalse("StockData list must not be empty", PersistenceStock.getInstance().isStockDataLoaded());
    }
    
}
