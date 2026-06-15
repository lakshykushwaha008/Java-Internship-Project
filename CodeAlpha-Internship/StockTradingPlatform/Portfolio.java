import java.util.HashMap;

public class Portfolio {

    private double balance;
    private HashMap<String, Integer> stocks;

    public Portfolio(double balance) {
        this.balance = balance;
        stocks = new HashMap<>();
    }

    public double getBalance() {
        return balance;
    }

    public void buyStock(String stockName, int quantity, double price) {

        double cost = quantity * price;

        if (cost > balance) {
            System.out.println("Insufficient Balance!");
            return;
        }

        balance -= cost;

        stocks.put(stockName,
                stocks.getOrDefault(stockName, 0) + quantity);

        System.out.println("Stock Purchased Successfully!");
    }

    public void sellStock(String stockName, int quantity, double price) {

        if (!stocks.containsKey(stockName)
                || stocks.get(stockName) < quantity) {

            System.out.println("Not Enough Shares To Sell!");
            return;
        }

        stocks.put(stockName,
                stocks.get(stockName) - quantity);

        balance += quantity * price;

        System.out.println("Stock Sold Successfully!");
    }

    public void displayPortfolio() {

        System.out.println("\n===== PORTFOLIO =====");

        if (stocks.isEmpty()) {
            System.out.println("No Stocks Purchased Yet.");
        } else {

            for (String stock : stocks.keySet()) {
                System.out.println(stock + " : "
                        + stocks.get(stock) + " shares");
            }
        }

        System.out.println("Balance: ₹" + balance);
    }
}