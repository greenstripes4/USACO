import java.io.*;
import java.util.*;

public class Main {
    private static int mex(int[] a) {
        boolean[] occ = new boolean[a.length];
        for(int i: a) {
            if(i < a.length) {
                occ[i] = true;
            }
        }
        for(int i = 0; i < a.length; i++) {
            if(!occ[i]) {
                return i;
            }
        }
        return a.length;
    }
    private static int available(boolean[] flag) {
        for(int i = 0; i < flag.length; i++) {
            if(flag[i]) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            boolean[] flag = new boolean[n];
            int left = 0;
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if(a[i] != i) {
                    flag[i] = true;
                    left++;
                }
            }
            ArrayList<Integer> res = new ArrayList<>();
            while(left > 0) {
                int mex = mex(a);
                if(mex < n) {
                    res.add(mex);
                    a[mex] = mex;
                    flag[mex] = false;
                    left--;
                } else {
                    int idx = available(flag);
                    res.add(idx);
                    a[idx] = mex;
                }
            }
            out.println(res.size());
            for(int i = 0; i < res.size(); i++) {
                if(i > 0) {
                    out.print(" ");
                }
                out.print(res.get(i)+1);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
