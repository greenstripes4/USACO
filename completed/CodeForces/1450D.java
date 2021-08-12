import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            TreeMap<Integer, Integer> occ = new TreeMap<>();
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                occ.put(a[i], occ.getOrDefault(a[i], 0)+1);
            }
            char[] res = new char[n];
            res[0] = occ.size() == n ? '1' : '0';
            int i = 0;
            int j = n-1;
            int k;
            for(k = 1; k < n;) {
                if(occ.firstKey() == k) {
                    res[n-k] = '1';
                    if(a[i] == k) {
                        occ.put(k, occ.get(k)-1);
                        if(occ.get(k) == 0) {
                            occ.remove(k);
                        }
                        i++;
                        k++;
                    } else if(a[j] == k) {
                        occ.put(k, occ.get(k)-1);
                        if(occ.get(k) == 0) {
                            occ.remove(k);
                        }
                        j--;
                        k++;
                    } else {
                        k++;
                        break;
                    }
                } else {
                    break;
                }
            }
            while(k < n) {
                res[n-k] = '0';
                k++;
            }
            out.println(res);
        }
        f.close();
        out.close();
    }
}
