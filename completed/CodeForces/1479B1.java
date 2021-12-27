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
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int last1 = 0;
        int last2 = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(last1 == last2) {
                if(a[i] != last1) {
                    ans++;
                }
                last1 = a[i];
            } else if(a[i] == last1) {
                ans++;
                last2 = a[i];
            } else if(a[i] == last2) {
                ans++;
                last1 = a[i];
            } else if(i < n-1 && a[i+1] == last1) {
                ans++;
                last1 = a[i];
            } else {
                ans++;
                last2 = a[i];
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
