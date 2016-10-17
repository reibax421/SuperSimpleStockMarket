Super Simple Stock Market by Iñaki De Tejada Plessmann

This is an implementation for JP Morgan's code test. It has a very simple
architecture consisting on 2 controllers for the functionality and 1 Singleton
to simulate a persistance unit such as a database.

The singleton, PersistenceStock, consist of 2 lists to store the Stock Type
information and another list to store the Stocks that are being purchased by
the investors. It has simple methods to query the data using Java 8 functional
approach.

The case of the controllers works as follows:

    - DataLoader: Very simple controller that loads the information of
      the stocks type in the PersistenceStock.

    - StockController: This controller implements the functionality described
      in the document using 4 functions and one method.
        
        - getDividendYield(float price, StockData stockData): Calculates
          the dividend of the stock following the formula described in the
          documentation.
          
        - getPERatio(float price, StockData stockData): Calculates
          the P/E ratio of the stock following the formula described in the
          documentation.

        - recordTrade(Stock stock): Saves a bought stock in the persistence unit

        - getVolumeWeightedStockPrice(StockData stockData): Calculates
          the Volume Weighted Stock Price of the stock following the formula 
          described in the documentation. For this it queries the PersistenceStock
          to retrieve the stocks associated with stockData that were bought in 
          the last 5 minutes and then proceeds to sum the elements of the
          list to generate the values for the formula. If the divisor is 0
          i assumed it had to be changed to 1 to avoid NaN errors.

        - getGBCE(): Calculates the GBCE using the getVolumeWeightedStockPrice
          for each stock type and then proceeds reduce the map of values to
          finally apply the nth-root where n is the amount of stock types.

All this methods and functions have their tests written using JUnit 4.



