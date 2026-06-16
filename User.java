import java.util.ArrayList;

public class User {

    private String name;
    private double balance;
    private Portfolio portfolio;
    private ArrayList<Transaction> transactions;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.portfolio = new Portfolio();
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void buyStock(Stock stock, int qty) {

        double cost = stock.getPrice() * qty;

        if(cost > balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        balance -= cost;
        portfolio.buyStock(stock.getSymbol(), qty);

        transactions.add(
                new Transaction("BUY",
                        stock.getSymbol(),
                        qty,
                        cost));

        System.out.println("Stock Purchased!");
    }

    public void sellStock(Stock stock, int qty) {

        if(!portfolio.sellStock(stock.getSymbol(), qty)) {
            System.out.println("Not enough shares.");
            return;
        }

        double amount = stock.getPrice() * qty;
        balance += amount;

        transactions.add(
                new Transaction("SELL",
                        stock.getSymbol(),
                        qty,
                        amount));

        System.out.println("Stock Sold!");
    }

    public void showTransactions() {

        System.out.println("\nTransaction History");

        for(Transaction t : transactions) {
            System.out.println(t);
        }
    }
}