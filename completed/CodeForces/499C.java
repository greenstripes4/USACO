import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long x1 = Integer.parseInt(st.nextToken());
        long y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        long x2 = Integer.parseInt(st.nextToken());
        long y2 = Integer.parseInt(st.nextToken());
        int ans = 0;
        int n = Integer.parseInt(f.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            long first = a*x1+b*y1+c;
            long second = a*x2+b*y2+c;
            if(first < 0 && second > 0 || first > 0 && second < 0) {
                ans++;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
