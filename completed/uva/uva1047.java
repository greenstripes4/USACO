import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcase = 1;
        while(true) {
            int n = f.nextInt();
            int b = f.nextInt();
            if(n == 0 && b == 0) {
                break;
            }
            int[] served = new int[n];
            for(int i = 0; i < n; i++) {
                served[i] = f.nextInt();
            }
            int m = f.nextInt();
            HashMap<Integer, Integer> regions = new HashMap<>();
            for(int i = 0; i < m; i++) {
                int t = f.nextInt();
                int intersection = 0;
                for(int j = 0; j < t; j++) {
                    intersection |= 1 << (f.nextInt()-1);
                }
                regions.put(intersection, f.nextInt());
            }
            for(int i = 0; i < n; i++) {
                int regionSize = served[i];
                for(int j: regions.keySet()) {
                    if((j & (1 << i)) > 0) {
                        regionSize -= regions.get(j);
                    }
                }
                regions.put(1 << i, regionSize);
            }
            int built = 0;
            int max = 0;
            for(int i = 0; i < Math.pow(2, n); i++) {
                if(Integer.bitCount(i) == b) {
                    int regionSize = 0;
                    for(int j: regions.keySet()) {
                        if((j & i) > 0) {
                            regionSize += regions.get(j);
                        }
                    }
                    if(regionSize > max) {
                        built = i;
                        max = regionSize;
                    }
                }
            }
            out.println("Case Number  " + testcase);
            out.println("Number of Customers: " + max);
            out.print("Locations recommended:");
            for(int i = 0; i < 20; i++) {
                if((built & (1 << i)) > 0) {
                    out.print(" " + (i+1));
                }
            }
            out.println("\n");
            testcase++;
        }
        f.close();
        out.close();
    }
}
