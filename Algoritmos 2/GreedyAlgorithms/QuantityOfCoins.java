


import java.util.Arrays;

public class QuantityOfCoins {
    public static void main(String[] args){
        int quantityToReturn = 87;
        int[] coins = {50,10,5,2,1};
        int[] quantityOfCoins = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            quantityOfCoins[i] = quantityToReturn/coins[i];
            quantityToReturn = quantityToReturn%coins[i];
        }
        System.out.println(Arrays.toString(quantityOfCoins));
    }
}
