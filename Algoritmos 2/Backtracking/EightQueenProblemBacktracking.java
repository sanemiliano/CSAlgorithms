

import java.util.Arrays;

public class EightQueenProblemBacktracking {
    public static int size = 8; //this variable maneges the size of your board
    public static int[] solution = new int[size]; //Our solution
    public static boolean diagonal1[] = new boolean[(size*2)-1]; //diagonal to this side /
    public static boolean diagonal2[] = new boolean[(size*2)-1];//diagonal to this side \
    public static boolean rows[] = new boolean[size]; //Keep record of the rows
    public static int cont = 0; // counter of solutions
    
    public static void main(String args[]){
        
        search(0);
        System.out.println("Number of solutions: "+cont);
    }
    //Generates the whole tree, with all possible solutions
    private static void search(int column) {
        if(column<size){
            for (int i = 0; i < size; i++) {
                int d1 = i+column;
                int d2 = i-column;
                if(!rows[i]){
                    if(d2<0)
                        d2 = (size-1) + Math.abs(d2);
                    if(!diagonal1[d1] && !diagonal2[d2]){// in case it's a valid position
                        solution[column] = i;
                        rows[i] = true;
                        diagonal1[d1] = true;
                        diagonal2[d2] = true;
                        search(column+1); //Goes to the recursion
                        rows[i] = false; //Comes back and rearrenges the varibles
                        diagonal1[d1]=false;
                        diagonal2[d2]=false;
                    }
                }
            }
        }
        //Means we have found a solution
        else{
            //Prints the current solution generated
            for (int i = 0; i < size; i++) {
                System.out.println(Arrays.toString(solution));
            }
            //Its a counter for the number of solutions
            cont++;
        }
    }
}
