import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            res.add(1);
        }
        res.add(n);
        for(int i = 0; i < k-1; i++) {
            res.add(n+1);
        }
        if(k == 1 && n <= m+1) {
            res.add(2*n-1);
            if(n == 2 && m == 2) {
                res.add(2*n);
            }
        } else if(n == m) {
            res.add(2*n);
        }
        out.println(res.size());
        out.print(res.get(0));
        for(int i = 1; i < res.size(); i++) {
            out.print(" " + res.get(i));
        }
        out.println();
        f.close();
        out.close();
    }
}