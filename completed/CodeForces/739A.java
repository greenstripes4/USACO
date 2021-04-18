import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = n;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            ans = Math.min(ans, r-l+1);
        }
        out.println(ans);
        out.print(0);
        int next = 1;
        for(int i = 1; i < n; i++) {
            if(next >= ans) {
                next = 0;
            }
            out.print(" " + next++);
        }
        out.println();
        f.close();
        out.close();
    }
}