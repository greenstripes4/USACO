import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] row = new int[100];
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            for(int j = 0; j < a; j++) {
                row[j]++;
            }
        }
        int[] res = new int[n];
        for(int i = 0; i < 100; i++) {
            for(int j = n-1; j >= n-row[i]; j--) {
                res[j]++;
            }
        }
        out.print(res[0]);
        for(int i = 1; i < n; i++) {
            out.print(" " + res[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}