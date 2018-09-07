

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    private HuffmanNode root;
    private Comparator<HuffmanNode> comparator = new HuffmanNodeComparator();
    private PriorityQueue<HuffmanNode> myQueue = new PriorityQueue<>(comparator);
    private HuffmanNode aux1;
    private HuffmanNode aux2;
    private Map codes = new HashMap();
    
    //A constructor that adds the elements to the Priority Queue and the calls createTree and setCodes
    public HuffmanTree(int size, char[] symbols, double[] probabilities){
        for (int i = 0; i < size; i++) {
            myQueue.add(new HuffmanNode(symbols[i],probabilities[i]));
        }
        createTree();//Gives the probabilities to each node.
        setCodes();//Gives the codes to nodes.
        getLeafCodes();//Once you have every single node with its code you transfer the leaf codes to a Map
    }
    //Creates the tree with the probabilities and then it assigns the codes.
    private void createTree() {
        double probability;
        
        while(myQueue.size()>2){
            aux1 = myQueue.poll();
            aux2 = myQueue.poll();
            probability = aux1.getProbability()+aux2.getProbability();
            myQueue.add(new HuffmanNode(probability,aux1,aux2));
        }
        aux1= myQueue.poll();
        aux2= myQueue.poll();
        probability = aux1.getProbability()+aux2.getProbability();
        root = new HuffmanNode(probability,aux1,aux2);
        
    }
    //Sets the code of each node, no if matter if its internal or a leaf in.
    public void setCodes(){
        ArrayList<HuffmanNode> list = new ArrayList<>();
        list.add(root);
        while(!list.isEmpty()){
            if(list.get(0).getLeftNode()!=null){
                list.get(0).getLeftNode().setCode(list.get(0).getCode()+"0");
                list.add(list.get(0).getLeftNode());
            }
            if(list.get(0).getRightNode()!=null){
                list.get(0).getRightNode().setCode(list.get(0).getCode()+"1");
                list.add(list.get(0).getRightNode());
            }
            list.remove(0);
        }
    }
    //Creates the map with the codes for the leafs
    public void getLeafCodes(){
        ArrayList<HuffmanNode> list = new ArrayList();
        list.add(root);
        while(!list.isEmpty()){
            if(list.get(0).getLeftNode()!=null || list.get(0).getRightNode()!=null){
                if(list.get(0).getLeftNode()!=null)
                    list.add(list.get(0).getLeftNode());
                if(list.get(0).getRightNode()!=null)
                    list.add(list.get(0).getRightNode());
            }
            else
                codes.put(list.get(0).getSymbol(), list.get(0).getCode());
            list.remove(0);
        }   
    }
    //Receives a string and the returns it coded.
    public String code(String toCode){
        int length = toCode.length();
        String coded="";
        for (int i = 0; i < length; i++) {
            coded += codes.get(toCode.charAt(i));
        }
        return coded;
    }
    public String decode(String toDecode){
        int length = toDecode.length();
        String decoded="";
        aux1=root;
        for (int i = 0; i < length; i++) {
            if(aux1.getLeftNode()==null && aux1.getRightNode()==null){
                decoded += aux1.getSymbol();
                aux1 = root;
                i--;
            }
            else if(toDecode.charAt(i)=='0'){
                aux1 = aux1.getLeftNode();
            }
            else
                aux1 = aux1.getRightNode();
            
        }
        decoded += aux1.getSymbol();
        return decoded;
    }
    //Prints the whole tree in a Depth First Search DFS
    public void printTree(){
        ArrayList<HuffmanNode> list = new ArrayList();
        list.add(root);
        while(!list.isEmpty()){
            System.out.println(list.get(0));
            if(list.get(0).getLeftNode()!=null)
                list.add(list.get(0).getLeftNode());
            if(list.get(0).getRightNode()!=null)
                list.add(list.get(0).getRightNode());
            list.remove(0);
        }
    }
    //Prints the leafs from left to right.
    public void printLeafs(){
        ArrayList<HuffmanNode> list = new ArrayList();
        list.add(root);
        while(!list.isEmpty()){
            if(list.get(0).getLeftNode()!=null || list.get(0).getRightNode()!=null){
                if(list.get(0).getLeftNode()!=null)
                    list.add(list.get(0).getLeftNode());
                if(list.get(0).getRightNode()!=null)
                    list.add(list.get(0).getRightNode());
            }
            else
                System.out.println(list.get(0));
            list.remove(0);
        }
    }
    public void printMap(){
        System.out.println(codes);
    }
    
    public HuffmanNode getRoot() {
        return root;
    }

    public void setRoot(HuffmanNode root) {
        this.root = root;
    }
        
}
//Creating the comparator class so we can use the PriorityQueue, it's very necessary.
class HuffmanNodeComparator implements Comparator<HuffmanNode>{

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
       if(o1.getProbability()>o2.getProbability())
           return 1;
       else if(o1.getProbability()<o2.getProbability())
           return -1;
       else return 0;
    }
    
}