/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.supersimplestockmarket;

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
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(Constants.GREETING);
            String option;
            while(true) {
                System.out.println(Constants.OPTIONS);
                option = br.readLine();
                switch(option.toLowerCase()){
                    case Constants.ONE:

                        break;
                    case Constants.TWO:

                        break;
                    case Constants.THREE:

                        break;
                    case Constants.FOUR:

                        break;
                    case Constants.FIVE:

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
