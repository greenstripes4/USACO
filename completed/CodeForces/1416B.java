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
            int[] a = new int[n+1];
            int sum = 0;
            for(int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                sum += a[i];
            }
            if(sum%n > 0) {
                out.println(-1);
            } else {
                ArrayList<String> res = new ArrayList<>();
                for(int i = 2; i <= n; i++) {
                    int diff = (a[i]+i-1)/i*i-a[i];
                    res.add("1 " + i + " " + diff);
                    res.add(i + " 1 " + (a[i]+i-1)/i);
                }
                for(int i = 2; i <= n; i++) {
                    res.add("1 " + i + " " + sum/n);
                }
                out.println(res.size());
                for(String i: res) {
                    out.println(i);
                }
            }
        }
        f.close();
        out.close();
    }
}