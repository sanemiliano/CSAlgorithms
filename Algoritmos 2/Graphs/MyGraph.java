

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.PriorityQueue;

public class MyGraph {
    ArrayList<NodeForGraph> cities = new ArrayList<>();
    ArrayList<NodeForGraph> aux = new ArrayList<>();   
    int size;
    int[][] matrixOfAdjacency;
    String[] names;
    public MyGraph(){
        
    }
    public MyGraph(String[] names){
        this.names = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            this.names[i] = names[i];
            cities.add(new NodeForGraph(names[i]));
        }
        size = names.length;
    }
    public MyGraph(String[] cities, int[][] matrixOfAdjacency){
        this.matrixOfAdjacency = matrixOfAdjacency;
        this.names = cities;
        for(int i = 0; i < cities.length; i++) {
            this.cities.add(new NodeForGraph(cities[i]));
        }
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities.length; j++) {
                if(matrixOfAdjacency[i][j]>=1)
                    this.cities.get(i).addNode(this.cities.get(j));
                    this.cities.get(i).addEdge(new Edge(this.cities.get(i),this.cities.get(j),matrixOfAdjacency[i][j]));
            }
        }
        size = cities.length;
    }
    public void addNode(NodeForGraph a){
        cities.add(a);
    }
    
    public int size(){
        return size;
    }
    public void breath(int origin, int destiny){
        aux.add(cities.get(origin));
        cities.get(origin).setUsed(true);
        String destinyString = cities.get(destiny).getName();
        
        boolean done = false;
        int size = 0;
        while(aux.size()>0){
            if(!done){
                size = aux.get(0).size();
                for (int i = 0; i <size; i++) {
                    if(!aux.get(0).getNode(i).getUsed()){
                        aux.add(aux.get(0).getNode(i));
                        aux.get(0).getNode(i).setUsed(true);
                        aux.get(aux.size()-1).setLast(aux.get(0));
                        if(aux.get(aux.size()-1).getName().equals(destinyString)){//I've arrived the desired city.
                            done = true;
                            break;
                        }
                    }
                }
                aux.remove(0);
            }
            else{
                print(aux.get(aux.size()-1));
                break;
            }
        }
        setFalse();
    }
    public void depth(int origin, int destiny){
        Stack<NodeForGraph> myStack = new Stack<>();
        myStack.add(cities.get(origin));
        myStack.peek().setUsed(true);
        NodeForGraph aux;
        while(!myStack.isEmpty()){
            aux = myStack.pop();
            
            if(aux.getName().equals(cities.get(destiny).getName())){
                print(aux);
                break;
            }
            else{
                for (int i = 0; i < aux.size(); i++) {
                    if(!aux.getNode(i).getUsed()){
                        aux.getNode(i).setLast(aux);
                        aux.getNode(i).setUsed(true);
                        myStack.add(aux.getNode(i));   
                    }
                }
            }
        }
        setFalse();
    }
    public int[] primMSP(){
        int[] costs = new int[size];
        for (int i = 0; i < size; i++) {
            costs[i] = Integer.MAX_VALUE;
        }
        costs[0]=0;
        int[] fathers = new int[size];
        for (int i = 0; i < size; i++) {
            fathers[i] = i+1;
        }
        boolean[] used = new boolean[size];
        
        for (int i = 0; i < size; i++) {
            int current = getMin(costs,used);
            //System.out.println(current);
            used[current] = true;
            for (int j = 0; j < size; j++) {
                if(matrixOfAdjacency[current][j]>0 && !used[j] && matrixOfAdjacency[current][j]<costs[j]){
                    costs[j] = matrixOfAdjacency[current][j];
                    fathers[j] = current;
                    //System.out.println(costs[j]);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += costs[i];
        }
        return fathers;
    }
    public MyGraph kruskalMSP(){
        Comparator<Edge> comparator = new EdgeComparator();
        PriorityQueue<Edge> edges = new PriorityQueue<>(comparator);
        int[] unionFind = new int[matrixOfAdjacency.length];
        MyGraph mst = new MyGraph(names);
        for (int i = 0; i < unionFind.length; i++) {
            unionFind[i]=i;
        }
        for (int i = 0; i < matrixOfAdjacency.length; i++) {
            for (int j = 0; j < matrixOfAdjacency.length; j++) {
                if(matrixOfAdjacency[i][j]!=0){
//                    NodeForGraph a = new NodeForGraph(names[i]);
//                    NodeForGraph b = new NodeForGraph(names[j]);
//                    a.addNode(b);
//                    b.addNode(a);
                    edges.add(new Edge(i,j,matrixOfAdjacency[i][j]));
                }
            }
        }
        Edge aux;
        boolean det=true;
        while(det){
            aux = edges.poll();

            if(search(aux.getIndex1(),unionFind)!=search(aux.getIndex2(),unionFind)){
                mst.getCity(aux.getIndex1()).addNode(mst.getCity(aux.getIndex2()));
                mst.getCity(aux.getIndex2()).addNode(mst.getCity(aux.getIndex1()));
                mst.getCity(aux.getIndex1()).addEdge(new Edge(aux.getIndex1(),aux.getIndex2(),aux.getWeight()));
                mst.getCity(aux.getIndex2()).addEdge(new Edge(aux.getIndex1(),aux.getIndex2(),aux.getWeight()));
                union(aux.getIndex1(),aux.getIndex2(),unionFind);
            }
            int checker=0;
            det = false;
            for (int i = 0; i < unionFind.length-1; i++) {
                if(!belongs(i,i+1,unionFind)){
                    det = true;
                    break;
                } 
            }
        }
        return mst;
    }
    public DijkstraSolution dijkstra(int origin, int matrixOfAjacency[][]){

        int costs[] = new int[size];
        boolean used[] = new boolean[size];
        String paths[] = new String[size];
        int current;
        int auxDistance;

        for (int i = 0; i < size; i++) {
            costs[i] = Integer.MAX_VALUE;
        }

        costs[origin-1]=0;
        paths[origin-1] = names[origin-1];

        for (int i = 0; i < size; i++) {
            current = getMin(costs,used);
            used[current]=true;
            for (int e=0; e<size; e++) {
                if(matrixOfAdjacency[current][e]!=0){
                    auxDistance = costs[current]+matrixOfAdjacency[current][e];
                    if(auxDistance<costs[e]){
                        costs[e]=auxDistance;
                        paths[e]=paths[current]+","+names[e];
                    }
                }
            }
        }
        DijkstraSolution solution = new DijkstraSolution(costs,paths);
        return solution;
    }
    public int[] dijkstra(int origin, int matrixOfAdjacency[][],int xsz){
        int mysize = matrixOfAdjacency.length;
        int costs[] = new int[mysize];
        boolean used[] = new boolean[mysize];
        String paths[] = new String[mysize];
        int current;
        int auxDistance;

        for (int i = 0; i < mysize; i++) {
            costs[i] = Integer.MAX_VALUE;
        }

        costs[origin-1]=0;
        paths[origin-1] = names[origin-1];
        
        for (int i = 0; i < mysize; i++) {
            current = getMin(costs,used);
            used[current]=true;
            
            for (int e=0; e<mysize; e++) {
                if(matrixOfAdjacency[current][e]!=Integer.MAX_VALUE){
                    auxDistance = costs[current]+matrixOfAdjacency[current][e];
                    if(auxDistance<costs[e]){
                        costs[e]=auxDistance;
                        paths[e]=paths[current]+","+names[e];
                    }
                }
            }
        }
        
        return costs;
    }
        public int[] dijkstra(int origin, ArrayList<ArrayList<Integer>> adjacencyList,int a){

        int costs[] = new int[size];
        boolean used[] = new boolean[size];
        String paths[] = new String[size];
        int current;
        int auxDistance;

        for (int i = 0; i < size; i++) {
            costs[i] = Integer.MAX_VALUE;
        }

        costs[origin-1]=0;
        paths[origin-1] = names[origin-1];
        ArrayList<Integer> aux;
        for (int i = 0; i < size; i++) {
            current = getMin(costs,used);
            used[current]=true;
            aux = adjacencyList.get(i);
            for (int e=0; e<aux.size(); e++) {
                    auxDistance = costs[current]+Integer.valueOf(aux.get(e));
                    if(auxDistance<costs[e]){
                        costs[e]=auxDistance;
                        paths[e]=paths[current]+","+names[e];
                    }
            }
        }
        DijkstraSolution solution = new DijkstraSolution(costs,paths);
        return costs;
    }
    public FloydWarshallSolution floydWarshall(){
        FloydWarshallSolution solution;
        int costs[][] = new int[size][size];
        String paths[][] = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int e = 0; e < size; e++) {
                costs[i][e] = matrixOfAdjacency[i][e];
                paths[i][e] = names[i]+","+names[e];
            }
        }
        int frontier=0;
        int aux =0;
        String separated[];
        String auxString;
        for (int i = 0; i < size; i++) {
            frontier = 0;
            for (int e = 1; e < size; e++) {
                frontier++;
                if(e!=i)
                    for (int t = 0; t < frontier; t++) {
                        if(t!=i){
                            if(costs[e][i]>0 && costs[i][t]>0)
                                aux = costs[e][i] + costs[i][t];
                            else 
                                aux = 0;
                            if((aux<costs[e][t]  || costs[e][t]==0) && aux>0){
                                costs[e][t] = aux;
                                costs[t][e] = aux;
                                auxString = paths[e][i];
                                auxString += ",";
                                separated = paths[i][t].split(",");
                                for (int j = 1; j < separated.length; j++) {
                                    if(j==separated.length-1)
                                        auxString += separated[j];
                                    else
                                        auxString += separated[j]+",";
                                }
                                paths[e][t] = auxString;
                                paths[t][e] = auxString;
                            }
                        }
                    }
            }
        }
        solution = new FloydWarshallSolution(costs,paths);
        return solution;
    }
    //Use adjacency list instead of matrix of adjacency
    public int[] BellmanFordAlgorithm(int origin){
        int[] solution = new int[size];
        for (int i = 0; i < size; i++) {
            solution[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(matrixOfAdjacency[i][j]==0)
                    matrixOfAdjacency[i][j] = Integer.MAX_VALUE;
            }
        }
        solution[origin] =  0;
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if(matrixOfAdjacency[j][k]!=Integer.MAX_VALUE){
                        if(solution[j]!=Integer.MAX_VALUE){
                            if(solution[j]+matrixOfAdjacency[j][k]<solution[k]){
                                solution[k]=solution[j]+matrixOfAdjacency[j][k];
                            }
                        }
                    }
                }
            }
        }
        return solution;
    }
    private int[] BellmanFordAlgorithm(int origin, int matrixOfAdjacency[][], int size){
        int[] solution = new int[size];
        for (int i = 0; i < size; i++) {
            solution[i] = Integer.MAX_VALUE;
        }

        solution[origin] =  0;
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if(matrixOfAdjacency[j][k]!=Integer.MAX_VALUE){
                        if(solution[j]!=Integer.MAX_VALUE){
                            if(solution[j]+matrixOfAdjacency[j][k]<solution[k]){
                                solution[k]=solution[j]+matrixOfAdjacency[j][k];
                            }
                        }
                    }
                }
            }
        }
        return solution;
    }
    public int[][] JohnsonAlgorithm(int matrixOfAdjacency[][]){
        int size = matrixOfAdjacency.length;
        int[][] auxMatrix = new int[size+1][size+1];
        for (int f = 0; f < size; f++) {
            for (int i = 0; i < size; i++) {
                auxMatrix[f][i] = matrixOfAdjacency[f][i];
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(auxMatrix[i][j]==0)
                    auxMatrix[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < size; i++) {
            auxMatrix[size][i]=0;
            auxMatrix[i][size]=Integer.MAX_VALUE;
        }
        int[] shortestPaths = BellmanFordAlgorithm(size,auxMatrix,size+1);
        boolean[][] ocuppied = ocuppied(matrixOfAdjacency);
        int reweighted[][] = reweight(matrixOfAdjacency,shortestPaths);
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(!ocuppied[i][j])
                    reweighted[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] solution = new int[size][size];
        for (int i = 0; i < size; i++) {
            solution[i] = dijkstra(i+1,reweighted,0);
        }
        return solution;
    }
    private int getMin(int costs[], boolean used[]){
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < size; i++) {
            if(costs[i]<min && !used[i]){
                //System.out.println(i);
                minIndex = i;
                min = costs[i];
            }
        }
        return minIndex;
    }
    public void print(NodeForGraph toPrint){
        System.out.println(toPrint);
        if(toPrint.getLast()!=null)
            print(toPrint.getLast());
    }

    private void setFalse() {
        for (int i = 0; i < cities.size(); i++) {
            cities.get(i).setUsed(false);
        }
    }
    public void addCity(NodeForGraph a){
        cities.add(a);
    }
    public NodeForGraph getCity(int i){
        return cities.get(i);
    }
    public ArrayList<NodeForGraph> getCities(){
        return cities;
    }
    public int search(int v, int[] un){
        if(un[v]==v)
            return v;
        else
            return search(un[v],un);
    }
    public boolean belongs(int a,int b,int[] un){
        if(search(a,un)==search(b,un))
            return true;
        else
            return false;
    }
    public void union(int a,int b,int[] un){
        int ra = search(a,un);
        int rb = search(b,un);
        un[ra] = rb;
    }
    private boolean[][] ocuppied(int [][] matrixOfAdjacency){
        boolean ocuppied[][] = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(matrixOfAdjacency[i][j]!=0)
                    ocuppied[i][j] = true;
            }
        }
        return ocuppied;
    }
    private int[][] reweight(int[][] matrixOfAdjacency, int[] shortestPaths) {
        int reweighted[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                reweighted[i][j] = matrixOfAdjacency[i][j];
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(reweighted[i][j]!=0){
                    reweighted[i][j] = matrixOfAdjacency[i][j]+shortestPaths[i]-shortestPaths[j];
                }
            }
        }

        return reweighted;
    }
}
class EdgeComparator implements Comparator<Edge>{
    @Override
    public int compare(Edge i1, Edge i2) {
       if(i1.getWeight()>i2.getWeight())
           return 1;
       else if(i1.getWeight()<i2.getWeight())
           return -1;
       else return 0;
    } 
}
