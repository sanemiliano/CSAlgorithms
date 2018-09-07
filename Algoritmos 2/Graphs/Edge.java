
public class Edge {
    NodeForGraph one;
    NodeForGraph two;
    int index1;
    int index2;
    int weight;
    public Edge(NodeForGraph one, NodeForGraph two,int weight){
        this.one = one;
        this.two = two;
        this.weight = weight;
    }
    public Edge(int i,int j,int weight){
        index1 = i;
        index2 = j;
        this.weight = weight;
    }
    public int getIndex1(){
        return index1;
    }
    public int getIndex2(){
        return index2;
    }
    public int getWeight(){
        return weight;
    }
    public NodeForGraph getNode1(){
        return one;
    }
    public NodeForGraph getNode2(){
        return two;
    }
    @Override
    public String toString(){
        return ""+(index1+1)+" "+(index2+1)+" "+weight;
    }
}
