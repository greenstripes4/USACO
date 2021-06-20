import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        long[] c = new long[n];
        long ans = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            c[i] = a-b;
            ans += b*n-a;
        }
        Arrays.sort(c);
        for(int i = 1; i <= n; i++) {
            ans += c[n-i]*i;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}