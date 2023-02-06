import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        int N = Integer.parseInt(f.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(f.readLine());
            set.add(x[i]);
        }
        Arrays.sort(x);
        int[] pref = new int[N];
        for(int i = 1; i < N; i++) {
            pref[i] = Math.max(pref[i-1]+1, x[i]-x[i-1]);
        }
        int[] suff = new int[N];
        for(int i = N-2; i >= 0; i--) {
            suff[i] = Math.max(suff[i+1]+1, x[i+1]-x[i]);
        }
        int min = 2000000000;
        for(int i = 0; i < N; i++) {
            min = Math.min(min, 2*Math.max(pref[i], suff[i]));
            if(i < N-1) {
                min = Math.min(min, Math.max(x[i+1]-x[i], 2*(Math.max(pref[i], suff[i+1])+1)));
            }
        }
        out.printf("%.1f\n", min/2.0);
        f.close();
        out.close();
    }
}