import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        long[] occ = new long[21];
        for(int i = 0; i < n; i++) {
            occ[Integer.parseInt(st.nextToken())+10]++;
        }
        long ans = 0;
        for(int i = 0; i < 10; i++) {
            ans += occ[i]*occ[20-i];
        }
        ans += occ[10]*(occ[10]-1)/2;
        out.println(ans);
        f.close();
        out.close();
    }
}