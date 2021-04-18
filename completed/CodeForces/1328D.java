import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int q = Integer.parseInt(f.readLine());
        for(int t = 0; t < q; t++) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            boolean same = true;
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if(i > 0 && a[i] != a[i-1]) {
                    same = false;
                }
            }
            if(same) {
                out.println(1);
                out.print(1);
                for(int i = 0; i < n-1; i++) {
                    out.print(" 1");
                }
                out.println();
            } else if(n%2 == 0) {
                out.println(2);
                out.print(1);
                for(int i = 1; i < n; i++) {
                    out.print(" " + (i%2+1));
                }
                out.println();
            } else {
                int start = a[0] == a[n-1] ? 0 : -1;
                for(int i = 1; i < n; i++) {
                    if(a[i] == a[i-1]) {
                        start = i;
                        break;
                    }
                }

                if(start < 0) {
                    out.println(3);
                    for(int i = 0; i < n-1; i++) {
                        out.print((i%2+1) + " ");
                    }
                    out.print(3);
                    out.println();
                } else {
                    out.println(2);
                    int[] ans = new int[n];
                    for(int i = 0; i < n; i++) {
                        ans[(start+i)%n] = i%2+1;
                    }
                    out.print(ans[0]);
                    for(int i = 1; i < n; i++) {
                        out.print(" " + ans[i]);
                    }
                    out.println();
                }
            }
        }
        f.close();
        out.close();
    }
}