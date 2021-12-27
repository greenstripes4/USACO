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
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int size = n/m+1;
            int num = n%m;
            ArrayList<Integer>[][] tables = new ArrayList[k][m];
            for(int i = 0; i < k; i++) {
                for(int j = 0; j < m; j++) {
                    tables[i][j] = new ArrayList<>();
                }
            }
            int idx = 0;
            for(int i = 0; i < k; i++) {
                for(int j = 0; j < num; j++) {
                    for(int l = 0; l < size; l++) {
                        tables[i][j].add(++idx);
                        idx %= n;
                    }
                }
                int temp = idx;
                for(int j = num; j < m; j++) {
                    for(int l = 0; l < size-1; l++) {
                        tables[i][j].add(++temp);
                        temp %= n;
                    }
                }
            }
            for(int i = 0; i < k; i++) {
                for(int j = 0; j < m; j++) {
                    out.print(tables[i][j].size());
                    for(int l: tables[i][j]) {
                        out.print(" " + l);
                    }
                    out.println();
                }
            }
        }
        f.close();
        out.close();
    }
}
