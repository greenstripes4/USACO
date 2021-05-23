import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            int min = 0;
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if(a[i] < a[min]) {
                    min = i;
                }
            }
            int count = 0;
            StringBuilder sb = new StringBuilder();
            if(min+1 != n) {
                count++;
                sb.append((min+1) + " " + n + " " + a[n-1] + " " + a[min] + "\n");
            }
            for(int i = 0; i < n-1; i++) {
                if(i+1 != n) {
                    count++;
                    sb.append((i+1) + " " + n + " " + (i%2 == 0 ? 1000000007 : 1000000009) + " " + a[min] + "\n");
                }
            }
            out.println(count);
            out.print(sb);
        }
        f.close();
        out.close();
    }
}