import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            int x = 0;
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                x ^= a[i];
            }
            for(int i = 0; i < n; i++) {
                if((x^a[i]) == a[i]) {
                    out.println(a[i]);
                    break;
                }
            }
        }
        f.close();
        out.close();
    }
}