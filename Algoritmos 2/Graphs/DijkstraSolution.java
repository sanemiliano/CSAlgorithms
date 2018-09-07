

public class DijkstraSolution {
    private int costs[];
    private String paths[];
    public DijkstraSolution(int costs[],String paths[]){
        this.costs = costs;
        this.paths = paths;
    }
    public int[] getCosts(){
        return costs;
    }
    public String[] getPaths(){
        return paths;
    }
    public String toString(){
        String toReturn = "";
        toReturn += "Costs: \n";
        for (int i = 0; i < costs.length; i++) {
            toReturn += (i+1)+".- "+costs[i]+"\n";
        }
        toReturn += "Paths: \n";
        for (int i = 0; i < paths.length; i++) {
            toReturn += (i+1)+".- "+paths[i]+"\n";
        }
        return toReturn;
    }
}
