import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private String stockSymbol;
    private int quantity;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(String type, String stockSymbol,
                       int quantity, double amount) {
        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return dateTime + " | " + type +
                " | " + stockSymbol +
                " | Qty: " + quantity +
                " | ₹" + amount;
    }
}