import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] p;
    private static int[] index;
    private static ArrayList<String> swaps;
    private static void swap(int a, int b) {
        if(a == b) {
            return;
        }
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if(2*(b-a) >= n) {
            swaps.add(a + " " + b);
        } else if(2*(a-1) >= n) {
            swaps.add("1 " + a);
            swaps.add("1 " + b);
            swaps.add("1 " + a);
        } else if(2*(n-b) >= n) {
            swaps.add(b + " " + n);
            swaps.add(a + " " + n);
            swaps.add(b + " " + n);
        } else {
            swaps.add("1 " + b);
            swaps.add(a + " " + n);
            swaps.add("1 " + n);
            swaps.add("1 " + b);
            swaps.add(a + " " + n);
        }
        index[p[a]] = b;
        index[p[b]] = a;
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        p = new int[n+1];
        index = new int[n+1];
        for(int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            index[p[i]] = i;
        }
        swaps = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            swap(i, index[i]);
        }
        out.println(swaps.size());
        for(String i: swaps) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}