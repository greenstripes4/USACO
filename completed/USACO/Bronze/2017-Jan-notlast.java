import java.io.*;
import java.util.*;

public class Main{
    public static boolean isTie(int[] productionAmounts, int secondToMinInd){
        int amount = productionAmounts[0];
        boolean allSame = true;
        for(int i: productionAmounts){
            if(i != amount){
                allSame = false;
            }
        }
        if(allSame){
            return true;
        }
        for(int j = 0; j < productionAmounts.length; j++){
            if(productionAmounts[j] == productionAmounts[secondToMinInd] && j != secondToMinInd){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
        int N = Integer.parseInt(f.readLine());
        int[] production = {0,0,0,0,0,0,0};
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            String cow = st.nextToken();
            int milk = Integer.parseInt(st.nextToken());
            if(cow.equals("Bessie")){
                production[0] += milk;
            } else if(cow.equals("Elsie")) {
                production[1] += milk;
            } else if(cow.equals("Daisy")) {
                production[2] += milk;
            } else if(cow.equals("Gertie")) {
                production[3] += milk;
            } else if(cow.equals("Annabelle")) {
                production[4] += milk;
            } else if(cow.equals("Maggie")) {
                production[5] += milk;
            } else {
                production[6] += milk;
            }
        }
        int minInd = 0;
        int secondToMinInd = -1;
        for(int j = 1; j < 7; j++){
            if(production[j] < production[minInd]){
                minInd = j;
            }
        }
        for(int k = 0; k < 7; k++){
            if(production[k] != production[minInd] && (secondToMinInd == -1 || production[k] < production[secondToMinInd])){
                secondToMinInd = k;
            }
        }
        if(isTie(production,secondToMinInd)){
            out.println("Tie");
        } else {
            if (secondToMinInd == 0) {
                out.println("Bessie");
            } else if (secondToMinInd == 1) {
                out.println("Elsie");
            } else if (secondToMinInd == 2) {
                out.println("Daisy");
            } else if (secondToMinInd == 3) {
                out.println("Gertie");
            } else if (secondToMinInd == 4) {
                out.println("Annabelle");
            } else if (secondToMinInd == 5) {
                out.println("Maggie");
            } else if (secondToMinInd == 6) {
                out.println("Henrietta");
            }
        }
        f.close();
        out.close();
    }
}
