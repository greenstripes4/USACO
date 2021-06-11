import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int size = 1;
            int idx = 1;
            int depth = 0;
            while(idx < n) {
                int next = 0;
                for(int i = 0; i < size && idx < n; i++) {
                    next++;
                    idx++;
                    while(idx < n && a[idx] > a[idx-1]) {
                        next++;
                        idx++;
                    }
                }
                depth++;
                size = next;
            }
            out.println(depth);
        }
        f.close();
        out.close();
    }
}