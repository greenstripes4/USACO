import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int count = 1;
        for(int i = 0; i < d && count < n; i++) {
            count *= k;
        }
        if(n > count) {
            out.println(-1);
        } else {
            int[][] res = new int[d][n];
            for(int i = 0; i < n; i++) {
                int temp = i;
                for(int j = 0; j < d; j++) {
                    res[j][i] = temp%k+1;
                    temp /= k;
                }
            }
            for(int[] i: res) {
                out.print(i[0]);
                for(int j = 1; j < n; j++) {
                    out.print(" " + i[j]);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}