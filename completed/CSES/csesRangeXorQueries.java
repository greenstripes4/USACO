import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] prefixXors = new int[n+1];
        for(int i = 1; i <= n; i++) {
            prefixXors[i] = Integer.parseInt(st.nextToken());
            prefixXors[i] ^= prefixXors[i-1];
        }
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            out.println(prefixXors[a-1]^prefixXors[b]);
        }
        f.close();
        out.close();
    }
}