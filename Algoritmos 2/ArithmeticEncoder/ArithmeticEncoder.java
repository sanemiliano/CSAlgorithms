

public class ArithmeticEncoder {
    
    char symbols[];
    double limits [][];
    double probabilities[];
    public ArithmeticEncoder(int size, char symbols[], double probabilities[]){
        this.symbols = symbols;
        this.probabilities = probabilities;
        limits = new double[size][2];
        limits[0][0]=0;
        limits[0][1] = probabilities[0];
        for (int i = 1; i < size; i++) {
            limits[i][0]= limits[i-1][1];
            limits[i][1]= limits[i][0] + probabilities[i];
        }
    }
    public double[] code(String toCode){
        double left=0;
        double right=1;
        double amplitude=1;
        double[] coded = new double[2];
        int index;
        for (int i = 0; i < toCode.length(); i++){
            index = getIndex(toCode.charAt(i));
            right = left+ limits[index][1]*amplitude;
            left = left+ limits[index][0]*amplitude;
            amplitude = right-left;
        }
        coded[0]=left;
        coded[1]=right;
        return coded;
    }
    public String decode(double code,int levels){
        String decoded ="";
        int index;
        for (int i = 0; i < levels; i++) {
            index = getRange(code);
            code = (code-limits[index][0])/(limits[index][1]-limits[index][0]);
            
            if(index != -1)
                decoded += symbols[index];
            else System.out.println("Error en decodificacion");
        }
        return decoded;
    }
    public int getRange(double a){
        for (int i = 0; i < symbols.length; i++) {
            if(a>=limits[i][0] && a<limits[i][1])return i;
        }
        return -1;
    }
    public int getIndex(char a){
        for (int i = 0; i < symbols.length; i++) {
            if(symbols[i]==a)return i;
        }
        return -1;
    }
    public void printSymbols(){
        for (int i = 0; i < symbols.length; i++) {
            System.out.println(symbols[i]+": \n"+"Probability: "+probabilities[i]+"\n"+"limits: "+limits[i][0]+" "+limits[i][1]);
        }
    }
}
