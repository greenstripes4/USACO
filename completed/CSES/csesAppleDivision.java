import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] p = new int[n];
        long total = 0;
        for(int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            total += p[i];
        }
        long min = total;
        for(int i = 0; i < 1 << (n-1); i++) {
            long sum = 0;
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) > 0) {
                    sum += p[j];
                }
            }
            min = Math.min(min, Math.abs(total-2*sum));
        }
        out.println(min);
        f.close();
        out.close();
    }
}