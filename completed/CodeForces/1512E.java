import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken())-1;
            int r = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int[] res = new int[n];
            int max = n;
            int sum = 0;
            for(int i = l; i <= r; i++) {
                res[i] = max--;
                sum += res[i];
            }
            if(sum < s) {
                out.println(-1);
                continue;
            }
            for(int min = 1; min <= max && sum > s; min++) {
                int minChange = n;
                int minIdx = -1;
                int maxChange = 0;
                int maxIdx = -1;
                for(int i = l; i <= r; i++) {
                    if(res[i]-min == sum-s) {
                        minChange = sum-s;
                        minIdx = i;
                        break;
                    }
                    if(res[i]-min < minChange) {
                        minChange = res[i]-min;
                        minIdx = i;
                    }
                    if(res[i]-min > maxChange) {
                        maxChange = res[i]-min;
                        maxIdx = i;
                    }
                }
                if(minChange == sum-s) {
                    sum = s;
                    res[minIdx] = min;
                    break;
                }
                if(minChange > sum-s) {
                    continue;
                }
                if(maxChange == 0) {
                    break;
                }
                if(sum-maxChange < s) {
                    continue;
                }
                sum -= maxChange;
                res[maxIdx] = min;
            }
            if(sum != s) {
                out.println(-1);
                continue;
            }
            boolean[] used = new boolean[n+1];
            for(int i = l; i <= r; i++) {
                used[res[i]] = true;
            }
            for(int i = 0; i < l; i++) {
                for(int j = 1; j <= n; j++) {
                    if(!used[j]) {
                        res[i] = j;
                        used[j] = true;
                        break;
                    }
                }
            }
            for(int i = r+1; i < n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(!used[j]) {
                        res[i] = j;
                        used[j] = true;
                        break;
                    }
                }
            }
            out.print(res[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + res[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}