import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int prev = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int next = y2 > y1 ? 0 : x2 < x1 ? 1 : y2 < y1 ? 2 : 3;
            if(next == (prev+1)%4) {
                ans++;
            }
            x1 = x2;
            y1 = y2;
            prev = next;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}