

public class HuffmanNode {
    private char symbol;
    private double probability;
    private String code="";
    private HuffmanNode rightNode;
    private HuffmanNode leftNode;
    
    
    public HuffmanNode(char symbol, double probability){
        this.symbol = symbol;
        this.probability = probability;
    }
    public HuffmanNode(double probability,HuffmanNode leftNode,HuffmanNode rightNode){
        this.probability = probability;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }
    @Override
    public String toString(){

        return "Symbol: "+symbol+"\nProbability: "+probability+ "\nCode: "+code+"\n";
    }
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HuffmanNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(HuffmanNode rightNode) {
        this.rightNode = rightNode;
    }

    public HuffmanNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(HuffmanNode leftNode) {
        this.leftNode = leftNode;
    }
    
    
}
