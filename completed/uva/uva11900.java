import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        for(int i = 0; i < N; i++){
            int n = f.nextInt();
            int P = f.nextInt();
            int Q = f.nextInt();
            int[] eggs = new int[n];
            for(int j = 0; j < n; j++){
                eggs[j] = f.nextInt();
            }
            int totalNumOfEggs = 0;
            int totalWeight = 0;
            int ind = 0;
            while(totalNumOfEggs < P && totalWeight < Q && ind < n){
                totalNumOfEggs++;
                totalWeight += eggs[ind];
                ind++;
            }
            if(totalNumOfEggs > P || totalWeight > Q){
                totalNumOfEggs--;
            }
            out.println("Case " + (i+1) + ": " + totalNumOfEggs);
        }
        f.close();
        out.close();
    }
}
