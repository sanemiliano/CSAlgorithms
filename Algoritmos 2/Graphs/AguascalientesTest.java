

import java.util.Arrays;

public class AguascalientesTest {
    
    public static void main(String args[]){
        String[] cities = {"Aguascalientes","Calvillo","Palo Alto","Jesus Maria","San Francisco de los Romos","Pabellon de Arteaga","San Jose de Gracia","Tepezala","Rincon de Romos","Cosio","Asientos"};
        int[][] matrixOfAdjacent = {{0,1,1,1,1,0,0,0,0,0,0},//1
                                    {1,0,0,0,0,0,0,0,0,0,0},//2
                                    {1,0,0,0,0,0,0,0,0,0,0},//3
                                    {1,0,0,0,0,0,0,0,0,0,0},//4
                                    {1,0,0,0,0,1,0,0,0,0,0},//5
                                    {0,0,0,0,1,0,1,1,1,0,0},//6
                                    {0,0,0,0,0,1,0,0,1,0,0},//7
                                    {0,0,0,0,0,1,0,0,1,0,1},//8
                                    {0,0,0,0,0,1,1,1,0,1,0},//9
                                    {0,0,0,0,0,0,0,0,1,0,0},//10
                                    {0,0,0,0,0,0,0,1,0,0,0}};//11
                                   //1 2 3 4 5 6 7 8 9 10 11
        MyGraph aguascalientes = new MyGraph(cities,matrixOfAdjacent);
        aguascalientes.breath(9,3);
        System.out.println();
        aguascalientes.depth(9,3);
    }
}
