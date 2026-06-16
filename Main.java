import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Market market = new Market();

        User user =
                new User("Ayush", 100000);

        while(true) {

            System.out.println("\n===== STOCK TRADING SYSTEM =====");

            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Transactions");
            System.out.println("6. Balance");
            System.out.println("7. Exit");

            System.out.print("Choice: ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    market.displayStocks();
                    break;

                case 2:

                    System.out.print("Stock Symbol: ");
                    String buySymbol = sc.next();

                    System.out.print("Quantity: ");
                    int buyQty = sc.nextInt();

                    Stock buyStock =
                            market.getStock(buySymbol);

                    if(buyStock != null)
                        user.buyStock(buyStock, buyQty);
                    else
                        System.out.println("Stock Not Found");

                    break;

                case 3:

                    System.out.print("Stock Symbol: ");
                    String sellSymbol = sc.next();

                    System.out.print("Quantity: ");
                    int sellQty = sc.nextInt();

                    Stock sellStock =
                            market.getStock(sellSymbol);

                    if(sellStock != null)
                        user.sellStock(sellStock, sellQty);
                    else
                        System.out.println("Stock Not Found");

                    break;

                case 4:
                    user.getPortfolio()
                            .displayPortfolio();
                    break;

                case 5:
                    user.showTransactions();
                    break;

                case 6:
                    System.out.println(
                            "Balance: ₹" +
                                    user.getBalance());
                    break;

                case 7:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}