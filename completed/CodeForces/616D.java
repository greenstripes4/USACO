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
        int[] a = new int[n];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Integer> seen = new HashMap<>();
        int i = 0;
        int j = 0;
        int l = 0;
        int r = -1;
        while(j < n) {
            if(seen.size() <= k) {
                if(j-i > r-l+1) {
                    l = i+1;
                    r = j;
                }
                seen.put(a[j], seen.getOrDefault(a[j], 0)+1);
                j++;
            } else {
                while(seen.size() > k) {
                    seen.put(a[i], seen.get(a[i])-1);
                    if(seen.get(a[i]) == 0) {
                        seen.remove(a[i]);
                    }
                    i++;
                }
            }
        }
        while(seen.size() > k) {
            seen.put(a[i], seen.get(a[i])-1);
            if(seen.get(a[i]) == 0) {
                seen.remove(a[i]);
            }
            i++;
        }
        if(j-i > r-l+1) {
            l = i+1;
            r = j;
        }
        out.println(l + " " + r);
        f.close();
        out.close();
    }
}
