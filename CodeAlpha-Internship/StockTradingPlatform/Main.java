import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        System.out.println("THIS IS STOCK TRADING");

        Scanner sc = new Scanner(System.in);

        
        ArrayList<Stock> market = new ArrayList<>();

        market.add(new Stock("AAPL", 100));
        market.add(new Stock("TSLA", 200));
        market.add(new Stock("GOOG", 300));

        Portfolio portfolio = new Portfolio(1000);

        while (true) {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\nAvailable Stocks:");

                    for (Stock stock : market) {
                        System.out.println(stock.getName()
                                + " : ₹"
                                + stock.getPrice());
                    }

                    break;

                case 2:

                    System.out.print("Enter Stock Name: ");
                    String buyName = sc.next();

                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();

                    boolean foundBuy = false;

                    for (Stock stock : market) {

                        if (stock.getName()
                                .equalsIgnoreCase(buyName)) {

                            portfolio.buyStock(
                                    stock.getName(),
                                    buyQty,
                                    stock.getPrice());

                            foundBuy = true;
                        }
                    }

                    if (!foundBuy) {
                        System.out.println("Stock Not Found!");
                    }

                    break;

                case 3:

                    System.out.print("Enter Stock Name: ");
                    String sellName = sc.next();

                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    boolean foundSell = false;

                    for (Stock stock : market) {

                        if (stock.getName()
                                .equalsIgnoreCase(sellName)) {

                            portfolio.sellStock(
                                    stock.getName(),
                                    sellQty,
                                    stock.getPrice());

                            foundSell = true;
                        }
                    }

                    if (!foundSell) {
                        System.out.println("Stock Not Found!");
                    }

                    break;

                case 4:

                    portfolio.displayPortfolio();

                    break;

                case 5:

                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}