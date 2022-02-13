import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        long[] a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        if(a.length == 1) {
            out.println(a[0]);
        } else if(a.length == 2) {
            out.println(a[0]|a[1]);
        } else {
            long max = 0;
            for(int i = 0; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    for(int k = j+1; k < n; k++) {
                        max = Math.max(max, a[i]|a[j]|a[k]);
                    }
                }
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
