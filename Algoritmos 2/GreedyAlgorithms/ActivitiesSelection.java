


public class ActivitiesSelection {
    public static int[] hours = new int[25];
    public static void main(String[] args){
        int activities[][] = {{9,11,1},{13,15,2},{17,19,3},{12,14,4},{16,18,5}};//Inicio, Fin, Prioridad.
        for(int i = 0; i < activities.length; i++) {
            for (int j = activities[i][0]; j < activities[i][1]; j++) {
                if(hours[j]==0){
                    hours[j] = i+1;
                    
                }
            }
        }
        for (int i = 0; i < 25; i++) {
            System.out.println("Hour "+i+ " will have activity with priority "+hours[i]);
        }
    }
}
