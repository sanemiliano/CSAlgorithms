


public class DijkstraTest {
    public static final int SIZE = 20;
    public static String[] cities = {"Arad","Zerind","Sibui","Timisoara","Oradea","Fagaras","Rimnieu Vilcea","Lugoj","Bucarest","Craiova","Pitesti","Mehadia","Giurgia","Urziceni","Dobreta","Hirsova","Vaslui","Eforie","Iasi","Neamt"};
    public static int[][] romaniaMap= {{0,75,140,118,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//1
                                        {75,0,0,0,71,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//2
                                        {140,0,0,0,151,99,80,0,0,0,0,0,0,0,0,0,0,0,0,0},//3
                                        {118,0,0,0,0,0,0,111,0,0,0,0,0,0,0,0,0,0,0,0},//4
                                        {0,71,151,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//5
                                        {0,0,99,0,0,0,0,0,211,0,0,0,0,0,0,0,0,0,0,0},//6
                                        {0,0,80,0,0,0,0,0,0,146,97,0,0,0,0,0,0,0,0,0},//7
                                        {0,0,0,111,0,0,0,0,0,0,0,70,0,0,0,0,0,0,0,0},//8
                                        {0,0,0,0,0,211,0,0,0,0,101,0,90,85,0,0,0,0,0,0},//9
                                        {0,0,0,0,0,0,146,0,0,0,138,0,0,0,120,0,0,0,0,0},//10
                                        {0,0,0,0,0,0,97,0,101,138,0,0,0,0,0,0,0,0,0,0},//11
                                        {0,0,0,0,0,0,0,70,0,0,0,0,0,0,75,0,0,0,0,0},//12
                                        {0,0,0,0,0,0,0,0,90,0,0,0,0,0,0,0,0,0,0,0},//13
                                        {0,0,0,0,0,0,0,0,85,0,0,0,0,0,0,98,142,0,0,0},//14
                                        {0,0,0,0,0,0,0,0,0,120,0,75,0,0,0,0,0,0,0,0},//15
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,98,0,0,0,86,0,0},//16
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,142,0,0,0,0,92,0},//17
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,86,0,0,0,0},//18
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,92,0,0,87},//19
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,87,0}};//20

    public static void main(String[] args){
        MyGraph romaniaGraph = new MyGraph(cities,romaniaMap);//Creating a graph.
        DijkstraSolution solution = romaniaGraph.dijkstra(1);//The argument passed is the node from where you wanna start;Starting from 1.
        System.out.println(solution);//All the info about the paths.
    }
}
