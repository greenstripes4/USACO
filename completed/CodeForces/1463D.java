import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            TreeSet<Integer> left = new TreeSet<>();
            for(int i = 1; i <= 2*n; i++) {
                left.add(i);
            }
            int[] b = new int[n];
            for(int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
                left.remove(b[i]);
            }
            int[] a = new int[n];
            int idx = 0;
            for(int i: left) {
                a[idx++] = i;
            }
            int x = 0;
            idx = 0;
            for(int i = 0; i < n; i++) {
                if(a[i] > b[idx]) {
                    x++;
                    idx++;
                }
            }
            int y = 0;
            idx = 0;
            for(int i = 0; i < n; i++) {
                if(a[idx] < b[i]) {
                    y++;
                    idx++;
                }
            }
            out.println(Math.max(0, x-(n-y)+1));
        }
        f.close();
        out.close();
    }
}
