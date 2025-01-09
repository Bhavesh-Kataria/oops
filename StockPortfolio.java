package OOPS;

import java.util.Scanner;

class Stock{
    String shareName;
    int shareCount;
    double sharePrice;
    Stock(String shareName,int shareCount,double sharePrice){
        this.shareName = shareName;
        this.shareCount = shareCount;
        this.sharePrice = sharePrice;
    }
    double stockCalculator(){
        return this.shareCount * this.sharePrice;
    }
}
public class StockPortfolio {
    public static void stockReportGenerator(Stock[] stocks){
        double portfolioVal =0;
        for(int i=0;i< stocks.length;i++){
            double perStockPrice = stocks[i].stockCalculator();
            System.out.printf("Total Value of %s stock is %f%n",stocks[i].shareName,perStockPrice);
            portfolioVal += perStockPrice;
        }
        System.out.println("Total Portfolio Value of all stocks is "+portfolioVal);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of stocks");
        int stocksCount = sc.nextInt();
        Stock[] stocksHolder = new Stock[stocksCount];
        for(int i=0;i<stocksCount;i++){
            System.out.println("Enter share name");
            String shareName = sc.next();
            System.out.println("Enter number of shares");
            int shareCount = sc.nextInt();
            System.out.println("Enter per share price");
            double sharePrice = sc.nextDouble();
            stocksHolder[i] = new Stock(shareName,shareCount,sharePrice);
        }
        stockReportGenerator(stocksHolder);
    }
}
