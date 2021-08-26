import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int cur = a[0];
        long cnt = 0;
        long ans = 0;
        for(int i: a) {
            if(i == cur) {
                cnt++;
            } else {
                ans += cnt*(cnt+1)/2;
                cur = i;
                cnt = 1;
            }
        }
        ans += cnt*(cnt+1)/2;
        out.println(ans);
        f.close();
        out.close();
    }
}