import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] c = new int[n];
        long sum = 0;
        for(int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            sum += c[i];
        }
        st = new StringTokenizer(f.readLine());
        boolean[] seen = new boolean[n];
        long ans = 0;
        long temp = 0;
        for(int i = 0; i < k; i++) {
            int id = Integer.parseInt(st.nextToken())-1;
            ans += sum*c[id];
            temp += c[id];
            ans -= temp*c[id];
            seen[id] = true;
        }
        for(int i = 0; i < n-1; i++) {
            if(!seen[i] && !seen[i+1]) {
                ans += c[i]*c[i+1];
            }
        }
        if(!seen[0] && !seen[n-1]) {
            ans += c[0]*c[n-1];
        }
        out.println(ans);
        f.close();
        out.close();
    }
}