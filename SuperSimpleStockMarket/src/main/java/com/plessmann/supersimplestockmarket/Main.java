/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.supersimplestockmarket;

import com.plessmann.supersimplestockmarket.controllers.DataLoader;
import com.plessmann.supersimplestockmarket.controllers.StockController;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Plesse
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            DataLoader dataLoader = new DataLoader();
            dataLoader.load();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(Constants.GREETING);
            String option;
            StockController controller = new StockController();
            while(true) {
                System.out.println(Constants.OPTIONS);
                option = br.readLine();
                switch(option.toLowerCase()){
                    case Constants.ONE:
//                        controller.getDividendYield(0, stockData);
                        break;
                    case Constants.TWO:
//                        controller.getPERatio(0, stockData);
                        break;
                    case Constants.THREE:
//                        controller.recordTrade(stock);
                        break;
                    case Constants.FOUR:
//                        controller.getVolumeWeightedStockPrice(stockData);
                        break;
                    case Constants.FIVE:
//                        controller.getGBCE();
                        break;
                    default:
                        System.out.println(Constants.FAREWELL);
                        System.exit(0);
                }
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
}
