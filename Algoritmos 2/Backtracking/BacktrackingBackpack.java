

import java.util.Arrays;

public class BacktrackingBackpack {
    public static float costs[];
    public static float weights[];
    public static float best[];
    public static float current[];
    public static float maxWeight;
    public static float maxGain;
    public static float currentGain;
    public static boolean finished;
    public static boolean valid;
    public static int size = 3;
    
    public static void main(String args[]){
        
        maxWeight = 5;
        maxGain = 0;
        currentGain=0;
        costs = new float[size];
        weights = new float[size];
        best = new float[size];
        current = new float[size];
        
        costs[0]=5;
        costs[1]=30;
        costs[2]=20;
        
        weights[0]=1;
        weights[1]=1;
        weights[2]=2;
        
        current[0]=-1;
        current[1]=-1;
        current[2]=-1;
        
        search(0);
        System.out.println(Arrays.toString(best));
        System.out.println(maxGain);  
    }
    public static void search(int place){
        valid();
        if(valid){
            finished();
            if(finished){  //if(finished())
                calculateGain();
                if(currentGain>maxGain){
                    best = current.clone();
                    maxGain = currentGain;
                }
            }
            else{
                current[place]=1;
                search(place+1);
                current[place]=0;
                search(place+1);
                current[place]=-1;
            }
        }
    }
    public static void valid(){
        float auxWeight=0f;
        for (int i = 0; i < current.length; i++) {
            if(current[i]==1){
                auxWeight += weights[i];
            }
        }
        if(auxWeight>maxWeight)
            valid = false;
        else 
            valid = true;
        
    }
    public static void finished(){
        int cont=0;
        for (int i = 0; i < current.length; i++) {
            if(current[i]==0 || current[i]==1)
                cont++;
        }
        if(cont==size)
            finished = true;
        else finished = false;
    }
    public static void calculateGain(){
        currentGain=0;
        for (int i = 0; i < current.length; i++) {
            if(current[i]==1)
                currentGain += costs[i];
        }
    }
}
