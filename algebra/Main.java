package COA.algebra;

/*
* Created by Rebecca D'souza on 21/02/2018.
* */

public class Main {
    public static void main(String args[]){
        int costPrice = 576;
        int noOfBackpacks = 48;
        int X = 17;
        int sellingPriceX = 18;
        int Y = noOfBackpacks - X;
        int sellingPriceY = 25;
        int amountX = Booths.multiply(X,sellingPriceX);
        int amountY = Booths.multiply(Y,sellingPriceY);
        int netProfit = (amountX + amountY) - costPrice;
        System.out.println("Net Profit = "+netProfit);
        //NonRestoring.divide(110,13);
        //Restoring.divide(3000,25);
    }
}