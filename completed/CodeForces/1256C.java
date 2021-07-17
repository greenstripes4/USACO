import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] c = new int[m];
        for(int i = 0; i < m; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        int[] start = new int[m];
        int end = 0;
        for(int i = 0; i < m; i++) {
            start[i] = end+d;
            end = start[i]+c[i]-1;
        }
        if(end+d <= n) {
            out.println("NO");
        } else {
            int last = m-1;
            int limit = n;
            while(last >= 0 && start[last]+c[last]-1 > limit) {
                start[last] = limit-c[last]+1;
                limit = start[last]-1;
                last--;
            }
            int[] res = new int[n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < c[i]; j++) {
                    res[start[i]+j-1] = i+1;
                }
            }
            out.println("YES");
            out.print(res[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + res[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}