


import java.util.Arrays;

public class GreedyBackpackProblem {
    public static int gainPerKilogram[][];
    public static void main(String[] args){
        int backpackCapacity = 5;
        int products[][] = {{2,1,5},
                            {2,1,30},
                            {2,2,20}};
        gainPerKilogram = new int[products.length][2];
        for (int i = 0; i < gainPerKilogram.length; i++) {
            gainPerKilogram[i][1] = products[i][2]/products[i][1];
            gainPerKilogram[i][0] = i;
        }
        sort();
        int weight = 0;
        int place=0;
        int quantity=1;
        int gain = 0;
        int[] howMany = new int[products.length];
        while(backpackCapacity>weight && place<gainPerKilogram.length){
            if(quantity<=products[gainPerKilogram[place][0]][0]){
               if(backpackCapacity>weight+products[gainPerKilogram[place][0]][1]){
                    weight += products[gainPerKilogram[place][0]][1];
                    gain += products[gainPerKilogram[place][0]][2];
                    quantity++;
                    howMany[gainPerKilogram[place][0]]++;
               }
               else{
                   break;
               }
            }
            else{
                place++;
                quantity=1;
            }     
        }
        System.out.println(weight);
        System.out.println(gain);
        System.out.println(Arrays.toString(howMany));
        for (int i = 0; i < place+1; i++) {
            System.out.println(gainPerKilogram[i][0]);
        }
    }
    public static void sort(){
        int cont =1;
        int aux=0;
        while(cont!=0){
            cont =0;
            for (int i = 0; i < gainPerKilogram.length-1; i++) {
                if(gainPerKilogram[i][1]<gainPerKilogram[i+1][1]){
                    cont++;
                    aux = gainPerKilogram[i][1];
                    gainPerKilogram[i][1] = gainPerKilogram[i+1][1];
                    gainPerKilogram[i+1][1]=aux;
                    aux = gainPerKilogram[i][0];
                    gainPerKilogram[i][0] = gainPerKilogram[i+1][0];
                    gainPerKilogram[i+1][0]=aux;
                }
            }
        }
    }
}
