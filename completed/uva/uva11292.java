import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int n = f.nextInt();
            int m = f.nextInt();
            if(n == 0 && m == 0){
                break;
            }
            int[] dragons = new int[n];
            int[] knights = new int[m];
            for(int i = 0; i < n; i++){
                dragons[i] = f.nextInt();
            }
             for(int i = 0; i < m; i++){
                 knights[i] = f.nextInt();
             }
             Arrays.sort(dragons);
             Arrays.sort(knights);
             int dragonIndex = 0;
             int knightIndex = 0;
             int totalCost = 0;
             while(dragonIndex < n && knightIndex < m){
                 if(dragons[dragonIndex] <= knights[knightIndex]){
                     dragonIndex++;
                     totalCost += knights[knightIndex];
                 }
                 knightIndex++;
             }
             out.println(dragonIndex == n ? totalCost : "Loowater is doomed!");
        }
        f.close();
        out.close();
    }
}
