
import java.util.ArrayList;
public class NodeForGraph {
    String name;
    ArrayList<NodeForGraph> adjacent = new ArrayList<>();
    ArrayList<Edge> edges = new ArrayList<>();
    
    public int size = 0;
    NodeForGraph last;
    boolean used = false;
    
    public NodeForGraph(String name){
        this.name = name;
    }
    public void setLast(NodeForGraph a){
        last = a;
    }
    public NodeForGraph getLast(){
        return last;
    }
    public void setUsed(boolean value){
        used = value;
    }
    public boolean getUsed(){
        return used;
    }
    public String getName(){
        return name;
    }
    public void addNode(NodeForGraph a){
        adjacent.add(a);
        size++;
    }
    public void addEdge(Edge a){
        edges.add(a);
    }
    public int size(){
        return size;
    }
    public NodeForGraph getNode(int i){
        return adjacent.get(i);
    }
    public Edge getEdge(int i){
        return edges.get(i);
    }
    public ArrayList<Edge> getEdges(){
        return edges;
    }
    public ArrayList<NodeForGraph> getAdjacentNodes(){
        return adjacent;
    }
    @Override
    public String toString(){
        return name;
    }
}
