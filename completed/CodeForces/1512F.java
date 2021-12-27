import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            int[] b = new int[n];
            for(int i = 1; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            long min = (c+a[0]-1)/a[0];
            long day = 0;
            long cur = 0;
            for(int i = 1; i < n; i++) {
                long need = (b[i]-cur+a[i-1]-1)/a[i-1];
                day += need+1;
                cur = cur+need*a[i-1]-b[i];
                min = Math.min(min, day+(c-cur+a[i]-1)/a[i]);
            }
            out.println(min);
        }
        f.close();
        out.close();
    }
}
