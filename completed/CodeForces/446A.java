import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        if(n == 1) {
            out.println(1);
        } else {
            int[] l = new int[n];
            l[1] = 1;
            for(int i = 1; i < n-1; i++) {
                if(a[i] > a[i-1]) {
                    l[i+1] = l[i]+1;
                } else {
                    l[i+1] = 1;
                }
            }
            int[] r = new int[n];
            r[n-2] = 1;
            for(int i = n-2; i > 0; i--) {
                if(a[i] < a[i+1]) {
                    r[i-1] = r[i]+1;
                } else {
                    r[i-1] = 1;
                }
            }
            int max = 0;
            for(int i = 0; i < n; i++) {
                max = Math.max(max, l[i]+1);
                max = Math.max(max, r[i]+1);
                if(i == 0 || i == n-1 || a[i+1] > a[i-1]+1) {
                    max = Math.max(max, l[i]+r[i]+1);
                }
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}