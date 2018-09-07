


import java.util.Arrays;

public class JohnsonTest {
    public static String[] names = {"A","B","C","X","Y","Z"};
    public static int[][] testGraph =   {{0,-2,0,0,0,0},
                                        {0,0,-1,0,0,0},
                                        {4,0,0,2,-3,0},
                                        {0,0,0,0,0,0},
                                        {0,0,0,0,0,0},
                                        {0,0,0,1,-4,0}};
    public static void main(String args[]){
        MyGraph myTestGraph = new MyGraph(names,testGraph);
        //System.out.println(Arrays.toString(myTestGraph.BellmanFordAlgorithm(0)));
        int solution[][] = myTestGraph.JohnsonAlgorithm(testGraph);
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                System.out.print(solution[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
