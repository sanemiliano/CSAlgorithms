

public class BacktrackingStringPermutation{
    
    public static int[] counting = {2,1,5}; //The quantity of each letter
    public static char[] toUse = {'a','b','c'}; //The letters to permute sorted in alphabetical order
    public static char[] toPrint = new char[8]; //The auxiliar array permuted letters
    public static int counter=0;
    
    public static void main(String args[]){
        permute(0);
        System.out.println(counter);
    }
    //The recursive method to permute the letters, variable place tells the place in
    //the toPrint array
    public static void permute(int place){
        //Means that there are letters still to permute
        if(place<toPrint.length){
            for (int i = 0; i < counting.length; i++) {
                if(counting[i]>0){
                    counting[i]--;
                    toPrint[place] = toUse[i];
                    permute(place+1);
                    counting[i]++;
                }
            }
        }
        //Here we know that we have finished with the current permutation
        else{
            for (int i = 0; i < toPrint.length; i++) 
                System.out.print(toPrint[i]);
            System.out.println();
            counter++;
        }
    }
}
