import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException{
                //BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                StringTokenizer st = new StringTokenizer(f.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int min = n-1;
                int max = 2*(n+1);
                if(m < min || m > max) {
                        out.println(-1);
                } else {
                        if(m <= 2*(n-1)) {
                                int[] occ = new int[n-1];
                                int idx = 0;
                                for(int i = 0; i < m; i++) {
                                        occ[idx]++;
                                        idx = (idx+1)%(n-1);
                                }
                                out.print(0);
                                for(int i = 0; i < n-1; i++) {
                                        for(int j = 0; j < occ[i]; j++) {
                                                out.print(1);
                                        }
                                        out.print(0);
                                }
                                out.println();
                        } else {
                                int[] occ = new int[n+1];
                                int idx = 0;
                                for(int i = 0; i < m; i++) {
                                        occ[idx]++;
                                        idx = (idx+1)%(n+1);
                                }
                                for(int i = 0; i < n; i++) {
                                        for(int j = 0; j < occ[i]; j++) {
                                                out.print(1);
                                        }
                                        out.print(0);
                                }
                                for(int j = 0; j < occ[n]; j++) {
                                        out.print(1);
                                }
                                out.println();
                        }
                }
                f.close();
                out.close();
    }
}
