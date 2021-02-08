import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] count = new int[n];
        count[0] = 1;
        StringTokenizer st = new StringTokenizer(f.readLine());
        long sum = 0;
        long ans = 0;
        for(int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
            int mod = (int) ((sum%n+n)%n);
            ans += count[mod];
            count[mod]++;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}