


public class FloydWarshallSolution {
    private int costs[][];
    private String paths[][];
    
    public FloydWarshallSolution(int costs[][],String paths[][]){
        this.costs = costs;
        this.paths = paths;
    }

    /**
     * @return the costs
     */
    public int[][] getCosts() {
        return costs;
    }

    /**
     * @return the paths
     */
    public String[][] getPaths() {
        return paths;
    }
    @Override
    public String toString(){
        String toString = "";
        int frontier =0;
        for (int e = 1; e < costs.length ; e++) {
            frontier++;
            toString += (e+1)+".-  ";
            for (int t = 0; t < frontier; t++) {
                toString += (t+1) + ".-"+ costs[e][t] + "  ";
            }
            toString += "\n";
        }
        frontier = 0;
        for (int e = 1; e < costs.length ; e++) {
            frontier++;
            toString += (e+1) + ".-  ";
            for (int t = 0; t < frontier; t++) {
                toString += (t+1) + ".-"+ paths[e][t] + "  ";
            }
            toString += "\n";
        }
        return toString;
    }
}
