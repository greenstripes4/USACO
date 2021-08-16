import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int t = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int ans = v1+v2;
        int cur = v1;
        for(int i = 1; i < t-1; i++) {
            cur = Math.min(cur+d, v2+(t-i-1)*d);
            ans += cur;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}