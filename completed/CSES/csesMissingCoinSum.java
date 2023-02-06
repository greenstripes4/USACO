import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] x = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x);
        long ans = 1;
        for(int i = 0; i < n && x[i] <= ans; i++) {
            ans += x[i];
        }
        out.println(ans);
        f.close();
        out.close();
    }
}