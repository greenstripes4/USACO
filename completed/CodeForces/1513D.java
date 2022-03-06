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
            int p = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            Integer[] idx = new Integer[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                idx[i] = i;
            }
            Arrays.sort(idx, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return a[integer]-a[t1];
                }
            });
            boolean[] visited = new boolean[n];
            long cnt = n;
            long ans = 0;
            for(int i: idx) {
                if(a[i] >= p) {
                    break;
                }
                if(visited[i]) {
                    continue;
                }
                visited[i] = true;
                int left = i-1;
                while(left >= 0 && a[left]%a[i] == 0) {
                    ans += a[i];
                    cnt--;
                    if(visited[left]) {
                        break;
                    }
                    visited[left] = true;
                    left--;
                }
                int right = i+1;
                while(right < n && a[right]%a[i] == 0) {
                    ans += a[i];
                    cnt--;
                    if(visited[right]) {
                        break;
                    }
                    visited[right] = true;
                    right++;
                }
            }
            out.println(ans+(cnt-1)*p);
        }
        f.close();
        out.close();
    }
}