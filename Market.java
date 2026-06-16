import java.util.ArrayList;

public class Market {

    private ArrayList<Stock> stocks = new ArrayList<>();

    public Market() {

        stocks.add(new Stock("TCS",
                "Tata Consultancy Services", 4200));

        stocks.add(new Stock("INFY",
                "Infosys", 1700));

        stocks.add(new Stock("RELIANCE",
                "Reliance Industries", 2900));

        stocks.add(new Stock("HDFC",
                "HDFC Bank", 1650));
    }

    public void displayStocks() {

        System.out.println("\nMarket Data");

        for(Stock stock : stocks) {
            System.out.println(stock);
        }
    }

    public Stock getStock(String symbol) {

        for(Stock stock : stocks) {
            if(stock.getSymbol().equalsIgnoreCase(symbol))
                return stock;
        }

        return null;
    }
}