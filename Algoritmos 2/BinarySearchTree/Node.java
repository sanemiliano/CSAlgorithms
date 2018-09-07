


public class Node {
    
    Node rightNode;
    Node leftNode;
    Integer value;
    public Node(){
        
    }
    public Node(int value)
    {
        this.value = value;
    }
    public Integer getValue()
    {
        return value;   
    }
    public void setRightNode(Node rightNode)
    {
        this.rightNode = rightNode;
    }
    public void setLeftNode(Node leftNode)
    {
        this.leftNode = leftNode;
    }
    public Node getRightNode()
    {
        return rightNode;
    }
    public Node getLeftNode()
    {
        return leftNode;
    }
    public String toString(){
        return value.toString();
    }
}
