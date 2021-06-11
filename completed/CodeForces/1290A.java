import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            k = Math.min(m-1, k);
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for(int i = 0; i <= k; i++) {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j <= m-k-1; j++) {
                    int temp = Math.max(a[i+j], a[n-(k-i)-(m-k-j-1)-1]);
                    min = Math.min(min, temp);
                }
                max = Math.max(max, min);
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}