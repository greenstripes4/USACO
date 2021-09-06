import java.io.*;
import java.util.*;

public class Main {
    private static int sum(long x) {
        int ans = 0;
        while(x > 0) {
            ans += x%10;
            x /= 10;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long n = Long.parseLong(f.readLine());
        long min = Long.MAX_VALUE;
        for(int i = 1; i <= 100; i++) {
            long root = (((long) Math.sqrt(i*i+4*n))-i)/2;
            if(root*root+i*root == n && sum(root) == i) {
                min = Math.min(min, root);
            }
        }
        if(min < Long.MAX_VALUE) {
            out.println(min);
        } else {
            out.println(-1);
        }
        f.close();
        out.close();
    }
}