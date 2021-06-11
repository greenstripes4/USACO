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
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] p = new int[n+1];
            for(int i = 1; i <= n; i++) {
                p[i] = p[i-1]+Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for(int x = 1; x <= n; x++) {
                int temp = x/k;
                max = Math.max(max, p[n-x+temp]-p[n-x]);
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}