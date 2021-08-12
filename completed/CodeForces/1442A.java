import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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
            int i = 0;
            int temp = a[0];
            boolean flag = false;
            while(i < n) {
                if(i > 0 && a[i] < a[i-1]) {
                    flag = true;
                    break;
                }
                temp = Math.min(temp, a[i]);
                if(i > 0) {
                    temp = Math.min(temp, a[i]-a[i-1]);
                }
                a[i] -= temp;
                i++;
            }
            if(flag) {
                out.println("NO");
                continue;
            }
            for(int j = n-2; j >= 0; j--) {
                if(a[j] > a[j+1]) {
                    flag = true;
                    break;
                }
            }
            out.println(flag ? "NO" : "YES");
        }
        f.close();
        out.close();
    }
}
