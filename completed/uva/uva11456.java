import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = f.nextInt();
        for(int t = 0; t < testcases; t++) {
            int n = f.nextInt();
            int[] carArrivalOrder = new int[n];
            for(int i = 0; i < n; i++) {
                carArrivalOrder[i] = f.nextInt();
            }
            int[] LIS = new int[n];
            int[] LDS = new int[n];
            for(int i = n-1; i >= 0; i--) {
                LIS[i] = 1;
                LDS[i] = 1;
                for(int j = i+1; j < n; j++) {
                    if(carArrivalOrder[i] < carArrivalOrder[j]) {
                        LIS[i] = Math.max(LIS[i],LIS[j]+1);
                    } else {
                        LDS[i] = Math.max(LDS[i],LDS[j]+1);
                    }
                }
            }
            int max = 0;
            for(int i = 0; i < n; i++) {
                max = Math.max(max,LIS[i]+LDS[i]-1);
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
