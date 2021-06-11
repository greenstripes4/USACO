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
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] a = new int[m][];
            int[] used = new int[n+1];
            int[] res = new int[m];
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                int k = Integer.parseInt(st.nextToken());
                a[i] = new int[k];
                for(int j = 0; j < k; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
                if(k == 1) {
                    used[a[i][0]]++;
                    res[i] = a[i][0];
                }
            }
            boolean flag = false;
            for(int i = 1; i <= n; i++) {
                if(used[i] > (m+1)/2) {
                    flag = true;
                    out.println("NO");
                    break;
                }
            }
            if(flag) {
                continue;
            }
            out.println("YES");
            for(int i = 0; i < m; i++) {
                if(res[i] == 0) {
                    for(int j = 0; j < a[i].length; j++) {
                        if(used[a[i][j]] < (m+1)/2) {
                            used[a[i][j]]++;
                            res[i] = a[i][j];
                            break;
                        }
                    }
                }
            }
            out.print(res[0]);
            for(int i = 1; i < m; i++) {
                out.print(" " + res[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}