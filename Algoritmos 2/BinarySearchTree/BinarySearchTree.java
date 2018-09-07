import java.util.ArrayList;


public class BinarySearchTree {

    private Node root;
    private Node last;
    private int rightDepth;
    private int leftDepth;
    private int depth;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setLast(Node last){
        this.last = last;
    }

    public Node getLast(){
        return last;
    }

    public void add(Node a){
        addNode(a,root);
    }

    private void addNode(Node a, Node aux) {
        if(a.getValue()>=aux.getValue()){                                  
            if(aux.getRightNode()==null){
                aux.setRightNode(a);
                rightDepth++;
            }
            else{
                aux = aux.getRightNode();
                addNode(a,aux);
            }
        }
        else{
            if(aux.getLeftNode()==null){
                aux.setLeftNode(a);
                leftDepth++;
            }
            else{
                aux = aux.getLeftNode();
                addNode(a,aux);
            }
        }
    }

    public void preorden(Node a){
        System.out.println(a.getValue());
        if(a.getLeftNode()!=null)
            preorden(a.getLeftNode());
        if(a.getRightNode()!=null)
            preorden(a.getRightNode());
    }

    public void orden(Node a){
        if(a.getLeftNode()!=null)
            orden(a.getLeftNode());
        System.out.println(a.getValue());
        if(a.getRightNode()!=null)
            orden(a.getRightNode());
        
    }

    public void posorden(Node a){
        if(a.getLeftNode()!=null)
            posorden(a.getLeftNode());
        if(a.getRightNode()!=null)
            posorden(a.getRightNode());
        System.out.println(a.getValue());
    }

    public void breath(Node a){
        ArrayList<Node> toPrint = new ArrayList<>();
        Node aux = new Node();
        toPrint.add(a);
        int leaves = 0;
        while(!toPrint.isEmpty())
        {
            aux = toPrint.remove(0);
            if(aux.getLeftNode()!=null)
                toPrint.add(aux.getLeftNode());
            if(aux.getRightNode()!=null)
                toPrint.add(aux.getRightNode());
            if(aux.getRightNode() == null && aux.getLeftNode()==null)
                leaves++;
            System.out.println(aux.getValue());
        }
    }

    public Node search(Node searched, Node aux) {
        if(searched.getValue()==aux.getValue())
            return aux;
        else
        {
            if(aux.getValue()>searched.getValue())
            {
                if(aux.getLeftNode()!=null)
                    return search(searched,aux.getLeftNode());

                else
                    return null;
            }
            else
            {
                if(aux.getRightNode()!=null)
                    return search(searched,aux.getRightNode());
                else 
                    return null;
            }
        }
    }

    public Node getFather(Node a,Node aux){
        System.out.println("Aux "+ aux.getValue());
        if(a.getValue()==aux.getValue())
            return null;
        else{
            if(aux.getRightNode()!=null && aux.getRightNode().getValue()==a.getValue())
                        return aux;
            else if(aux.getLeftNode()!=null && aux.getLeftNode().getValue()==a.getValue())//
                        return aux; 
            else{
                   Node b = new Node();
                   Node c = new Node();
                   if(aux.getRightNode()!=null)
                       b = getFather(a,aux.getRightNode());//
                   if(b!=null && b.getValue()!=null)
                       return b;
                   if(aux.getLeftNode()!=null){
                       c = getFather(a,aux.getLeftNode());
                       if(c!=null && c.getValue()!=null)
                            return c;
                        else return null;
                   }
                   else 
                       return null;
            }
        }
    }
    
    public boolean delete(Node a) {
        Node aux = search(a,root);
        if(aux!=null){
            deleteNode(aux);
            return true;
        }
        else{
            System.out.println("The tree does not contain this node");
            return false;
        }
    }
    private void deleteNode(Node a){
        Node father = getFather(a,this.root);
        boolean right = false;
        if(father!=null){

            if(father.getRightNode()!=null && father.getRightNode().getValue()==a.getValue())
                right = true;

            if(a.getRightNode()==null && a.getLeftNode()==null){
                if(right)
                    father.setRightNode(null);
                else
                    father.setLeftNode(null);
            }
            if(a.getRightNode()!=null && a.getLeftNode()==null){
                if(right)
                    father.setRightNode(a.getRightNode());
                else
                    father.setLeftNode(a.getRightNode());
            }
            if(a.getLeftNode()!=null && a.getRightNode()==null){
                if(right)
                    father.setRightNode(a.getLeftNode());
                else
                    father.setLeftNode(a.getLeftNode());
            }
            if(a.getLeftNode()!=null && a.getRightNode()!=null){
                Node toSwitch = a.getRightNode();
                while(toSwitch.getLeftNode()!=null){
                    toSwitch = toSwitch.getLeftNode();
                } 
                deleteNode(toSwitch);
                if(right)
                    father.setRightNode(toSwitch);
                else
                    father.setLeftNode(toSwitch);
                toSwitch.setRightNode(a.getRightNode());
                toSwitch.setLeftNode(a.getLeftNode());
            }
        }
        else{
            if(a.getValue()==root.getValue()){
                if(a.getRightNode()==null && a.getLeftNode()==null)
                    this.root = null;
                if(a.getRightNode()!=null && a.getLeftNode()==null)
                    this.root = a.getRightNode();
                if(a.getLeftNode()!=null && a.getRightNode()==null)
                    this.root = a.getLeftNode();
                if(a.getRightNode()!=null && a.getLeftNode()!= null){
                    Node toSwitch = a.getRightNode();
                    while(toSwitch.getLeftNode()!=null){
                        toSwitch = toSwitch.getLeftNode();
                    } 
                    deleteNode(toSwitch);
                    toSwitch.setLeftNode(root.getLeftNode());
                    if(root.getRightNode()!=null)
                        toSwitch.setRightNode(root.getRightNode());
                    root = toSwitch;
                }
                else System.out.println("The node does not belong to this tree");
            }
        }
    }
}
