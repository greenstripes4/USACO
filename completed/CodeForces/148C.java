import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        if(n == 1) {
            out.println(1);
        } else {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] res = new int[n];
            res[0] = 1;
            boolean flag = false;
            for(int i = 1; i <= b; i++) {
                res[i] = 1 << i;
                if(res[i] > 50000) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                out.println(-1);
            } else {
                if(res[b] == 1) {
                    res[1] = 1;
                    b++;
                }
                for(int i = b+1; i <= b+a; i++) {
                    if(i >= n) {
                        flag = true;
                        break;
                    }
                    res[i] = res[i-1]+1;
                    if(res[i] > 50000) {
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    out.println(-1);
                } else {
                    for(int i = b+a+1; i < n; i++) {
                        res[i] = 1;
                    }
                    out.print(res[0]);
                    for(int i = 1; i < n; i++) {
                        out.print(" " + res[i]);
                    }
                    out.println();
                }
            }
        }
        f.close();
        out.close();
    }
}