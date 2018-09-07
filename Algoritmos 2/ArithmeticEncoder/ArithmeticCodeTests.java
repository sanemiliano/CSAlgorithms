
import java.util.Arrays;

public class ArithmeticCodeTests
{
    public static void main(String[] args){
        
        double[] probabilities = {.40,.10,.05,.15,.30};
        char[] symbols = {'a','b','c','d','e'};
        
        ArithmeticEncoder encoder = new ArithmeticEncoder(5,symbols,probabilities);
        
        double[] range = encoder.code("ccde");
        
        System.out.println(encoder.decode(range[0], 4));
    }
}




