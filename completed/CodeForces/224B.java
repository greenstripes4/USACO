import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Integer> occ = new HashMap<>();
        int i = 0;
        int j = 0;
        int l = -1;
        int r = -1;
        while(j < n) {
            while(j < n && occ.size() < k) {
                occ.put(a[j], occ.getOrDefault(a[j], 0)+1);
                j++;
            }
            if(occ.size() < k) {
                break;
            }
            while(i < j && occ.size() == k) {
                occ.put(a[i], occ.get(a[i])-1);
                if(occ.get(a[i]) == 0) {
                    occ.remove(a[i]);
                }
                i++;
            }
            if(l == -1 || j-i < r-l) {
                l = i;
                r = j;
            }
        }
        out.println(l + " " + r);
        f.close();
        out.close();
    }
}