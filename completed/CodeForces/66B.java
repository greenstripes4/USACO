import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] h = new int[n];
        for(int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        int[] pref = new int[n];
        pref[0] = 1;
        for(int i = 1; i < n; i++) {
            if(h[i-1] <= h[i]) {
                pref[i] = pref[i-1]+1;
            } else {
                pref[i] = 1;
            }
        }
        int[] suff = new int[n];
        suff[n-1] = 1;
        for(int i = n-2; i >= 0; i--) {
            if(h[i+1] <= h[i]) {
                suff[i] = suff[i+1]+1;
            } else {
                suff[i] = 1;
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, pref[i]+suff[i]-1);
        }
        out.println(max);
        f.close();
        out.close();
    }
}