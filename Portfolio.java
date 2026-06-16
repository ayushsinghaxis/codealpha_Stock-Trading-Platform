import java.util.HashMap;

public class Portfolio {

    private HashMap<String, Integer> holdings = new HashMap<>();

    public void buyStock(String symbol, int quantity) {
        holdings.put(symbol,
                holdings.getOrDefault(symbol, 0) + quantity);
    }

    public boolean sellStock(String symbol, int quantity) {

        if (!holdings.containsKey(symbol) ||
                holdings.get(symbol) < quantity) {
            return false;
        }

        holdings.put(symbol,
                holdings.get(symbol) - quantity);

        if (holdings.get(symbol) == 0)
            holdings.remove(symbol);

        return true;
    }

    public HashMap<String, Integer> getHoldings() {
        return holdings;
    }

    public void displayPortfolio() {
        System.out.println("\nPortfolio Holdings");

        if (holdings.isEmpty()) {
            System.out.println("No stocks owned.");
            return;
        }

        for (String stock : holdings.keySet()) {
            System.out.println(stock +
                    " -> " +
                    holdings.get(stock) + " shares");
        }
    }
}