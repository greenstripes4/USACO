import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int n = f.nextInt();
            int k = f.nextInt();
            if(n == 0 && k == 0) {
                break;
            }
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = f.nextInt();
            }
            int[][] prefixSums = new int[n+1][2];
            for(int i = 1; i <= n; i++) {
                prefixSums[i][0] = prefixSums[i-1][0]+arr[i-1];
                prefixSums[i][1] = i;
            }
            Arrays.sort(prefixSums, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0]-t1[0];
                }
            });
            while(k-- > 0) {
                int t = f.nextInt();
                int j = 0;
                int min = Integer.MAX_VALUE;
                int[] res = new int[3];
                for(int i = 0; i < n; i++) {
                    j = Math.max(j, i+1);
                    while(j <= n && prefixSums[j][0]-prefixSums[i][0] < t) {
                        j++;
                    }
                    if(j <= n && Math.abs(prefixSums[j][0]-prefixSums[i][0]-t) < min) {
                        min = Math.abs(prefixSums[j][0]-prefixSums[i][0]-t);
                        res[0] = prefixSums[j][0]-prefixSums[i][0];
                        res[1] = prefixSums[i][1];
                        res[2] = prefixSums[j][1];
                    }
                    if(j > i+1 && Math.abs(prefixSums[j-1][0]-prefixSums[i][0]-t) < min) {
                        min = Math.abs(prefixSums[j-1][0]-prefixSums[i][0]-t);
                        res[0] = prefixSums[j-1][0]-prefixSums[i][0];
                        res[1] = prefixSums[i][1];
                        res[2] = prefixSums[j-1][1];
                    }
                }
                out.println(res[0] + " " + (Math.min(res[1], res[2])+1) + " " + Math.max(res[1], res[2]));
            }
        }
        f.close();
        out.close();
    }
}