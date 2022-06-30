import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int k = Integer.parseInt(f.readLine());
        int a = 3;
        while(a*(a-1)*(a-2)/6 <= k) {
            a++;
        }
        a--;
        int left = k-a*(a-1)*(a-2)/6;
        ArrayList<Integer> b = new ArrayList<>();
        while(left > 0) {
            int max = 2;
            while(max*(max-1)/2 <= left) {
                max++;
            }
            max--;
            left -= max*(max-1)/2;
            b.add(max);
        }
        int n = a+b.size();
        int[][] res = new int[n][n];
        for(int i = 0; i < a; i++) {
            for(int j = i+1; j < a; j++) {
                res[i][j] = res[j][i] = 1;
            }
        }
        for(int i = a; i < n; i++) {
            for(int j = 0; j < b.get(i-a); j++) {
                res[i][j] = res[j][i] = 1;
            }
        }
        out.println(n);
        for(int[] i: res) {
            for(int j: i) {
                out.print(j);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}