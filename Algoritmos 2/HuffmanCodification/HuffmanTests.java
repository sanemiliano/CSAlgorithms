
public class HuffmanTests
{
    public static void main(String[] args){
		double[] probabilities = {.45,.13,.12,.16,.09,.05};
        char[] symbols = {'a','b','c','d','e','f'};
        
        HuffmanTree myTree = new HuffmanTree(6,symbols,probabilities);
        
        System.out.println(myTree.code("abcdef"));
        System.out.println(myTree.decode(myTree.code("abcdef")));
    }
}




