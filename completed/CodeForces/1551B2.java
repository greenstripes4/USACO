import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            int[] occ = new int[n+1];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                occ[a[i]]++;
            }
            ArrayList<Integer>[] colors = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                colors[i] = new ArrayList<>();
            }
            int[] freq = new int[k];
            int idx = 0;
            for(int i = 1; i <= n; i++) {
                if(occ[i] >= k) {
                    for(int j = 0; j < k; j++) {
                        colors[i].add(j);
                        freq[j]++;
                    }
                } else {
                    for(int j = 0; j < occ[i]; j++) {
                        colors[i].add(idx);
                        freq[idx]++;
                        idx = (idx+1)%k;
                    }
                }
            }
            int[] count = new int[k];
            int[] pointers = new int[n+1];
            for(int i = 0; i < n; i++) {
                if(i > 0) {
                    out.print(" ");
                }
                if(pointers[a[i]] < colors[a[i]].size()) {
                    int temp = colors[a[i]].get(pointers[a[i]]);
                    if(count[temp] < freq[idx]) {
                        out.print(temp+1);
                        count[temp]++;
                    } else {
                        out.print(0);
                    }
                    pointers[a[i]]++;
                } else {
                    out.print(0);
                }
            }
            out.println();
        }
        f.close();
        out.close();
    }
}