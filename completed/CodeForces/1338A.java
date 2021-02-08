import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
                b[j] = a[j];
            }
            for(int j = 1; j < n; j++) {
                b[j] = Math.max(b[j], b[j-1]);
            }
            int max = 0;
            for(int j = 0; j < n; j++) {
                int diff = b[j]-a[j];
                for(int k = 30; k >= 0; k--) {
                    if((diff&(1 << k)) > 0) {
                        max = Math.max(max, k+1);
                        break;
                    }
                }
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
