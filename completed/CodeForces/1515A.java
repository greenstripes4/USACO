import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] w = new int[n];
            for(int i = 0; i < n; i++) {
                w[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(w);
            int sum = 0;
            boolean valid = true;
            for(int i = 0; i < n; i++) {
                sum += w[i];
                if(sum == x) {
                    if(i == n-1) {
                        valid = false;
                        break;
                    }
                    int temp = w[i];
                    w[i] = w[i+1];
                    w[i+1] = temp;
                    break;
                }
            }
            if(valid) {
                out.println("YES");
                out.print(w[0]);
                for(int i = 1; i < n; i++) {
                    out.print(" " + w[i]);
                }
                out.println();
            } else {
                out.println("NO");
            }
        }
        f.close();
        out.close();
    }
}